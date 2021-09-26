package grpc.server;

import grpc.generated.parameter.TransferAccountRequest;
import grpc.generated.parameter.TransferAccountResponse;
import grpc.generated.service.TransferAccountServiceGrpc.TransferAccountServiceImplBase;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-06-23
 */
public class TransferAccountServiceImpl extends TransferAccountServiceImplBase implements Register{

    private int port;

    private CuratorFramework curatorClient;

    public TransferAccountServiceImpl(int port) throws Exception {
        this.port = port;
        curatorClient = CuratorFrameworkFactory.builder()
                .connectString(connectString)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();
        curatorClient.start();
        InetAddress ip = InetAddress.getLocalHost();
        curatorClient.create().withMode(CreateMode.EPHEMERAL)
                .forPath(registerPath + getServiceName() + "/" + ip.getHostAddress() + ":" + port);
    }

    @Override
    public void transferAccount(TransferAccountRequest request,
            io.grpc.stub.StreamObserver<TransferAccountResponse> responseObserver) {
//        System.out.println(request.toString() );
        System.out.println("port:" + port);
        TransferAccountResponse response = TransferAccountResponse.newBuilder()
                .setCode(0)
                .setMsg("success")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void register() {

    }

    @Override
    public String getServiceName() {
        return "grpc_TransferAccountService";
    }
}
