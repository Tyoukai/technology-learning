package grpc.client;

import java.util.concurrent.TimeUnit;

import grpc.generated.parameter.TransferAccountRequest;
import grpc.generated.parameter.TransferAccountResponse;
import grpc.generated.service.TransferAccountServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-06-23
 */
public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = null;
        try {
            channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
            TransferAccountServiceGrpc.TransferAccountServiceBlockingStub stub = TransferAccountServiceGrpc.newBlockingStub(channel);

            TransferAccountResponse response = stub.transferAccount(TransferAccountRequest
                    .newBuilder()
                    .setAmount(11)
                    .setFromUserId("zkw")
                    .setToUserId("wang")
                    .setTimestamp(334)
                    .build());

            System.out.println(response.getCode() + "," + response.getMsg());
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
