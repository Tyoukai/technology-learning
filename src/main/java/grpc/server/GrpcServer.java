package grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-06-23
 */
public class GrpcServer {
    public static void main(String[] args) {
        try {

            int port = 50051;
            final Server server = ServerBuilder.forPort(port)
                    .addService(new TransferAccountServiceImpl(port))
                    .addService(ProtoReflectionService.newInstance())
                    .build()
                    .start();
            System.out.println("Server started, listening on " + port);
            server.awaitTermination();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
