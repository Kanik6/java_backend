package com.shoppp.demoShop;

import com.shoppp.demoShop.entity.Car;
import com.shoppp.demoShop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoShopApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(DemoShopApplication.class, args);


	}

}
