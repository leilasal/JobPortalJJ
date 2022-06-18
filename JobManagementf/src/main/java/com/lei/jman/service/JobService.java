package com.lei.jman.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lei.jman.dto.JobDto;
import com.lei.jman.exceptions.JobNotExistException;
import com.lei.jman.model.Category;
import com.lei.jman.model.Job;
import com.lei.jman.repository.JobRepository;
@Service
public class JobService {
	 @Autowired
	    private JobRepository jobRepository;

	    public List<JobDto> listJobs() {
	        List<Job> jobs = jobRepository.findAll();
	        List<JobDto> jobDtos = new ArrayList<>();
	        for(Job job : jobs) {
	        	JobDto jobDto = getDtoFromJob(job);
	        	jobDtos.add(jobDto);
	        }
	        return jobDtos;
	    }

	    public static JobDto getDtoFromJob(Job job) {
	    	JobDto jobDto = new JobDto(job);
	        return jobDto;
	    }

	    public static Job getJobFromDto(JobDto jobDto, Category category) {
	    	Job job = new Job();
	        return job;
	    }

	    public void addJob(JobDto jobDto, Category category) {
	    	Job job = getJobFromDto(jobDto, category);
	        jobRepository.save(job);
	    }

	    public void updateJob(Integer jobID, JobDto jobDto, Category category) {
	    	Job job = getJobFromDto(jobDto, category);
	        job.setId(jobID);
	        jobRepository.save(job);
	    }


	    public Job getJobById(Integer jobId) throws JobNotExistException {
	        Optional<Job> optionalJob = jobRepository.findById(jobId);
	        if (!optionalJob.isPresent())
	            throw new JobNotExistException("Job id is invalid " + jobId);
	        return optionalJob.get();
	    }

		
	}