package com.buildingappwithspringboot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

    private TestRestTemplate testRestTemplate;

    @Autowired
    public HelloControllerIT(TestRestTemplate testRestTemplate) {
        this.testRestTemplate = testRestTemplate;
    }

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/home", String.class);
        assertThat(response.getBody()).isEqualTo("This text is returned by the HelloController! ");
    }
}
