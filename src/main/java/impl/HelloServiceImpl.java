package impl;

import io.grpc.stub.StreamObserver;
import originFile.HelloRequest;
import originFile.HelloResponse;
import originFile.HelloServiceGrpc.HelloServiceImplBase;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-01
 */
public class HelloServiceImpl extends HelloServiceImplBase {
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        HelloResponse response = HelloResponse.newBuilder().setGreeting("1111").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
