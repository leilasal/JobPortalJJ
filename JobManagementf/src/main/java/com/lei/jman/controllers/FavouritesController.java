package com.lei.jman.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lei.jman.common.ApiResponse;
import com.lei.jman.dto.JobDto;
import com.lei.jman.model.Job;
import com.lei.jman.model.User;
import com.lei.jman.model.Favourites;
import com.lei.jman.service.AuthenticationService;
import com.lei.jman.service.FavouritesService;
import com.lei.jman.service.JobService;

@RestController
@RequestMapping("/favourites")
public class FavouritesController {
	 @Autowired
     private FavouritesService favouritesService;

     @Autowired
     private AuthenticationService authenticationService;

     @GetMapping("/{token}")
     public ResponseEntity<List<JobDto>> getfavourites(@PathVariable("token") String token) {
             int user_id = authenticationService.getUser(token).getId();
             List<Favourites> body = favouritesService.readfavourites(user_id);
             List<JobDto> jobs = new ArrayList<JobDto>();
             for (Favourites favourites : body) {
            	 jobs.add(JobService.getDtoFromJob(favourites.getJob()));
             }

             return new ResponseEntity<List<JobDto>>(jobs, HttpStatus.OK);
     }

     @PostMapping("/add")
     public ResponseEntity<ApiResponse> addFavourites(@RequestBody Job job, @RequestParam("token") String token) {
             authenticationService.authenticate(token);
             User user = authenticationService.getUser(token);
             Favourites favourites = new Favourites(user, job);
             favouritesService.createFavourites(favourites);
             return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Add to favourites"), HttpStatus.CREATED);

     }


}