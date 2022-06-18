package com.lei.jman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lei.jman.model.AuthenticationToken;
import com.lei.jman.model.User;

public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {
    AuthenticationToken findTokenByUser(User user);
    AuthenticationToken findTokenByToken(String token);
}