package com.lei.jman.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lei.jman.model.AppliedItem;
import com.lei.jman.repository.AppliedItemsRepository;
@Service
@Transactional
public class AppliedItemsService {
	@Autowired
    private AppliedItemsRepository appliedItemsRepository;

    public void addOrderedProducts(AppliedItem appliedItem) {
    	appliedItemsRepository.save(appliedItem);
    }


}