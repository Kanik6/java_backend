package com.shoppp.demoShop.service;

import com.shoppp.demoShop.entity.Car;
import com.shoppp.demoShop.entity.User;
import com.shoppp.demoShop.repository.CarRepository;
import com.shoppp.demoShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class Shop
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    CarRepository carRepository;

    public String buyCar()
    {
        User usr = userRepository.findById(3L).get();
//        Set<Car> carr = carRepository.findByName("KIA");
        Set<Car> carr = new HashSet(Arrays.asList(carRepository.findByName("KIA")));

        usr.setCar(carr);
        return "done";
    }
}
