package com.example.loggingexample.sample.web;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public Logger loggerFactory() {
        return LoggerFactory.getLogger(MemberController.class);
    }
}
