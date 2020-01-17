package com.shoppp.demoShop.service;

import com.shoppp.demoShop.entity.Role;
import com.shoppp.demoShop.entity.User;
import com.shoppp.demoShop.repository.RoleRepository;
import com.shoppp.demoShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ShoppingCartService shoppingCartService;

    public User createUser(User user)
    {
        Set<Role> role = new HashSet(Arrays.asList(roleRepository.findByName("STAFF")));

        user.setRoles(role);


        userRepository.save(user);
        User usr = userRepository.findById(user.getId()).get();
        shoppingCartService.createShoppingCart(usr);
        return usr;
    }


    public User getUser(Long id)
    {
        return userRepository.findById(id).get();
    }

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    public User updateUser(User user , Long id)
    {
        User putUser = userRepository.findById(id)
                .map(userr -> {
                    userr.setUserName(user.getUserName());
                    userr.setPassword(user.getPassword());
                    userr.setActive(user.isActive());
                    userr.setBalance(user.getBalance());
                    return  userRepository.save(userr);
                })
                .orElseGet(() ->
                {
                    return userRepository.save(user);
                });
        return putUser;
    }

    public void deleteUser(Long id)
    {
        userRepository.deleteById(id);
    }

//    public User getCurrentUser(Authentication authentication){
//
//        org.springframework.security.core.userdetails.User
//                currentUser =
//                (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
//        User user = userRepository.findByUserName(currentUser.getUsername());
//
//        return user;
//    }

}
