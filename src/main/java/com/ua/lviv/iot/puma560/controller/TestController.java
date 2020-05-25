package com.ua.lviv.iot.puma560.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/admin")
    public String admin() {
        return "admin!";
    }

    @GetMapping("/user")
    public String user() {
        return "user!";
    }
}
