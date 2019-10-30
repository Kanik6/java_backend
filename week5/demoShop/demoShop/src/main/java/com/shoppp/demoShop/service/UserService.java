package com.shoppp.demoShop.service;

import com.shoppp.demoShop.entity.Role;
import com.shoppp.demoShop.entity.User;
import com.shoppp.demoShop.repository.RoleRepository;
import com.shoppp.demoShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public void testUser()
    {
        Set<Role> role = new HashSet(Arrays.asList(roleRepository.findByName("STAFF")));

        User user = new User("Shikamaru", "qwe", true);
        user.setRoles(role);
        userRepository.save(user);
    }

    public User getUser(String name)
    {
        return userRepository.findByUserName(name);
    }

}
