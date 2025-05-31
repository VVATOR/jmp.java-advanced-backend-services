package com.epam.jmp.jabs.module2.task2.avro.kafka.producer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;


@Configuration
@ConfigurationProperties(prefix = "kafka-producer-config")
public class KafkaProducerConfigData {
    private String keySerializerClass;
    private String valueSerializerClass;

    public KafkaProducerConfigData() {
        super();
    }

    public KafkaProducerConfigData(String valueSerializerClass, String keySerializerClass) {
        this.valueSerializerClass = valueSerializerClass;
        this.keySerializerClass = keySerializerClass;
    }

    public String getValueSerializerClass() {
        return valueSerializerClass;
    }

    public void setValueSerializerClass(String valueSerializerClass) {
        this.valueSerializerClass = valueSerializerClass;
    }

    public String getKeySerializerClass() {
        return keySerializerClass;
    }

    public void setKeySerializerClass(String keySerializerClass) {
        this.keySerializerClass = keySerializerClass;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        KafkaProducerConfigData that = (KafkaProducerConfigData) o;
        return Objects.equals(keySerializerClass, that.keySerializerClass) && Objects.equals(valueSerializerClass, that.valueSerializerClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keySerializerClass, valueSerializerClass);
    }
}