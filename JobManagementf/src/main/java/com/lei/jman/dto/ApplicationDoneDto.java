package com.lei.jman.dto;

import javax.validation.constraints.NotNull;

import com.lei.jman.model.Applied;

public class ApplicationDoneDto {
	private Integer id;
    private @NotNull Integer userId;
    private @NotNull String tLocation;

    public ApplicationDoneDto() {
    }

	public ApplicationDoneDto(Integer id, @NotNull Integer userId, @NotNull String tLocation) {
		super();
		this.id = id;
		this.userId = userId;
		this.tLocation = tLocation;
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

	public String gettLocation() {
		return tLocation;
	}

	public void settLocation(String tLocation) {
		this.tLocation = tLocation;
	}

   

	
}