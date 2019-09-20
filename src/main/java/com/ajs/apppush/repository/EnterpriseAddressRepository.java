package com.ajs.apppush.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajs.apppush.entity.EnterpriseAddress;

@Repository
public interface EnterpriseAddressRepository extends JpaRepository<EnterpriseAddress, Integer>{

}
