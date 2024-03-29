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
            channel = ManagedChannelBuilder
                        .forTarget("zk://42.192.49.234:2181")
                        .nameResolverFactory(new ZkNameResolverProvider("grpc_TransferAccountService"))
                        .enableRetry()
                        .maxRetryAttempts(3)
                        .keepAliveTime(5, TimeUnit.SECONDS)
                        .keepAliveWithoutCalls(true)
                        .keepAliveTimeout(10, TimeUnit.MINUTES)
                        .idleTimeout(24, TimeUnit.HOURS)
                        .defaultLoadBalancingPolicy("round_robin") // pick_first,grpclb,HealthCheckingRoundRobin
                        .usePlaintext()
                        .build();

            TransferAccountServiceGrpc.TransferAccountServiceBlockingStub stub = TransferAccountServiceGrpc.newBlockingStub(channel);

            while (true) {
                TransferAccountResponse response = stub.transferAccount(TransferAccountRequest
                        .newBuilder()
                        .setAmount(11)
                        .setFromUserId("zkw")
                        .setToUserId("wang")
                        .setTimestamp(334)
                        .build());
                System.out.println(response.getCode() + "," + response.getMsg());
                Thread.sleep(2000);
            }

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
