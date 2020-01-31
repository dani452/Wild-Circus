package com.wildCircus.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wildCircus.demo.entity.About;
import com.wildCircus.demo.entity.CardAbout;
import com.wildCircus.demo.repository.AboutRepository;
import com.wildCircus.demo.repository.CardAboutRepository;
import com.wildCircus.demo.service.FileUpload;



@Controller
public class AboutController {
	
	@Autowired
	private AboutRepository aboutRepository;
	
	@Autowired
	private CardAboutRepository cardAboutRepository;
	
	@GetMapping("/admin_about")
	public String getAllEvent(Model model) {
		model.addAttribute("images", aboutRepository.findAll());
		model.addAttribute("cardAbout", cardAboutRepository.findAll());
		return "adminAbout";
	}

	@GetMapping("admin_about/edit")
	public String showFormPhoto(Model model, @RequestParam String name) {
		model.addAttribute("about", aboutRepository.getOne(name));

		return "adminAbout_edit";
	}

	@PostMapping("admin_about/edit")
	public String editPhoto(@RequestParam String name, @RequestParam MultipartFile NewPhoto) {
		About about = aboutRepository.getOne(name);
		FileUpload filUpload = new FileUpload();
		String fileName = "/image/" + NewPhoto.getOriginalFilename();
		filUpload.writeFile(NewPhoto, fileName);
		about.setPhoto(fileName);
		aboutRepository.save(about);

		return "redirect:/admin_about";
	}
	

	@GetMapping("admin_cardAbout/edit")
	public String showForm(Model model, @RequestParam String name) {
		model.addAttribute("card", cardAboutRepository.getOne(name));

		return "adminCardAbout_edit";
	}

	@PostMapping("admin_cardAbout/edit")
	public String editPhoto(@RequestParam String name, @RequestParam String description, @RequestParam MultipartFile NewPhoto) {
		
		CardAbout cardAbout = cardAboutRepository.getOne(name);
		FileUpload filUpload = new FileUpload();
		String fileName = "/image/" + NewPhoto.getOriginalFilename();
		filUpload.writeFile(NewPhoto, fileName);
		cardAbout.setPhoto(fileName);
		cardAbout.setDescription(description);
		cardAboutRepository.save(cardAbout);

		return "redirect:/admin_about";
	}

	
	@PostMapping("admin_cardAbout/add")
	public String addPhoto(@RequestParam String name, @RequestParam String description, @RequestParam MultipartFile NewPhoto) {
		CardAbout cardAbout = new CardAbout();
		FileUpload filUpload = new FileUpload();
		String fileName = "/image/" + NewPhoto.getOriginalFilename();
		filUpload.writeFile(NewPhoto, fileName);
		cardAbout.setPhoto(fileName);
		cardAbout.setDescription(description);
		cardAbout.setName(name);
		cardAboutRepository.save(cardAbout);

		return "redirect:/admin_about";
	}
	
	
	@GetMapping("/admin_cardAbout/delete")
	public String deleteEvent(@RequestParam String name) {
		CardAbout cardAbout = cardAboutRepository.getOne(name);

		cardAboutRepository.delete(cardAbout);

		return "redirect:/admin_about";
	}
	
	@GetMapping("/admin_cardAbout/add")
	public String addCard() {
		return "adminCardAbout_add";
	}
	
}
