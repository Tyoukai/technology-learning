package grpc.server;

import grpc.generated.parameter.TransferAccountRequest;
import grpc.generated.parameter.TransferAccountResponse;
import grpc.generated.service.TransferAccountServiceGrpc.TransferAccountServiceImplBase;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.net.InetAddress;
import java.util.Collection;
import java.util.List;

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
        // 将ip和端口写入临时节点
        curatorClient.create().withMode(CreateMode.EPHEMERAL)
                .forPath(registerPath + getServiceName() + "/" + ip.getHostAddress() + ":" + port);
        // 将服务对应的方法写入到zk中
        StringBuffer sb = new StringBuffer();
        ServerServiceDefinition definition = super.bindService();
        Collection<ServerMethodDefinition<?, ?>> methods =  definition.getMethods();
        for (ServerMethodDefinition methodDefinition : methods) {
            String fullMethodName = methodDefinition.getMethodDescriptor().getFullMethodName();
            sb.append(fullMethodName + ",");
        }
        curatorClient.setData().forPath(registerPath + getServiceName(), sb.toString().substring(0, sb.length() - 1).getBytes());
    }

    @Override
    public void transferAccount(TransferAccountRequest request,
            io.grpc.stub.StreamObserver<TransferAccountResponse> responseObserver) {
        System.out.println(request.toString() );
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
