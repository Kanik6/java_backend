package com.shoppp.demoShop.service;

import com.shoppp.demoShop.entity.Car;
import com.shoppp.demoShop.entity.ShoppingCart;
import com.shoppp.demoShop.entity.User;
import com.shoppp.demoShop.repository.CarRepository;
import com.shoppp.demoShop.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ShoppingCartService
{
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    CarRepository carRepository;

    public ShoppingCart createShoppingCart(User user)
    {
        ShoppingCart shopCart = new ShoppingCart(user);
        return shoppingCartRepository.save(shopCart);
    }

    public Car addInShopCart(Long user_id, Long car_id)
    {
        ShoppingCart shopCart = shoppingCartRepository.findById(user_id).get();
        Set<Car> carsIn = shopCart.getCar();
        Car car = carRepository.findById(car_id).get();
        carsIn.add(car);
        shopCart.setCar(carsIn);
        shoppingCartRepository.save(shopCart);
        return car;
    }

    public ShoppingCart getShopCart(Long id)
    {
       return shoppingCartRepository.findById(id).get();
    }

    public void cleanCart(Long id)
    {
        shoppingCartRepository.findById(id).get().setCar(null);
    }
}

