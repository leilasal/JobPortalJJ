package com.lei.jman.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.lei.jman.model.Apply;
import com.lei.jman.model.Job;

public class ApplyDto {
	private List<ApplyItemDto> applyItems;
	private String tlocation;


    public ApplyDto(List<ApplyItemDto> applyItemDtoList, String tlocation) {
        this.applyItems = applyItemDtoList;
        this.tlocation=tlocation;
        
    }

    public List<ApplyItemDto> getapplyItems() {
        return applyItems;
    }

    public void setApplyItems(List<ApplyItemDto> applyItemDtoList) {
        this.applyItems = applyItemDtoList;
    }

	public String getTlocation() {
		return tlocation;
	}

	public void setTlocation(String tlocation) {
		this.tlocation = tlocation;
	}

    
}