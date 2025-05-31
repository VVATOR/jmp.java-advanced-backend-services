package com.epam.jmp.jabs.module2.task1.grpc.pingpong.server.service;

import com.epam.jmp.jabs.module2.task1.grpc.pingpong.proto.PingPongProto;
import com.epam.jmp.jabs.module2.task1.grpc.pingpong.proto.PingPongServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GrpcService extends PingPongServiceGrpc.PingPongServiceImplBase {
    private static final Logger logger = LoggerFactory.getLogger(GrpcService.class);

    @Override
    public void sendMessage(PingPongProto.PingRequest request, StreamObserver<PingPongProto.PongResponse> responseObserver) {
        logger.info(request.getMessage());
        PingPongProto.PongResponse response = PingPongProto.PongResponse.newBuilder()
                .setMessage("Pong")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}