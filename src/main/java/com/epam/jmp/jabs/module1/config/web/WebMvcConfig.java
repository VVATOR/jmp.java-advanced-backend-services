package com.epam.jmp.jabs.module1.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final CustomProductMetricsInterceptor customProductMetricsInterceptor;

    public WebMvcConfig(CustomProductMetricsInterceptor customProductMetricsInterceptor) {
        this.customProductMetricsInterceptor = customProductMetricsInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customProductMetricsInterceptor);
    }
}