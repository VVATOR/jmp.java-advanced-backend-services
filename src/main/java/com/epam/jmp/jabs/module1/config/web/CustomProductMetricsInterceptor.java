package com.epam.jmp.jabs.module1.config.web;

import com.epam.jmp.jabs.module1.monitoring.prometheus.ProductPrometheusMetric;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class CustomProductMetricsInterceptor implements HandlerInterceptor {
    private final ProductPrometheusMetric metrics;

    public CustomProductMetricsInterceptor(ProductPrometheusMetric metrics) {
        this.metrics = metrics;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String uri = request.getRequestURI();
        String method = request.getMethod();
        if ("/api/v1/products".equals(uri) && HttpMethod.GET.name().equalsIgnoreCase(method)) {
            metrics.incrementAccess();
        }
        return true;
    }
}