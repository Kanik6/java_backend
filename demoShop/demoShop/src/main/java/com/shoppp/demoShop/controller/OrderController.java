package com.shoppp.demoShop.controller;

import com.shoppp.demoShop.entity.Car;
import com.shoppp.demoShop.entity.Order;
import com.shoppp.demoShop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class OrderController
{
    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public Order createOrder(@RequestBody Order order)
    {
        return orderService.createOrder(order);
    }

    @GetMapping("getUserOrders/{userId}")
    private List<Order> getUserOrder(@PathVariable("userId") Long userId)
    {
        return orderService.getUserOrders(userId);
    }


}
