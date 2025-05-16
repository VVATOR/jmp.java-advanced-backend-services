package com.epam.jmp.jabs.module2.task1.grpc.pingpong.server.config;

import io.grpc.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandLineRunnerConfig {
    private static final Logger logger = LoggerFactory.getLogger(CommandLineRunnerConfig.class);

    @Bean
    public CommandLineRunner commandLineRunner(Server server) {
        return args -> {
            server.start();
            logger.info("gRPC server started on port " + server.getPort());
            server.awaitTermination();
        };
    }
}