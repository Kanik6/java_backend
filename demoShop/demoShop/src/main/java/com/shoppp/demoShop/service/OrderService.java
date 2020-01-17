package com.shoppp.demoShop.service;

import com.shoppp.demoShop.entity.Car;
import com.shoppp.demoShop.entity.Order;
import com.shoppp.demoShop.entity.ShoppingCart;
import com.shoppp.demoShop.entity.User;
import com.shoppp.demoShop.exception.NotEnoughBalance;
import com.shoppp.demoShop.repository.CarRepository;
import com.shoppp.demoShop.repository.OrderRepository;
import com.shoppp.demoShop.repository.ShoppingCartRepository;
import com.shoppp.demoShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class OrderService
{
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarService carService;

    @Autowired
    UserService userService;

    @Autowired
    ShoppingCartRepository  shoppingCartRepository;

    @Autowired
    ShoppingCartService  shoppingCartService;

    public Order createOrder(Order order)
    {
        order.setOrderDate(LocalDate.now());

        order.setTotalPrice(getOrderTotalPrice(order.getUserId()));

        Double userBalance = userService.getUser(order.getUserId()).getBalance();

        if(userBalance < order.getTotalPrice())
        {
            throw new NotEnoughBalance("Not enough balance");
        }

        Set<Car> fromCartToOrd = userService.getUser(order.getUserId()).getShoppingCart().getCar();

        for(Car car : fromCartToOrd)
        {
            Car carr = carService.getCar(car.getId());
            carr.setInStock(false);
            carService.update(carr, car.getId());
        }

        shoppingCartService.cleanCart(order.getUserId());

        order.setCars(fromCartToOrd);

        return orderRepository.save(order);
    }

    public Double getOrderTotalPrice(Long userId)
    {
        Double total = 0d;

        ShoppingCart shopCart = shoppingCartRepository.findById(userId).get();
        Set<Car> carsIn = shopCart.getCar();

        for(Car carr : carsIn)
        {
            total += carr.getPrice();
        }
        return total;
    }

    public List<Order> getUserOrders(Long userId)
    {
        return orderRepository.findByUserId(userId);
    }
}
