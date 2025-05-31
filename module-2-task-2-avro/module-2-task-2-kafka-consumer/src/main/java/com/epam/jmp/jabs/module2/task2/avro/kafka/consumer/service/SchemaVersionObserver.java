package com.epam.jmp.jabs.module2.task2.avro.kafka.consumer.service;

import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.rest.exceptions.RestClientException;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class SchemaVersionObserver {
    private static final Logger log = LoggerFactory.getLogger(SchemaVersionObserver.class);
    private static final String SCHEMA_REGISTRY_URL = "http://localhost:8081";
    private static final String TOPIC = "user-topic";
    private static final String BOOTSTRAP_SERVERS = "localhost:19092,localhost:29092,localhost:39092";

    public static void main(String[] args) throws IOException, RestClientException {
        final var props = new Properties();
        props.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        props.put("group.id", "schema-observer");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");

        try ( KafkaConsumer<String, byte[]> consumer = new KafkaConsumer<>(props)){
            consumer.subscribe(Collections.singletonList(TOPIC));
            try (final var schemaRegistry = new CachedSchemaRegistryClient(SCHEMA_REGISTRY_URL, 100)) {
                while (true) {
                    final var records = consumer.poll(Duration.ofMillis(100));
                    for (final var record : records) {
                        final var buffer = ByteBuffer.wrap(record.value());
                        if (buffer.get() == 0) {
                            final var schemaId = buffer.getInt();
                            final var schemaMetadata = schemaRegistry.getById(schemaId);
                            log.info("Received message with schema id {} from topic {}", schemaId, record.topic());
                            final var fields = new StringBuilder();
                            for (final var field : schemaMetadata.getFields()) {
                                fields.append(field.name()).append(", ");
                            }
                            log.info("Schema fields: {}", fields);
                        }
                    }
                }
            }
        }
    }
}