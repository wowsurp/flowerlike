package com.ajs.apppush.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajs.apppush.entity.EmployeeLike;

@Repository
public interface EmployeeLikeRepository extends JpaRepository<EmployeeLike, Integer>{

}
