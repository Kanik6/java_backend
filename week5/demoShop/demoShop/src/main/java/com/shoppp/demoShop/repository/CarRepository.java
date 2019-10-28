package com.shoppp.demoShop.repository;

import com.shoppp.demoShop.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>
{
    Car findByName(String name);
}
