package com.lei.jman.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lei.jman.model.Favourites;


public interface FavouritesRepository extends JpaRepository<Favourites, Integer> {

    List<Favourites> findAllByUserIdAppliedByCreatedDateDesc(Integer userId);


}