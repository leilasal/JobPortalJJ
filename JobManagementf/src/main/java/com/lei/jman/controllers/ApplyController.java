package com.lei.jman.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lei.jman.common.ApiResponse;
import com.lei.jman.dto.ApplyDto;
import com.lei.jman.dto.ApplyToDto;
import com.lei.jman.exceptions.ApplyItemNotExistException;
import com.lei.jman.exceptions.AuthenticationFailException;
import com.lei.jman.exceptions.JobNotExistException;
import com.lei.jman.model.*;
import com.lei.jman.model.Job;
import com.lei.jman.service.ApplyService;
import com.lei.jman.service.AuthenticationService;
import com.lei.jman.service.JobService;

@RestController
@RequestMapping("/apply")
public class ApplyController {
	@Autowired
    private ApplyService applyService;

    @Autowired
    private JobService jobService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToApply(@RequestBody ApplyToDto addToApplyDto, 
    		@RequestParam("token") String token) throws AuthenticationFailException, JobNotExistException {
    	 authenticationService.authenticate(token);
         User user = authenticationService.getUser(token);
         Job job = jobService.getJobById(addToApplyDto.getId());
         System.out.println("job to add"+  job.getName());
         applyService.addToApply(addToApplyDto, job, user);
         return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to apply"), HttpStatus.CREATED);
    }
    
    
    @GetMapping("/")
    public ResponseEntity<ApplyDto> getApplyItems(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        ApplyDto applyDto = applyService.listApplyItems(user);
        return new ResponseEntity<ApplyDto>(applyDto,HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{applyItemId}")
    public ResponseEntity<ApiResponse> updateApplyItem(@RequestBody @Valid ApplyToDto applyDto,                                                      
    		@RequestParam("token") String token) throws AuthenticationFailException,JobNotExistException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        Job job = jobService.getJobById(applyDto.getId());
        applyService.updateApplyItem(applyDto,user,job);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Job has been updated"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{applyItemId}")
    public ResponseEntity<ApiResponse> deleteApplyItem(@PathVariable("applyItemId") int itemID,@RequestParam("token") String token) throws AuthenticationFailException, ApplyItemNotExistException {
        authenticationService.authenticate(token);
        int userId = authenticationService.getUser(token).getId();
        applyService.deleteApplyItem(itemID,userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }

}