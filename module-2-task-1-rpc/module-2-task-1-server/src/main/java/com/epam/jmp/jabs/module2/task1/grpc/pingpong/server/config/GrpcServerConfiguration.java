package com.epam.jmp.jabs.module2.task1.grpc.pingpong.server.config;

import com.epam.jmp.jabs.module2.task1.grpc.pingpong.server.service.GrpcService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcServerConfiguration {
    @Value("${grpc.server.port:8080}")
    private int serverPort;

    @Bean
    public Server getGrpsServer(GrpcService grpsService) {
        return ServerBuilder.forPort(serverPort)
                .addService(grpsService)
                .build();
    }
}