package com.shavic.department.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld2 {

    @Value("${brief.introduction}")
    private String brief;

//    Not gonna be documented in this space
    @GetMapping("/phase2")
    public String SpringBootPhase2() {
        return brief;
    }

}
