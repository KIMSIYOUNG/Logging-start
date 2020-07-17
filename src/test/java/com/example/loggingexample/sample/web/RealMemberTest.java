package com.example.loggingexample.sample.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;

import com.example.loggingexample.sample.MemberRequest;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

@Rollback(false)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RealMemberTest {

    @LocalServerPort
    public int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    public static RequestSpecification given() {
        return RestAssured.given().log().all();
    }

    @Test
    void realCall() {
        MemberRequest memberRequest = new MemberRequest();

        given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(memberRequest)
            .when()
            .post("/members")
            .then()
            .statusCode(201)
            .log().all();
    }
}
