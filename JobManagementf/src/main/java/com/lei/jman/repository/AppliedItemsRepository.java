package com.lei.jman.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lei.jman.model.AppliedItem;


public interface AppliedItemsRepository extends JpaRepository<AppliedItem,Integer> {
}
