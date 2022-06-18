package com.lei.jman.controllers;

import java.util.List;


import com.stripe.model.checkout.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.lei.jman.common.ApiResponse;
import com.lei.jman.dto.DoneApplyDto;
import com.lei.jman.dto.StripeResponse;
import com.lei.jman.exceptions.AppliedNotFoundException;
import com.lei.jman.exceptions.AuthenticationFailException;
import com.lei.jman.model.Applied;
import com.lei.jman.model.User;
import com.lei.jman.service.AppliedService;
import com.lei.jman.service.AuthenticationService;
import com.stripe.exception.StripeException;

public class AppliedController {
	@Autowired
    private AppliedService appliedService;

    @Autowired
    private AuthenticationService authenticationService;


    // stripe create session API
    @PostMapping("/create-doneapply-session")
    public ResponseEntity<StripeResponse> doneapplyoutList(@RequestBody List<DoneApplyDto> doneapplyItemDtoList) throws StripeException {
        // create the stripe session
        Session session = appliedService.createSession(doneapplyItemDtoList);
        StripeResponse stripeResponse = new StripeResponse(session.getId());
        // send the stripe session id in response
        return new ResponseEntity<StripeResponse>(stripeResponse, HttpStatus.OK);
    }

 
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> placeApplied(@RequestParam("token") String token, @RequestParam("sessionId") String sessionId)
            throws AuthenticationFailException {
        // validate token
        authenticationService.authenticate(token);
        // retrieve user
        User user = authenticationService.getUser(token);
        
        appliedService.placeApplied(user, sessionId);
        return new ResponseEntity<>(new ApiResponse(true, "Application has been submitted"), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Applied>> getAllApplied(@RequestParam("token") String token) throws AuthenticationFailException {
        // validate token
        authenticationService.authenticate(token);
        // retrieve user
        User user = authenticationService.getUser(token);
       
        List<Applied> appliedDtoList = appliedService.listApplied(user);

        return new ResponseEntity<>(appliedDtoList, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getAppliedById(@PathVariable("id") Integer id, @RequestParam("token") String token)
            throws AuthenticationFailException {
        // validate token
        authenticationService.authenticate(token);
        try {
            Applied applied = appliedService.getApplied(id);
            return new ResponseEntity<>(applied,HttpStatus.OK);
        }
        catch (AppliedNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

}