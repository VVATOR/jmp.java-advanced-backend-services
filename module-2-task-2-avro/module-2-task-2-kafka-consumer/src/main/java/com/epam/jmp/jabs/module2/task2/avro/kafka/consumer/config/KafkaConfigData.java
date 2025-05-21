package com.epam.jmp.jabs.module2.task2.avro.kafka.consumer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
@ConfigurationProperties(prefix = "kafka-config")
public class KafkaConfigData {
    private String bootstrapServers;
    private String schemaRegistryUrlKey;
    private String schemaRegistryUrl;
    private String topicName;

    public KafkaConfigData() {
        super();
    }

    public KafkaConfigData(String bootstrapServers, String schemaRegistryUrlKey, String schemaRegistryUrl, String topicName) {
        this.bootstrapServers = bootstrapServers;
        this.schemaRegistryUrlKey = schemaRegistryUrlKey;
        this.schemaRegistryUrl = schemaRegistryUrl;
        this.topicName = topicName;
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getSchemaRegistryUrlKey() {
        return schemaRegistryUrlKey;
    }

    public void setSchemaRegistryUrlKey(String schemaRegistryUrlKey) {
        this.schemaRegistryUrlKey = schemaRegistryUrlKey;
    }

    public String getSchemaRegistryUrl() {
        return schemaRegistryUrl;
    }

    public void setSchemaRegistryUrl(String schemaRegistryUrl) {
        this.schemaRegistryUrl = schemaRegistryUrl;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        KafkaConfigData that = (KafkaConfigData) o;
        return Objects.equals(bootstrapServers, that.bootstrapServers) && Objects.equals(schemaRegistryUrlKey, that.schemaRegistryUrlKey) && Objects.equals(schemaRegistryUrl, that.schemaRegistryUrl) && Objects.equals(topicName, that.topicName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bootstrapServers, schemaRegistryUrlKey, schemaRegistryUrl, topicName);
    }
}
