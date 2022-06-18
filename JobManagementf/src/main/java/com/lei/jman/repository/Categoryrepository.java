package com.lei.jman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lei.jman.model.Category;

@Repository
public interface Categoryrepository extends JpaRepository<Category, Integer> {

	Category findByCategoryName(String categoryName);

}