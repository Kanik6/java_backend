package com.shoppp.demoShop.controller;

import com.shoppp.demoShop.service.CarService;
import com.shoppp.demoShop.service.Shop;
import com.shoppp.demoShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController
{
    @Autowired
    CarService carService;

    @Autowired
    UserService userService;

    @Autowired
    Shop shop;

    @GetMapping("/car")
    public void testCar()
    {
        carService.test();
    }

    @GetMapping("user")
    public void testUser()
    {
        userService.testUser();
    }

    @GetMapping("/buy")
    public String testbuy()
    {
        return shop.buyCar();
    }
}
