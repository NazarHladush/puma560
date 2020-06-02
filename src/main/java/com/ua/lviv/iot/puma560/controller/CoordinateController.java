package com.ua.lviv.iot.puma560.controller;

import com.ua.lviv.iot.puma560.model.Coordinate;
import com.ua.lviv.iot.puma560.service.CoordinateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoordinateController {

    final
    CoordinateService coordinateService;

    public CoordinateController(CoordinateService coordinateService) {
        this.coordinateService = coordinateService;
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

    @DeleteMapping("/coordinates")
    public void deleteAllCoordinates() {
        coordinateService.deleteAllCoordinates();
    }
}
