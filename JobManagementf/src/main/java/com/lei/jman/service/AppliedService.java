package com.lei.jman.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lei.jman.dto.ApplyDto;
import com.lei.jman.dto.ApplyItemDto;
import com.lei.jman.dto.DoneApplyDto;
import com.lei.jman.exceptions.AppliedNotFoundException;
import com.lei.jman.model.Applied;
import com.lei.jman.model.AppliedItem;

import com.lei.jman.model.User;
import com.lei.jman.repository.AppliedItemsRepository;
import com.lei.jman.repository.AppliedRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

@Service
@Transactional
public class AppliedService {
	
	@Autowired
    private ApplyService applyService;

    @Autowired
    AppliedRepository appliedRepository;

    @Autowired
    AppliedItemsRepository appliedItemsRepository;

    @Value("${BASE_URL}")
    private String baseURL;

    @Value("${STRIPE_SECRET_KEY}")
    private String apiKey;

  
    

    SessionCreateParams.LineItem createSessionLineItem(DoneApplyDto doneapplyDto) {
        return SessionCreateParams.LineItem.builder()
                .setQuantity(Long.parseLong(String.valueOf(doneapplyDto.getQuantity())))
                .build();
    }

    public Session createSession(List<DoneApplyDto> doneapplyDtoList) throws StripeException {

        // supply success and failure url for stripe
        String successURL = baseURL + "application/success";
        String failedURL = baseURL + "application/failed";

        // set the private key
        Stripe.apiKey = apiKey;

        List<SessionCreateParams.LineItem> sessionItemsList = new ArrayList<>();

        // for each job compute SessionCreateParams.LineItem
        for (DoneApplyDto doneapplyDto : doneapplyDtoList) {
            sessionItemsList.add(createSessionLineItem(doneapplyDto));
        }

        // build the session param
        SessionCreateParams params = SessionCreateParams.builder()
                .setCancelUrl(failedURL)
                .addAllLineItem(sessionItemsList)
                .setSuccessUrl(successURL)
                .build();
        return Session.create(params);
    }

    public void placeApplied(User user, String sessionId) {
        
        ApplyDto applyDto = applyService.listApplyItems(user);

        List<ApplyItemDto> applyItemDtoList = applyDto.getapplyItems();

        Applied newApplied = new Applied();
        newApplied.setCreatedDate(new Date());
        newApplied.setSessionId(sessionId);
        newApplied.setUser(user);
        newApplied.setTlocation(applyDto.getTlocation());
        appliedRepository.save(newApplied);

        for (ApplyItemDto applyItemDto : applyItemDtoList) {
            AppliedItem appliedItem = new AppliedItem();
            appliedItem.setCreatedDate(new Date());
            appliedItem.setLocation(applyItemDto.getJob().getLocation());
            appliedItem.setJob(applyItemDto.getJob());
            appliedItem.setQuantity(applyItemDto.getQuantity());
            appliedItem.setApplied(newApplied);
            appliedItemsRepository.save(appliedItem);
        }
        //
        applyService.deleteUserApplyItems(user);
    }

    public List<Applied> listApplied(User user) {
        return appliedRepository.findAllByUserAppliedByCreatedDateDesc(user);
    }


    public Applied getApplied(Integer appliedId) throws AppliedNotFoundException {
        Optional<Applied> applied = appliedRepository.findById(appliedId);
        if (applied.isPresent()) {
            return applied.get();
        }
        throw new AppliedNotFoundException("Application not found");
    }
}

