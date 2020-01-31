package com.wildCircus.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wildCircus.demo.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
}