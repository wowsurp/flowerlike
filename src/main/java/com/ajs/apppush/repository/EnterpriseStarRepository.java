package com.ajs.apppush.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajs.apppush.entity.EnterpriseStar;

@Repository
public interface EnterpriseStarRepository extends JpaRepository<EnterpriseStar, Integer>{

}
