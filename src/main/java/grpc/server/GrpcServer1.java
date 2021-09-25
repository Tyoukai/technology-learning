package grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer1 {
    public static void main(String[] args) {
        try {

            int port = 50052;
            final Server server = ServerBuilder.forPort(port)
                    .addService(new TransferAccountServiceImpl(port))
                    .build()
                    .start();
            System.out.println("Server started, listening on " + port);
            server.awaitTermination();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
