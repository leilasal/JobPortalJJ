package com.lei.jman.dto;

import javax.validation.constraints.NotNull;

import com.lei.jman.model.Apply;
import com.lei.jman.model.Job;

public class ApplyItemDto {
	 private Integer id;
	    private @NotNull Integer quantity;
	    private @NotNull Job job;

	    public ApplyItemDto() {
	    }

	    public ApplyItemDto(Apply apply) {
	        this.setId(apply.getId());
	        this.setQuantity(apply.getQuantity());
	        this.setJob(apply.getJob());
	    }

	    @Override
	    public String toString() {
	        return "ApplyDto{" +
	                "id=" + id +
	                ", quantity=" + quantity +
	                ", jobName=" + job.getName() +
	                '}';
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public Integer getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(Integer quantity) {
	        this.quantity = quantity;
	    }
	    public Job getJob() {
	        return job;
	    }

	    public void setJob(Job job) {
	        this.job = job;
	    }

	}