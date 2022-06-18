package com.lei.jman.dto;

public class DoneApplyDto {
	 private String jobName;
	    private int  quantity;
	    private String location;
	    private long jobId;
	    private int userId;

	    public DoneApplyDto() {}

	    public DoneApplyDto(String jobName, int quantity, String location, long jobId, int userId) {
	        this.jobName = jobName;
	        this.quantity = quantity;
	        this.location = location;
	        this.jobId = jobId;
	        this.userId = userId;
	    }

	    public String getJobName() {
	        return jobName;
	    }

	    public void setJobName(String jobName) {
	        this.jobName = jobName;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    public void setLocation(String location) {
	        this.location = location;
	    }

	    public String getLocation(){return location;}

	    public int getUserId() {
	        return userId;
	    }

	    public void setUserId(int userId) {
	        this.userId = userId;
	    }

	    public long getJobId() {
	        return jobId;
	    }

	    public void setJobId(long id) {
	        this.jobId = id;
	    }



	}