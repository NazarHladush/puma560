package com.ua.lviv.iot.puma560.service.impl;

import com.ua.lviv.iot.puma560.model.Coordinate;
import com.ua.lviv.iot.puma560.repository.CoordinateRepository;
import com.ua.lviv.iot.puma560.service.CoordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoordinateServiceImpl implements CoordinateService {

    final CoordinateRepository coordinateRepository;

    @Autowired
    public CoordinateServiceImpl(CoordinateRepository coordinateRepository) {
        this.coordinateRepository = coordinateRepository;
    }

    @Override
    public void createCoordinate(Coordinate coordinate) {
        coordinateRepository.save(coordinate);
    }

    @Override
    @Transactional
    public void setPainted(Integer coordinate) {
        Optional<Coordinate> byCoordinate = coordinateRepository.getByCoordinate(coordinate);
        Coordinate coordinate1 = byCoordinate.orElseThrow();
        coordinate1.setPainted(true);
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getByPaintedIsTrue() {
        List<Coordinate> allByPaintedIsTrue = coordinateRepository.findCoordinateByIsPaintedTrue();
        List<String> list = allByPaintedIsTrue.stream()
                .map(coordinate -> "b" + coordinate.getCoordinate())
                .collect(Collectors.toList());
        return list;
    }
}
