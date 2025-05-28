package com.epam.jmp.jabs.module1.monitoring.prometheus;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class ProductPrometheusMetric {
    private final Counter productAccessCounter;

    public ProductPrometheusMetric(MeterRegistry meterRegistry) {
        this.productAccessCounter = Counter.builder("products.get.access.count")
                .description("Number of times products have been accessed")
                        .tag("method", "GET")
                        .tag("endpoint", "/api/v1/products")
                        .register(meterRegistry);
    }

    public void incrementAccess() {
        productAccessCounter.increment();
    }
}