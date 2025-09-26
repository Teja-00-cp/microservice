package com.example.order.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.order.Model.User;


public interface UserRepo extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);

}
