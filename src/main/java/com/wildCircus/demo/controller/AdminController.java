package com.wildCircus.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/admin")
	public String findAll() {
		return "admin";
	}
	
	@GetMapping("/adminHome")
	public String findAllAdminHome() {
		return "adminHome";
	}
}
