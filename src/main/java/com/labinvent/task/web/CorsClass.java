package com.labinvent.task.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsClass implements WebMvcConfigurer {
    private static final long MAX_AGE_SECS = 3600;
    private static final String[] ALLOWED_METHODS = new String[]{"GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"};
    private static final String MAPPING = "/**";
    private static final String ALLOWED_ORIGINS = "*";
    private static final String ALLOWED_HEADERS = "*";
    private static final Boolean ALLOW_CREDENTIALS = true;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(MAPPING)
                .allowedOrigins(ALLOWED_ORIGINS)
                .allowedMethods(ALLOWED_METHODS)
                .allowedHeaders(ALLOWED_HEADERS)
                .allowCredentials(ALLOW_CREDENTIALS)
                .maxAge(MAX_AGE_SECS);
    }
}