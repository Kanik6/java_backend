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

    public void createCar(Car car)
    {
        carRepository.save(car);
    }

    public Car getCar(String carName)
    {
        return carRepository.findByName(carName);
    }

    public Car update(Car car, Long id)
    {
        Car putCar = carRepository.findById(id)
                .map(element -> {
                    element.setId(id);
                    element.setName(car.getName());
                    element.setPrice(car.getPrice());
                    element.setYear(car.getYear());
                    return carRepository.save(car);
                })
                .orElseGet(() -> {
                    car.setId(id);
                    return carRepository.save(car);
                });
        return putCar;
    }

    public void deleteCar(Car car)
    {
        carRepository.delete(car);
    }
}
