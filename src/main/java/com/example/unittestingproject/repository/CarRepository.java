package com.example.unittestingproject.repository;

import com.example.unittestingproject.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    List<Car> findAll();

    List<Car> findCarByPriceAfter(int price);

    List<Car> findCarByPriceBetween(int minPrice, int maxPrice);

}
