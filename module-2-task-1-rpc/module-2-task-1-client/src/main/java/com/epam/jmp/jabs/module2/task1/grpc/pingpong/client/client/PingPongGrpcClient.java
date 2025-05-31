package com.epam.jmp.jabs.module2.task1.grpc.pingpong.client.client;

import com.epam.jmp.jabs.module2.task1.grpc.pingpong.proto.PingPongProto;
import com.epam.jmp.jabs.module2.task1.grpc.pingpong.proto.PingPongServiceGrpc;
import io.grpc.ManagedChannelBuilder;

public class PingPongGrpcClient {
    private final String host;
    private final int port;

    public PingPongGrpcClient(String host, int port) {
        this.port = port;
        this.host = host;
    }

    public void sendPing() {
        final var channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        try {
            PingPongServiceGrpc.PingPongServiceBlockingStub stub =
                    PingPongServiceGrpc.newBlockingStub(channel);

            PingPongProto.PingRequest request = PingPongProto.PingRequest.newBuilder()
                    .setMessage("Ping")
                    .build();

            PingPongProto.PongResponse response = stub.sendMessage(request);
            System.out.println("Server response: " + response.getMessage());
        } finally {
            if (channel != null) {
                channel.shutdownNow();
            }
        }
    }
}