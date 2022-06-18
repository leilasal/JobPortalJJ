package com.lei.jman.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lei.jman.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();

    User findByEmail(String email);

    User findUserByEmail(String email);
}