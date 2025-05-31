package com.epam.jmp.jabs.module2.task2.avro.kafka.consumer.consumer;

import com.epam.jmp.jabs.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {
private static final Logger log = LoggerFactory.getLogger(UserConsumer.class);
    @KafkaListener(topics = "${kafka-config.topic-name}", groupId = "${kafka-consumer-config.consumer-group-id}}")
    public void consume(User message) {
        log.info(String.format("Consumed User message -> %s", message));
    }
}