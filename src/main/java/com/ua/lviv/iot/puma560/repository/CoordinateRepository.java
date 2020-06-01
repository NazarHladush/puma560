package com.ua.lviv.iot.puma560.repository;

import com.ua.lviv.iot.puma560.model.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {
    Optional<Coordinate> getByCoordinate(Integer coordinate);
//    @Query("SELECT ")
    List<Coordinate> findCoordinateByIsPaintedTrue();
}
