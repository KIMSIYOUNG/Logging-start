package com.example.loggingexample.sample;

import org.springframework.data.repository.CrudRepository;

import com.example.loggingexample.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
