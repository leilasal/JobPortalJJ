package com.lei.jman.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lei.jman.model.Favourites;
import com.lei.jman.repository.FavouritesRepository;

@Service
@Transactional
public class FavouritesService {
	private final FavouritesRepository favouritesRepository;

    public FavouritesService(FavouritesRepository favouritesRepository) {
        this.favouritesRepository = favouritesRepository;
    }

    public void createFavourites(Favourites favourites) {
    	favouritesRepository.save(favourites);
    }

    public List<Favourites> readfavourites(Integer userId) {
        return favouritesRepository.findAllByUserIdAppliedByCreatedDateDesc(userId);
    }
}