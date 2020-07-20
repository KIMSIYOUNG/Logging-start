package com.example.loggingexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggingExampleApplication {
    private static Logger logger = LoggerFactory.getLogger(LoggingExampleApplication.class);

    public static void main(String[] args) {
        logger.info("HELLO INFO LOG");
        SpringApplication.run(LoggingExampleApplication.class, args);
    }

}
