package com.lei.jman.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "applieditems")
public class AppliedItem {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "quantity")
    private @NotNull int quantity;

    @Column(name = "location")
    private @NotNull String location;


    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "applied_id", referencedColumnName = "id")
    private Applied applied;

    @OneToOne
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    private Job job;

    public AppliedItem(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Applied getApplied() {
		return applied;
	}

	public void setApplied(Applied applied) {
		this.applied = applied;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public AppliedItem(Integer id, @NotNull int quantity, @NotNull String location, Date createdDate, Applied applied,
			Job job) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.location = location;
		this.createdDate = createdDate;
		this.applied = applied;
		this.job = job;
	}

	

   
}