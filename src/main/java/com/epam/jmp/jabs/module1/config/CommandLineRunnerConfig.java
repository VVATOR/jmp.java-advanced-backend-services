package com.epam.jmp.jabs.module1.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CommandLineRunnerConfig {
    private static final Logger log = LoggerFactory.getLogger(CommandLineRunnerConfig.class);

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args ->
                log.info("Hello world!");
    }
}