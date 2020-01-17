package com.shoppp.demoShop.repository;

import com.shoppp.demoShop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    User findByUserName(String name);
}
