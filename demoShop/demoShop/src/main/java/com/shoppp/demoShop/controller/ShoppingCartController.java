package com.shoppp.demoShop.controller;

import com.shoppp.demoShop.entity.Car;
import com.shoppp.demoShop.entity.ShoppingCart;
import com.shoppp.demoShop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartController
{
    @Autowired
    ShoppingCartService shoppingCartService;

    @PostMapping("/addToCart/{user_id}/{car_id}")
    public Car addToShopCart(@PathVariable("user_id") Long user_id, @PathVariable("car_id") Long car_id)
    {
        return shoppingCartService.addInShopCart(user_id, car_id);
    }

    @GetMapping("/ShopCart/{cartId}")
    public ShoppingCart getShopCartById(@PathVariable("cartId") Long cartId)
    {
        return shoppingCartService.getShopCart(cartId);
    }
}
