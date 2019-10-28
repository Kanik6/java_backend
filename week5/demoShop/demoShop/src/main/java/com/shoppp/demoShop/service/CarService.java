package com.shoppp.demoShop.service;

import com.shoppp.demoShop.entity.Car;
import com.shoppp.demoShop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService
{
    @Autowired
    CarRepository carRepository;

    public void test()
    {
        System.out.println("TEst");
        Car car = new Car("KIA", 2321.12, 2013);
        carRepository.save(car);
    }
}
