package grpc.generated.service;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.0)",
    comments = "Source: transfer_account_service.proto")
public final class TransferAccountServiceGrpc {

  private TransferAccountServiceGrpc() {}

  public static final String SERVICE_NAME = "transfer.account.TransferAccountService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.generated.parameter.TransferAccountRequest,
      grpc.generated.parameter.TransferAccountResponse> getTransferAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "transferAccount",
      requestType = grpc.generated.parameter.TransferAccountRequest.class,
      responseType = grpc.generated.parameter.TransferAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.generated.parameter.TransferAccountRequest,
      grpc.generated.parameter.TransferAccountResponse> getTransferAccountMethod() {
    io.grpc.MethodDescriptor<grpc.generated.parameter.TransferAccountRequest, grpc.generated.parameter.TransferAccountResponse> getTransferAccountMethod;
    if ((getTransferAccountMethod = TransferAccountServiceGrpc.getTransferAccountMethod) == null) {
      synchronized (TransferAccountServiceGrpc.class) {
        if ((getTransferAccountMethod = TransferAccountServiceGrpc.getTransferAccountMethod) == null) {
          TransferAccountServiceGrpc.getTransferAccountMethod = getTransferAccountMethod =
              io.grpc.MethodDescriptor.<grpc.generated.parameter.TransferAccountRequest, grpc.generated.parameter.TransferAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "transferAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.parameter.TransferAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.parameter.TransferAccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TransferAccountServiceMethodDescriptorSupplier("transferAccount"))
              .build();
        }
      }
    }
    return getTransferAccountMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TransferAccountServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransferAccountServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TransferAccountServiceStub>() {
        @java.lang.Override
        public TransferAccountServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TransferAccountServiceStub(channel, callOptions);
        }
      };
    return TransferAccountServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TransferAccountServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransferAccountServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TransferAccountServiceBlockingStub>() {
        @java.lang.Override
        public TransferAccountServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TransferAccountServiceBlockingStub(channel, callOptions);
        }
      };
    return TransferAccountServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TransferAccountServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransferAccountServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TransferAccountServiceFutureStub>() {
        @java.lang.Override
        public TransferAccountServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TransferAccountServiceFutureStub(channel, callOptions);
        }
      };
    return TransferAccountServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TransferAccountServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void transferAccount(grpc.generated.parameter.TransferAccountRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.parameter.TransferAccountResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTransferAccountMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTransferAccountMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.generated.parameter.TransferAccountRequest,
                grpc.generated.parameter.TransferAccountResponse>(
                  this, METHODID_TRANSFER_ACCOUNT)))
          .build();
    }
  }

  /**
   */
  public static final class TransferAccountServiceStub extends io.grpc.stub.AbstractAsyncStub<TransferAccountServiceStub> {
    private TransferAccountServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransferAccountServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransferAccountServiceStub(channel, callOptions);
    }

    /**
     */
    public void transferAccount(grpc.generated.parameter.TransferAccountRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.parameter.TransferAccountResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTransferAccountMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TransferAccountServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TransferAccountServiceBlockingStub> {
    private TransferAccountServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransferAccountServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransferAccountServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.generated.parameter.TransferAccountResponse transferAccount(grpc.generated.parameter.TransferAccountRequest request) {
      return blockingUnaryCall(
          getChannel(), getTransferAccountMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TransferAccountServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TransferAccountServiceFutureStub> {
    private TransferAccountServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransferAccountServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransferAccountServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.generated.parameter.TransferAccountResponse> transferAccount(
        grpc.generated.parameter.TransferAccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTransferAccountMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TRANSFER_ACCOUNT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TransferAccountServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TransferAccountServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TRANSFER_ACCOUNT:
          serviceImpl.transferAccount((grpc.generated.parameter.TransferAccountRequest) request,
              (io.grpc.stub.StreamObserver<grpc.generated.parameter.TransferAccountResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TransferAccountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TransferAccountServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.generated.service.TransferAccountServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TransferAccountService");
    }
  }

  private static final class TransferAccountServiceFileDescriptorSupplier
      extends TransferAccountServiceBaseDescriptorSupplier {
    TransferAccountServiceFileDescriptorSupplier() {}
  }

  private static final class TransferAccountServiceMethodDescriptorSupplier
      extends TransferAccountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TransferAccountServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TransferAccountServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TransferAccountServiceFileDescriptorSupplier())
              .addMethod(getTransferAccountMethod())
              .build();
        }
      }
    }
    return result;
  }
}
