package com.ua.lviv.iot.puma560.service;

import com.ua.lviv.iot.puma560.model.Coordinate;

import java.util.List;

public interface CoordinateService {

    void createCoordinate(Coordinate coordinate);

    void setPainted(Integer coordinate);

    List<String> getByPaintedIsTrue();
}
