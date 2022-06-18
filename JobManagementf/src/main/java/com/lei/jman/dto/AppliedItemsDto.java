package com.lei.jman.dto;

import javax.validation.constraints.NotNull;

public class AppliedItemsDto {
	  private @NotNull String location;
	    private @NotNull int quantity;
	    private @NotNull int appliedId;
	    private @NotNull int productId;

	    public AppliedItemsDto () {}

	    public AppliedItemsDto(@NotNull String location, @NotNull int quantity, @NotNull int appliedId, @NotNull int productId) {
	        this.location = location;
	        this.quantity = quantity;
	        this.appliedId = appliedId;
	        this.productId = productId;
	    }

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		

		public int getAppliedId() {
			return appliedId;
		}

		public void setAppliedId(int appliedId) {
			this.appliedId = appliedId;
		}

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}
	    
	    
	    
	    
	    }

	   