package com.shoppp.demoShop.controller;


import com.shoppp.demoShop.entity.User;
import com.shoppp.demoShop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "All Users")
public class UserController
{
    @Autowired
    UserService userService;

    @PostMapping("/user")
    @ApiOperation(value = "creates new User", httpMethod = "POST http://localhost:8080/user", consumes = "User json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "returns new created User")})
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }

    @GetMapping("/user")
    @ApiOperation(value = "get all users", httpMethod = "GET http://localhost:8080/user", consumes = "returns list of users")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "returns new created user")})
    public List<User> getUsers()
    {
        return userService.getUsers();
    }

    @PutMapping("/user/{id}")
    @ApiOperation(value = "updates user with specified id", httpMethod = "PUT http://localhost:8080/user", consumes = "user json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "returns new created user")})
    public User updateUser(@RequestBody User user, @PathVariable Long id)
    {

        return userService.updateUser(user, id);
    }

    @DeleteMapping("user/{id}")
    @ApiOperation(value = "deletes user with specified id", httpMethod = "DELETE http://localhost:8080/user", consumes = "user ID")
    @ApiResponses(value = {@ApiResponse(code = 200, message = " returns void")})
    public void deleteUser(@PathVariable Long id)
    {
        userService.deleteUser(id);
    }
}
