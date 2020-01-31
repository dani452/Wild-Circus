package com.wildCircus.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wildCircus.demo.repository.PerformanceRepository;
import com.wildCircus.demo.service.FileUpload;
import com.wildCircus.demo.entity.Performances;

@Controller
public class PerformanceController {

	@Autowired
	private PerformanceRepository performanceRepository;

	@GetMapping("/admin_performance")
	public String getAllEvent(Model model) {
		model.addAttribute("perfs", performanceRepository.findAll());
		return "adminHome";
	}

	@GetMapping("admin_performance/edit")
	public String showFormPhoto(Model model, @RequestParam String name) {
		
		model.addAttribute("perf", performanceRepository.getOne(name));

		return "adminHome_edit";
	}

	@PostMapping("admin_performance/edit")
	public String editPhoto(@RequestParam String name, @RequestParam String description, @RequestParam MultipartFile NewPhoto) {
		Performances performances = performanceRepository.getOne(name);
		FileUpload filUpload = new FileUpload();
		String fileName = "/image/" + NewPhoto.getOriginalFilename();
		filUpload.writeFile(NewPhoto, fileName);
		performances.setPhoto(fileName);
		performances.setDescription(description);
		performanceRepository.save(performances);

		return "redirect:/admin_performance";
	}

}
