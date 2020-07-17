package com.example.loggingexample.sample.application;

import org.springframework.stereotype.Service;

import com.example.loggingexample.Member;
import com.example.loggingexample.sample.MemberRepository;
import com.example.loggingexample.sample.MemberRequest;
import com.example.loggingexample.sample.Role;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Long create(final MemberRequest request) {
        log.info("Member Service");
        log.info("===========================");
        log.info("info : This is Service");
        log.debug("debug : This is Service");
        log.error("error : This is Service");
        log.trace("trace : This is Service");
        log.warn("warn : This is Service");
        log.info("===========================");

        final Member member = Member.builder()
            .name(request.getName())
            .role(Role.GUEST)
            .build();

        return memberRepository.save(member).getId();
    }
}
