package com.lei.jman.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lei.jman.dto.ApplyDto;
import com.lei.jman.dto.ApplyItemDto;
import com.lei.jman.dto.ApplyToDto;
import com.lei.jman.exceptions.ApplyItemNotExistException;
import com.lei.jman.exceptions.JobNotExistException;
import com.lei.jman.model.Apply;
import com.lei.jman.model.Job;
import com.lei.jman.model.User;
import com.lei.jman.repository.ApplyRepository;

@Service
@Transactional
public class ApplyService {
	@Autowired
    private  ApplyRepository applyRepository;

    public ApplyService(){}

    public ApplyService(ApplyRepository applyRepository) {
        this.applyRepository = applyRepository;
    }

    public void addToApply(ApplyToDto addToApplyDto, Job job, User user){
        Apply apply = new Apply(job, addToApplyDto.getQuantity(), user);
        applyRepository.save(apply);
    }


    public ApplyDto listApplyItems(User user) {
        List<Apply> applyList = applyRepository.findAllByUserAppliedByCreatedDateDesc(user);
        List<ApplyItemDto> applyItems = new ArrayList<>();
        for (Apply apply:applyList){
        	ApplyItemDto applyItemDto = getDtoFromApply(apply);
        	applyItems.add(applyItemDto);
        }
		return null;
        
    }


    public static ApplyItemDto getDtoFromApply(Apply apply) {
        return new ApplyItemDto(apply);
    }


    public void updateApplyItem(ApplyToDto applyDto, User user,Job job){
        Apply apply = applyRepository.getOne(applyDto.getId());
        apply.setQuantity(applyDto.getQuantity());
        apply.setCreatedDate(new Date());
        applyRepository.save(apply);
    }

    public void deleteApplyItem(int id,int userId) throws ApplyItemNotExistException {
        if (!applyRepository.existsById(id))
            throw new ApplyItemNotExistException("Apply id is invalid : " + id);
        applyRepository.deleteById(id);

    }

    public void deleteApplyItems(int userId) {
    	applyRepository.deleteAll();
    }


    public void deleteUserApplyItems(User user) {
    	applyRepository.deleteByUser(user);
    }
}