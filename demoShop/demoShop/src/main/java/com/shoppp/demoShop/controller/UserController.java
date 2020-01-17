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
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id)
    {
        return userService.getUser(id);
    }

    @GetMapping("/user")
    public List<User> getUsers()
    {
        return userService.getUsers();
    }

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id)
    {

        return userService.updateUser(user, id);
    }

    @DeleteMapping("user/{id}")
    public void deleteUser(@PathVariable Long id)
    {
        userService.deleteUser(id);
    }

    @PutMapping("/putBalance/{userId}")
    private User putBalance(@PathVariable("userId") Long userId, @RequestBody User user)
    {
        return userService.updateUser(user, userId);
    }
}
