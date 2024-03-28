package com.example.unittestingproject.service;

import com.example.unittestingproject.entity.Car;
import com.example.unittestingproject.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;


    public boolean isEmpty(){
        List<Car> all = carRepository.findAll();
        return all.isEmpty();
    }

    public boolean isCarExists(String brand,String model) {
        List<Car> cars = carRepository.findAll();
        for (Car c : cars) {
            if (c.getBrand().equals(brand)) {
                if ( c.getModel().equals(model)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Car> priceHigherThan(int price){
        List<Car> cars = carRepository.findAll();
        return cars.stream().filter(c -> c.getPrice() > price).toList();
    }


}
