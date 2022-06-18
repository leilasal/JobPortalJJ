package com.lei.jman.controllers;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lei.jman.common.ApiResponse;
import com.lei.jman.dto.JobDto;
import com.lei.jman.model.Category;
import com.lei.jman.service.CategoryService;
import com.lei.jman.service.JobService;
@RestController
@RequestMapping("/job")
public class JobController {
	@Autowired
    JobService jobService;
    @Autowired
    CategoryService categoryService;
    
    
    @GetMapping("/")
    public ResponseEntity<List<JobDto>> getJobs() {
        List<JobDto> body = jobService.listJobs();
        return new ResponseEntity<List<JobDto>>(body, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody JobDto productDto) {
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        }
        Category category = optionalCategory.get();
        jobService.addJob(productDto, category);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
    }
    
    
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addJob(@RequestBody JobDto jobDto) {
        Optional<Category> optionalCategory = categoryService.readCategory(jobDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        }
        Category category = optionalCategory.get();
jobService.addJob(jobDto, category);
        return new ResponseEntity<>(new ApiResponse(true, "job has been added"), HttpStatus.CREATED);
    }
}