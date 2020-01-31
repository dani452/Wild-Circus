package com.wildCircus.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildCircus.demo.entity.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

}
