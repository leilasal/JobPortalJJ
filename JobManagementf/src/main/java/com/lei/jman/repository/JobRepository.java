package com.lei.jman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lei.jman.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

}
