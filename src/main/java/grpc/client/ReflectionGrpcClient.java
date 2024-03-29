package grpc.client;

import com.google.protobuf.*;
import com.google.protobuf.util.JsonFormat;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import io.grpc.reflection.v1alpha.ServerReflectionGrpc;
import io.grpc.reflection.v1alpha.ServerReflectionRequest;
import io.grpc.reflection.v1alpha.ServerReflectionResponse;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * grpc反射相关类
 */
public class ReflectionGrpcClient {
    public static void main(String[] args) throws InterruptedException {

        String requestContent = "{\"amount\":1,\"from_user_id\" : \"zkw111\",\"to_user_id\": \"wang\",\"timestamp\": 334}";
        String methodSymbol = "transfer.account.TransferAccountService.transferAccount";


        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        ServerReflectionGrpc.ServerReflectionStub stub = ServerReflectionGrpc.newStub(channel);
        StreamObserver<ServerReflectionResponse> responseStreamObserver = new StreamObserver<ServerReflectionResponse>() {
            @Override
            public void onNext(ServerReflectionResponse response) {
                // 处理响应
                try {
                    if (response.getMessageResponseCase() == ServerReflectionResponse.MessageResponseCase.FILE_DESCRIPTOR_RESPONSE) {
                        List<ByteString> fileDescriptorProtoList = response.getFileDescriptorResponse().getFileDescriptorProtoList();
                        handleResponse(fileDescriptorProtoList, channel, methodSymbol, requestContent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.toString());
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        };
        StreamObserver<ServerReflectionRequest> requestStreamObserver= stub.serverReflectionInfo(responseStreamObserver);

        ServerReflectionRequest request = ServerReflectionRequest.newBuilder()
                .setFileContainingSymbol(methodSymbol)
                .build();

//        Thread.sleep(2000);
        while (true) {
            requestStreamObserver.onNext(request);
            Thread.sleep(2000);
        }
    }

    private static void handleResponse(List<ByteString> fileDescriptorProtoList,
                                       ManagedChannel channel,
                                       String methodFullName,
                                       String requestContent) {
        try {
            // 解析方法和服务名称
            String fullServiceName = extraPrefix(methodFullName);
            String methodName = extraSuffix(methodFullName);
            String packageName = extraPrefix(fullServiceName);
            String serviceName = extraSuffix(fullServiceName);

            // 根据响应解析 FileDescriptor
            Descriptors.FileDescriptor fileDescriptor = getFileDescriptor(fileDescriptorProtoList, packageName, serviceName);

            // 查找服务描述
            Descriptors.ServiceDescriptor serviceDescriptor = fileDescriptor.getFile().findServiceByName(serviceName);
            // 查找方法描述
            Descriptors.MethodDescriptor methodDescriptor = serviceDescriptor.findMethodByName(methodName);

            // 发起请求
            executeCall(channel, fileDescriptor, methodDescriptor, requestContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取前缀
     */
    private static String extraPrefix(String content) {
        int index = content.lastIndexOf(".");
        return content.substring(0, index);
    }

    /**
     * 获取后缀
     */
    private static String extraSuffix(String content) {
        int index = content.lastIndexOf(".");
        return content.substring(index + 1);
    }

    private static Descriptors.FileDescriptor getFileDescriptor(List<ByteString> fileDescriptorProtoList,
                                                                String packageName,
                                                                String serviceName) throws Exception {

        Map<String, DescriptorProtos.FileDescriptorProto> fileDescriptorProtoMap =
                fileDescriptorProtoList.stream()
                        .map(bs -> {
                            try {
                                return DescriptorProtos.FileDescriptorProto.parseFrom(bs);
                            } catch (InvalidProtocolBufferException e) {
                                e.printStackTrace();
                            }
                            return null;
                        })
                        .filter(Objects::nonNull)
                        .collect(Collectors.toMap(DescriptorProtos.FileDescriptorProto::getName, f -> f));


        if (fileDescriptorProtoMap.isEmpty()) {
            throw new IllegalArgumentException("方法的文件描述不存在");
        }

        // 查找服务对应的 Proto 描述
        DescriptorProtos.FileDescriptorProto fileDescriptorProto = findServiceFileDescriptorProto(packageName, serviceName, fileDescriptorProtoMap);

        // 获取这个 Proto 的依赖
        Descriptors.FileDescriptor[] dependencies = getDependencies(fileDescriptorProto, fileDescriptorProtoMap);

        // 生成 Proto 的 FileDescriptor
        return Descriptors.FileDescriptor.buildFrom(fileDescriptorProto, dependencies);
    }

    /**
     * 根据包名和服务名查找相应的文件描述
     */
    private static DescriptorProtos.FileDescriptorProto findServiceFileDescriptorProto(String packageName,
                                                                                       String serviceName,
                                                                                       Map<String, DescriptorProtos.FileDescriptorProto> fileDescriptorProtoMap) {
        for (DescriptorProtos.FileDescriptorProto proto : fileDescriptorProtoMap.values()) {
            if (proto.getPackage().equals(packageName)) {
                boolean exist = proto.getServiceList()
                        .stream()
                        .anyMatch(s -> serviceName.equals(s.getName()));
                if (exist) {
                    return proto;
                }
            }
        }

        throw new IllegalArgumentException("服务不存在");
    }

    /**
     * 获取依赖类型
     */
    private static Descriptors.FileDescriptor[] getDependencies(DescriptorProtos.FileDescriptorProto proto,
                                                                Map<String, DescriptorProtos.FileDescriptorProto> finalDescriptorProtoMap) {
        return proto.getDependencyList()
                .stream()
                .map(finalDescriptorProtoMap::get)
                .map(f -> toFileDescriptor(f, getDependencies(f, finalDescriptorProtoMap)))
                .toArray(Descriptors.FileDescriptor[]::new);
    }

    /**
     * 将 FileDescriptorProto 转为 FileDescriptor
     */
    private static Descriptors.FileDescriptor toFileDescriptor(DescriptorProtos.FileDescriptorProto fileDescriptorProto,
                                                               Descriptors.FileDescriptor[] dependencies) {
        try {
            return Descriptors.FileDescriptor.buildFrom(fileDescriptorProto, dependencies);
        } catch (Descriptors.DescriptorValidationException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 执行方法调用
     */
    private static void executeCall(ManagedChannel channel,
                                    Descriptors.FileDescriptor fileDescriptor,
                                    Descriptors.MethodDescriptor originMethodDescriptor,
                                    String requestContent) throws Exception {

        // 重新生成 MethodDescriptor
        MethodDescriptor<DynamicMessage, DynamicMessage> methodDescriptor = generateMethodDescriptor(originMethodDescriptor);

        CallOptions callOptions = CallOptions.DEFAULT;

        JsonFormat.TypeRegistry registry = JsonFormat.TypeRegistry.newBuilder()
                .add(fileDescriptor.getMessageTypes())
                .build();

        // 将请求内容由 JSON 字符串转为相应的类型
        JsonFormat.Parser parser = JsonFormat.parser().usingTypeRegistry(registry);
        DynamicMessage.Builder messageBuilder = DynamicMessage.newBuilder(originMethodDescriptor.getInputType());
        parser.merge(requestContent, messageBuilder);
        DynamicMessage requestMessage = messageBuilder.build();

        // 调用，调用方式可以通过 originMethodDescriptor.isClientStreaming() 和 originMethodDescriptor.isServerStreaming() 推断
        DynamicMessage response = ClientCalls.blockingUnaryCall(channel, methodDescriptor, callOptions, requestMessage);

        // 将响应解析为 JSON 字符串
        JsonFormat.Printer printer = JsonFormat.printer()
                .usingTypeRegistry(registry)
                .includingDefaultValueFields();
        String responseContent = printer.print(response);
        System.out.println(responseContent);
    }

    /**
     * 重新生成方法描述
     */
    private static MethodDescriptor<DynamicMessage, DynamicMessage> generateMethodDescriptor(Descriptors.MethodDescriptor originMethodDescriptor) {
        // 生成方法全名
        String fullMethodName = MethodDescriptor.generateFullMethodName(originMethodDescriptor.getService().getFullName(), originMethodDescriptor.getName());
        // 请求和响应类型
        MethodDescriptor.Marshaller<DynamicMessage> inputTypeMarshaller = ProtoUtils.marshaller(DynamicMessage.newBuilder(originMethodDescriptor.getInputType())
                .buildPartial());
        MethodDescriptor.Marshaller<DynamicMessage> outputTypeMarshaller = ProtoUtils.marshaller(DynamicMessage.newBuilder(originMethodDescriptor.getOutputType())
                .buildPartial());

        // 生成方法描述, originMethodDescriptor 的 fullMethodName 不正确
        return MethodDescriptor.<DynamicMessage, DynamicMessage>newBuilder()
                .setFullMethodName(fullMethodName)
                .setRequestMarshaller(inputTypeMarshaller)
                .setResponseMarshaller(outputTypeMarshaller)
                // 使用 UNKNOWN，自动修改
                .setType(MethodDescriptor.MethodType.UNKNOWN)
                .build();
    }
}
