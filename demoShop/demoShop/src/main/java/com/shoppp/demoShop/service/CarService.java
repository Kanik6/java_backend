package com.shoppp.demoShop.service;

import com.shoppp.demoShop.entity.Car;
import com.shoppp.demoShop.entity.Category;
import com.shoppp.demoShop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService
{
    @Autowired
    CarRepository carRepository;

    public Car createCar(Car car)
    {
       return carRepository.save(car);
    }

    public Car getCar(Long id)
    {
        return carRepository.findById(id).get();
    }

    public List<Car> getCars()
    {
        return carRepository.findAll();
    }


    public Car update(Car car, Long id)
    {
        Car putCar = carRepository.findById(id)
                .map(carr -> {
                    carr.setName(car.getName());
                    carr.setPrice(car.getPrice());
                    carr.setYear(car.getYear());
                    carr.setInStock(car.getInStock());
                    carr.setCategories(car.getCategories());
                    return carRepository.save(carr);
                })
                .orElseGet(() ->
                {
                    return carRepository.save(car);
                });
        return putCar;
    }

    public List<Car>getCarsByCategory(Category category)
    {
        return  carRepository.findByCategories(category);
    }

    public String deleteCar(Long id)
    {
        carRepository.deleteById(id);
        return "deleted";
    }
}