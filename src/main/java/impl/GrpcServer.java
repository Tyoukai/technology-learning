package impl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-01
 */
public class GrpcServer {
    public static void main(String[] args) {
        try {

            int port = 50051;
            final Server server = ServerBuilder.forPort(port)
                    .addService(new HelloServiceImpl())
                    .build()
                    .start();
            System.out.println("Server started, listening on " + port);
            server.awaitTermination();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
