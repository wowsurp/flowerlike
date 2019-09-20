package com.ajs.apppush.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajs.apppush.entity.EnterpriseLike;

@Repository
public interface EnterpriseLikeRepository extends JpaRepository<EnterpriseLike, Integer>{

}
