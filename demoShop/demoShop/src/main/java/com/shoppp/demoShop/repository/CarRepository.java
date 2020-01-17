package com.shoppp.demoShop.repository;

import com.shoppp.demoShop.entity.Car;
import com.shoppp.demoShop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>
{
    Car findByName(String name);

    List<Car> findByCategories(Category category);
}
