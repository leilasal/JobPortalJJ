package com.lei.jman.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lei.jman.model.Applied;
import com.lei.jman.model.User;

@Repository
public interface AppliedRepository extends JpaRepository<Applied, Integer> {
    List<Applied> findAllByUserAppliedByCreatedDateDesc(User user);

}