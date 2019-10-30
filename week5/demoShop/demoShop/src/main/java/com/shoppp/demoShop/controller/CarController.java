package com.shoppp.demoShop.controller;

import com.shoppp.demoShop.entity.Car;
import com.shoppp.demoShop.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController
{
    @Autowired
    CarService carService;

    @PostMapping("/car")
    public void createCar()
    {
        Car car = new Car("KIA", 2321.12, 2013);
        carService.createCar(car);
    }

    @GetMapping("/Car")
    public Car getCar()
    {
        String carName = "KIA";
        return carService.getCar(carName);
    }

    @PutMapping("/car")
    public Car updateCar()
    {
        Car car = new Car("Mercedes", 2321.12, 2013);
        return carService.update(car, 1L);
    }

    @DeleteMapping("/car")
    public void deleteCar()
    {
        Car car = new Car("KIA", 2321.12, 2013);
        carService.createCar(car);
    }
}
