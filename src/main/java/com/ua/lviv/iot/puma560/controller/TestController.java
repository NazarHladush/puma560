package com.ua.lviv.iot.puma560.controller;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/coordinates")
    public void getCoordinates(@RequestParam(name = "coordinate") String coordinate) {
        System.out.println(coordinate);
    }
}
