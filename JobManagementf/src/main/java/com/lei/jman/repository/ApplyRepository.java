package com.lei.jman.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lei.jman.model.Apply;
import com.lei.jman.model.User;
@Repository
public interface ApplyRepository extends JpaRepository<Apply, Integer> {

    List<Apply> findAllByUserAppliedByCreatedDateDesc(User userId);
    List<Apply> deleteByUser(User user);

}