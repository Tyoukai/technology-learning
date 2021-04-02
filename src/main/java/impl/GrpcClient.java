package impl;

import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import originFile.HelloServiceGrpc;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-01
 */
public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = null;
        try {
            channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

            HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

            originFile.HelloResponse helloResponse = stub
                    .hello(originFile.HelloRequest.newBuilder().setFirstName("Baeldung").setLastName("gRPC").build());

            System.out.println(helloResponse.getGreeting());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                try {
                    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
