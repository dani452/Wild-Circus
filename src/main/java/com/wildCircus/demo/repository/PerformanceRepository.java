package com.wildCircus.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildCircus.demo.entity.Performances;

@Repository
public interface PerformanceRepository extends JpaRepository<Performances, String>{

	
	

}
