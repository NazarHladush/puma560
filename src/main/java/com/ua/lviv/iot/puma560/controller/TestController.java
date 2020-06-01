package com.ua.lviv.iot.puma560.controller;

import com.ua.lviv.iot.puma560.model.Coordinate;
import com.ua.lviv.iot.puma560.service.CoordinateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    final
    CoordinateService coordinateService;

    public TestController(CoordinateService coordinateService) {
        this.coordinateService = coordinateService;
    }

    @GetMapping()
    public String admsin() {
        return "HI!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin!";
    }

    @GetMapping("/user")
    public String user() {
        return "user!";
    }

    @GetMapping("/coordinates")
    public List<String> getCoordinates() {
        return coordinateService.getByPaintedIsTrue();
    }

    @PostMapping("/coordinates")
    public void setCoordinates(@RequestParam(name = "coordinate") String coordinate) {
        Integer coordinateId = Integer.parseInt(coordinate.substring(1));
        coordinateService.setPainted(coordinateId);
        System.out.println(coordinate);
    }
}
