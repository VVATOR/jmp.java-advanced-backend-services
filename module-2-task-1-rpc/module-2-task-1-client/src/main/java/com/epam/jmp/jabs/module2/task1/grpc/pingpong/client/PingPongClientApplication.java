package com.epam.jmp.jabs.module2.task1.grpc.pingpong.client;

import com.epam.jmp.jabs.module2.task1.grpc.pingpong.client.client.PingPongGrpcClient;

public class PingPongClientApplication {
    public static void main(String[] args) {
        final var client = new PingPongGrpcClient("localhost", 8080);
        for (int i = 0; i < 10; i++) {
            client.sendPing();
        }
    }
}