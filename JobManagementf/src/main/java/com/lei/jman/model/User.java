package com.lei.jman.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lei.jman.enums.Role;

@Entity
@Table(name = "users")
public class User {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @Column(name = "first_name")
	    private String firstName;

	    @Column(name = "last_name")
	    private String lastName;

	    @Column(name = "email")
	    private String email;

	    
	    
	    @Column(name = "linkedinProfile")
	    private String linkedinProfile;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "role")
	    private Role role;

	    @Column(name = "password")
	    private String password;

	    @JsonIgnore
	    @OneToMany(mappedBy = "user",
	            fetch = FetchType.LAZY)
	    private List<Applied> applied;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public Role getRole() {
	        return role;
	    }

	    public void setRole(Role role) {
	        this.role = role;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public User(String firstName, String lastName, String linkedinProfile, String email, Role role, String password) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.linkedinProfile=linkedinProfile;
	        this.email = email;
	        this.role = role;
	        this.password = password;
	    }

	    public String getLinkedinProfile() {
			return linkedinProfile;
		}

		public void setLinkedinProfile(String linkedinProfile) {
			this.linkedinProfile = linkedinProfile;
		}

		public User() {
	    }

	    public List<Applied> getApplied() {
	        return applied;
	    }

	    public void setApplied(List<Applied> applied) {
	        this.applied = applied;
	    }
	}