package com.epam.jmp.jabs.module2.task2.avro.kafka.producer.producer;

import com.epam.jmp.jabs.module2.task2.avro.kafka.producer.config.KafkaConfigData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {
    private static final Logger log = LoggerFactory.getLogger(UserProducer.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaConfigData kafkaConfigData;

    public UserProducer(KafkaTemplate<String, Object> kafkaTemplate, KafkaConfigData kafkaConfigData) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaConfigData = kafkaConfigData;
    }

    public void send(Object user) {
        log.info("sending user='{}'", user.toString());
        log.info(String.format("Producing message -> %s", user));
        kafkaTemplate.send(kafkaConfigData.getTopicName(), user);
    }
}