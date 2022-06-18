package com.lei.jman.dto;

import javax.validation.constraints.NotNull;

import com.lei.jman.model.Apply;

public class ApplyToDto {
	 private Integer id;
	    private @NotNull Integer userId;
	    private @NotNull Long jobId;
	    private @NotNull Integer quantity;

	    public ApplyToDto() {
	    }

	    public ApplyToDto(Integer id, @NotNull Integer userId, @NotNull Long jobId, @NotNull Integer quantity) {
	        this.id = id;
	        this.userId = userId;
	        this.jobId = jobId;
	        this.quantity = quantity;
	    }

	    
	    @Override
	    public String toString() {
	        return "ApplyDto{" +
	                "id=" + id +
	                ", userId=" + userId +
	                ", jobId=" + jobId +
	                ", quantity=" + quantity +
	                ",";
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public Integer getUserId() {
	        return userId;
	    }

	    public void setUserId(Integer userId) {
	        this.userId = userId;
	    }

	    public Long getjobId() {
	        return jobId;
	    }

	    public void setjobId(Long jobId) {
	        this.jobId = jobId;
	    }

	    public Integer getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(Integer quantity) {
	        this.quantity = quantity;
	    }
	}