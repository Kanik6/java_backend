package com.shoppp.demoShop.controller;

import com.shoppp.demoShop.entity.Car;
import com.shoppp.demoShop.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "All Cars")
public class CarController
{
    @Autowired
    CarService carService;

    @PostMapping("/car")
    @ApiOperation(value = "creates new car", httpMethod = "POST http://localhost:8080/car", consumes = "car json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "returns new created car")})
    public Car createCar(@RequestBody Car car)
    {
        return carService.createCar(car);
    }

    @GetMapping("/car/{id}")
    @ApiOperation(value = "gets one car", httpMethod = "GET http://localhost:8080/car", consumes = "cars id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "returns one cars")})
    public Car getCar(@PathVariable Long id)
    {
        return carService.getCar(id);
    }

    @GetMapping("/car")
    @ApiOperation(value = "gets all cars", httpMethod = "GET http://localhost:8080/car", consumes = "nothing")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "returns list of cars")})
    public List<Car> getCars()
    {
        return carService.getCars();
    }

    @PutMapping("/car/{id}")
    @ApiOperation(value = "updates car", httpMethod = "PUT http://localhost:8080/{id}", consumes = "car json and cars id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "returns updated car")})
    public Car updateCar(@RequestBody Car car, @PathVariable Long id)
    {
        return carService.update(car, id);
    }

    @DeleteMapping("/car/{id}")
    @ApiOperation(value = "deletes car by id", httpMethod = "DELETE http://localhost:8080/car", consumes = "cars id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "returns deleted if success")})
    public String deleteCar(@PathVariable Long id)
    {
        return carService.deleteCar(id);
    }
}
