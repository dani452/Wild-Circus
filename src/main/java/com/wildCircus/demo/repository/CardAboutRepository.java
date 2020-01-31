package com.wildCircus.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildCircus.demo.entity.CardAbout;

@Repository
public interface CardAboutRepository extends JpaRepository<CardAbout, String>{

}
