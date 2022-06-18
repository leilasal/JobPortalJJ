package com.lei.jman.dto;

import javax.validation.constraints.NotNull;

import com.lei.jman.model.Job;

public class JobDto {
	private Integer id;
	private @NotNull String name;
	private @NotNull String imageURL;
	private @NotNull String location;
	private @NotNull String description;
	private @NotNull Integer categoryId;
	
	
	public JobDto(Job job) {
        this.setId(job.getId());
        this.setName(job.getName());
        this.setImageURL(job.getImageURL());
        this.setDescription(job.getDescription());
        this.setLocation(job.getLocation());
        this.setCategoryId(job.getCategory().getId());
    }

	
	
	
	public JobDto(Integer id, @NotNull String name, @NotNull String imageURL, @NotNull String location,
			@NotNull String description, @NotNull Integer categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.imageURL = imageURL;
		this.location = location;
		this.description = description;
		this.categoryId = categoryId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
}
