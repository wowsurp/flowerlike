package com.ajs.apppush.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajs.apppush.entity.Enterprise;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Integer>{

}
