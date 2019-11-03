package com.shoppp.demoShop.repository;

import com.shoppp.demoShop.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long>
{

}
