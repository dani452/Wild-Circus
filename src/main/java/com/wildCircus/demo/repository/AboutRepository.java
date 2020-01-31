package com.wildCircus.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildCircus.demo.entity.About;


@Repository
public interface AboutRepository extends JpaRepository<About, String>{

}
