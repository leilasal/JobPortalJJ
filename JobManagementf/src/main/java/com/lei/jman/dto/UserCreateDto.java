package com.lei.jman.dto;

import com.lei.jman.enums.Role;

public class UserCreateDto {
	 private String firstName;
	    private String lastName;
	    private String linkedinProfile;
	    private String email;
	    private Role role;
	    private String password;

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
	    
	    

	    public String getLinkedinProfile() {
			return linkedinProfile;
		}

		public void setLinkedinProfile(String linkedinProfile) {
			this.linkedinProfile = linkedinProfile;
		}

		public void setPassword(String password) {
	        this.password = password;
	    }
	}