package com.example.loggingexample.sample.web;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loggingexample.sample.MemberRequest;
import com.example.loggingexample.sample.application.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/members")
@AllArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody MemberRequest request) {
        log.info("Member Controller");
        log.info("===========================");
        log.info("info : Start to create member");
        log.debug("debug : Start to create member");
        log.error("error : Start to create member");
        log.trace("trace : Start to create member");
        log.warn("warn : Start to create member");
        log.info("===========================");

        Long id = memberService.create(request);
        return ResponseEntity.created(URI.create("/member/" + id)).build();
    }
}
