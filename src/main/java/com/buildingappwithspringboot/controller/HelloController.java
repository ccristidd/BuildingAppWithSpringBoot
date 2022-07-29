package com.buildingappwithspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/home")
    public String index() {
        return "This text is returned by the HelloController! ";
    }

}
