package grpc.server;

import grpc.generated.parameter.TransferAccountRequest;
import grpc.generated.parameter.TransferAccountResponse;
import grpc.generated.service.TransferAccountServiceGrpc.TransferAccountServiceImplBase;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-06-23
 */
public class TransferAccountServiceImpl extends TransferAccountServiceImplBase {

    @Override
    public void transferAccount(TransferAccountRequest request,
            io.grpc.stub.StreamObserver<TransferAccountResponse> responseObserver) {
        System.out.println(request.toString());
        TransferAccountResponse response = TransferAccountResponse.newBuilder()
                .setCode(0)
                .setMsg("success")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
