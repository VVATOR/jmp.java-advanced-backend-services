package com.epam.jmp.jabs.module2.task2.avro.kafka.consumer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
@ConfigurationProperties(prefix = "kafka-consumer-config")
public class KafkaConsumerConfigData {
    private String keyDeserializer;
    private String valueDeserializer;
    private String consumerGroupId;
    private String specificAvroReaderKey;
    private String specificAvroReader;

    public KafkaConsumerConfigData() {
        super();
    }

    public KafkaConsumerConfigData(String keyDeserializer, String valueDeserializer, String consumerGroupId, String specificAvroReaderKey, String specificAvroReader) {
        this.keyDeserializer = keyDeserializer;
        this.valueDeserializer = valueDeserializer;
        this.consumerGroupId = consumerGroupId;
        this.specificAvroReaderKey = specificAvroReaderKey;
        this.specificAvroReader = specificAvroReader;
    }

    public String getKeyDeserializer() {
        return keyDeserializer;
    }

    public void setKeyDeserializer(String keyDeserializer) {
        this.keyDeserializer = keyDeserializer;
    }

    public String getValueDeserializer() {
        return valueDeserializer;
    }

    public void setValueDeserializer(String valueDeserializer) {
        this.valueDeserializer = valueDeserializer;
    }

    public String getConsumerGroupId() {
        return consumerGroupId;
    }

    public void setConsumerGroupId(String consumerGroupId) {
        this.consumerGroupId = consumerGroupId;
    }

    public String getSpecificAvroReaderKey() {
        return specificAvroReaderKey;
    }

    public void setSpecificAvroReaderKey(String specificAvroReaderKey) {
        this.specificAvroReaderKey = specificAvroReaderKey;
    }

    public String getSpecificAvroReader() {
        return specificAvroReader;
    }

    public void setSpecificAvroReader(String specificAvroReader) {
        this.specificAvroReader = specificAvroReader;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        KafkaConsumerConfigData that = (KafkaConsumerConfigData) o;
        return Objects.equals(keyDeserializer, that.keyDeserializer) && Objects.equals(valueDeserializer, that.valueDeserializer) && Objects.equals(consumerGroupId, that.consumerGroupId) && Objects.equals(specificAvroReaderKey, that.specificAvroReaderKey) && Objects.equals(specificAvroReader, that.specificAvroReader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyDeserializer, valueDeserializer, consumerGroupId, specificAvroReaderKey, specificAvroReader);
    }
}