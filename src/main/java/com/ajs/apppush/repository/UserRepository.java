package com.ajs.apppush.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajs.apppush.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
}
