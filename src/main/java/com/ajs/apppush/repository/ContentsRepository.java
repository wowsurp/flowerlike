package com.ajs.apppush.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajs.apppush.entity.Contents;

@Repository
public interface ContentsRepository extends JpaRepository<Contents, Integer>{

}
