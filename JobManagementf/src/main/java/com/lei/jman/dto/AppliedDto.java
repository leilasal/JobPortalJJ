package com.lei.jman.dto;
import com.lei.jman.model.Applied;
import javax.validation.constraints.NotNull;

public class AppliedDto {
	 private Integer id;
	    private @NotNull Integer userId;

	    public AppliedDto() {
	    }

	    public AppliedDto(Applied applied) {
	        this.setId(applied.getId());
	        
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

	}