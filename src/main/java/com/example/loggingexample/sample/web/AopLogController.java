package com.example.loggingexample.sample.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AopLogController {

    @GetMapping("/aop/log")
    public String aopLogging() {
        log.info("this is AopLogController");
        return "Logging ing...";
    }

    @GetMapping("/aop/annotation")
    @ExecutionTime
    public String timeOut() {
        return "this is Logging by annotation";
    }
}
