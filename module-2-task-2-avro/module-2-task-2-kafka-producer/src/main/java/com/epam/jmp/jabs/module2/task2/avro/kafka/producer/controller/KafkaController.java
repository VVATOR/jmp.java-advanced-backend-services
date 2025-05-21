package com.epam.jmp.jabs.module2.task2.avro.kafka.producer.controller;

import com.epam.jmp.jabs.User;
import com.epam.jmp.jabs.module2.task2.avro.kafka.producer.domain.UserRequest;
import com.epam.jmp.jabs.module2.task2.avro.kafka.producer.producer.UserProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    private final UserProducer userProducer;

    public KafkaController(UserProducer userProducer) {
        this.userProducer = userProducer;
    }

    @PostMapping(value = "/v1/users")
    public void sendSchemaRegistryToKafkaTopic(@RequestBody UserRequest request) {
        User user = User
                .newBuilder()
                .setName(request.getName())
                .setFavoriteNumber(request.getFavoriteNumber())
                .setFavoriteColor(request.getFavoriteColor())
                .build();
        this.userProducer.send(user);
    }
}