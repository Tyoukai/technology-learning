package grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.reflection.v1alpha.ServerReflectionGrpc;
import io.grpc.reflection.v1alpha.ServerReflectionRequest;
import io.grpc.reflection.v1alpha.ServerReflectionResponse;
import io.grpc.stub.StreamObserver;

/**
 * grpc反射相关类
 */
public class ReflectionGrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 50051)
                .usePlaintext()
                .build();

        ServerReflectionGrpc.ServerReflectionStub stub = ServerReflectionGrpc.newStub(channel);
        StreamObserver<ServerReflectionResponse> streamObserver = new StreamObserver<ServerReflectionResponse>() {
            @Override
            public void onNext(ServerReflectionResponse response) {
                // 处理响应
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
            }
        };
        StreamObserver<ServerReflectionRequest> requestStreamObserver= stub.serverReflectionInfo(streamObserver);
    }


}
