package com.ajs.apppush.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajs.apppush.entity.WorkingHistory;

@Repository
public interface WorkingHistoryRepository extends JpaRepository<WorkingHistory, Integer>{

}
