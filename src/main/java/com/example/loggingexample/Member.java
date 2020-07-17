package com.example.loggingexample;

import org.springframework.data.annotation.Id;

import com.example.loggingexample.sample.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.With;

@Getter
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Member {
    @Id @With
    private final Long id;
    private final String name;
    private final Role role;
}
