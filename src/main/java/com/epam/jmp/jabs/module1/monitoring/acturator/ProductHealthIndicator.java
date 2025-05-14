package com.epam.jmp.jabs.module1.monitoring.acturator;

import com.epam.jmp.jabs.module1.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("product-health-indicator")
public class ProductHealthIndicator implements HealthIndicator {
    private static final Logger log = LoggerFactory.getLogger(ProductHealthIndicator.class);

    private final ProductRepository productRepository;

    public ProductHealthIndicator(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Health health() {
        final long count;
        try {
            count = productRepository.count();
        } catch (Exception e) {
            log.warn("Failed to fetch product count", e);
            return Health.unknown().build();
        }
        if (count == 0) {
            return Health.status("RED").withDetails(
                    Map.of("productCount", count,
                            "reason", "No products available")).build();
        }
        if (count < 3) {
            return Health.status("AMBER").withDetails(
                    Map.of("productCount", count)).build();
        }
        return Health.status("GREEN").withDetails(
                Map.of("productCount", count)).build();
    }
}