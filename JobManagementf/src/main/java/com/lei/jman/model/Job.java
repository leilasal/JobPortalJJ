package com.lei.jman.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "jobs")
public class Job {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    private @NotNull String name;
	    private @NotNull String imageURL;//company logo
	    private @NotNull String location;
	    private @NotNull String description;

	    @JsonIgnore
	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "category_id", nullable = false)
	    Category category;


	    public Job(String name, String imageURL, String location, String description, Category category) {
	        super();
	        this.name = name;
	        this.imageURL = imageURL;
	        this.location = location;
	        this.description = description;
	        this.category = category;
	    }


		public Job() {
			// TODO Auto-generated constructor stub
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


		public Category getCategory() {
			return category;
		}


		public void setCategory(Category category) {
			this.category = category;
		}
	
	}

