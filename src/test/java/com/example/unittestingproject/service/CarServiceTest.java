package com.example.unittestingproject.service;

import com.example.unittestingproject.entity.Car;
import com.example.unittestingproject.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @InjectMocks
    CarService carService;

    @Mock
    CarRepository carRepository;

    @Test
    public void TestIsEmpty(){
        List<Car> cars = new ArrayList<>();
        when(carRepository.findAll()).thenReturn(cars);
        boolean isEmpty = carService.isEmpty();
        Assertions.assertTrue(isEmpty);
    }




    @Test
    public void isCarExists(){
        List<Car> cars = new ArrayList<>();
        cars.add(Car.builder().model("Chevrolet").brand("Cruz").build());
        when(carRepository.findAll()).thenReturn(cars);
        boolean carExists = carService.isCarExists("Cruz", "Chevrolet");
        Assertions.assertTrue(carExists);

    }

    @Test
    public void isCarExists2(){
        List<Car> cars = new ArrayList<>();
        cars.add(Car.builder().model("Chevrolet").brand("Cruz").build());
        when(carRepository.findAll()).thenReturn(cars);
        boolean carExists = carService.isCarExists("Cruz!!", "Chevrolet");
        Assertions.assertFalse(carExists);

    }

    @Test
    public void priceHigherThanTest(){
        List<Car> cars = new ArrayList<>();

        cars.add(Car.builder().model("Chevrolet").brand("Camaro").price(50000).build());
        cars.add(Car.builder().model("Toyota").brand("Tundra").price(60000).build());
        cars.add(Car.builder().model("Lexus").brand("RX350").price(80000).build());
        cars.add(Car.builder().model("Range Rover").brand("Sport").price(100000).build());
        cars.add(Car.builder().model("Mercedes").brand("GLE").price(150000).build());


        when(carRepository.findAll()).thenReturn(cars);
        List<Car> expectedData = carService.priceHigherThan(60000);
        int price1 = expectedData.get(0).getPrice();
        Assertions.assertTrue(price1>60000);


    }

}
