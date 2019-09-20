package com.ajs.apppush.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajs.apppush.entity.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer>{

}
