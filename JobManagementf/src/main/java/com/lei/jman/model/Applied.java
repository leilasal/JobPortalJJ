package com.lei.jman.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="applied")
public class Applied {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;


	    @Column(name = "created_date")
	    private Date createdDate;

	    @Column(name = "tlocation")
	    private String tlocation;

	    @Column(name = "session_id")
	    private String sessionId;

	    @OneToMany(mappedBy = "applied", fetch = FetchType.LAZY)
	    private List<AppliedItem> appliedItems;

	    @ManyToOne()
	    @JsonIgnore
	    @JoinColumn(name = "user_id", referencedColumnName = "id")
	    private User user;

	    public Applied() {
	    }


	    public List<AppliedItem> getAppliedItems() {
	        return appliedItems;
	    }

	    public void setAppliedItems(List<AppliedItem> orderItems) {
	        this.appliedItems = appliedItems;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }


	    public Date getCreatedDate() {
	        return createdDate;
	    }

	    public void setCreatedDate(Date createdDate) {
	        this.createdDate = createdDate;
	    }

	   

	    public String getTlocation() {
			return tlocation;
		}


		public void setTlocation(String tlocation) {
			this.tlocation = tlocation;
		}


		public String getSessionId() {
	        return sessionId;
	    }

	    public void setSessionId(String sessionId) {
	        this.sessionId = sessionId;
	    }

	    public User getUser() {
	        return user;
	    }

	    public void setUser(User user) {
	        this.user = user;
	    }
	}
