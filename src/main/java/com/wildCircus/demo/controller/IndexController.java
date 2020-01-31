package com.wildCircus.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wildCircus.demo.entity.Contact;
import com.wildCircus.demo.repository.AboutRepository;
import com.wildCircus.demo.repository.CardAboutRepository;
import com.wildCircus.demo.repository.PerformanceRepository;
import com.wildCircus.demo.repository.PriceRepository;

@Controller
public class IndexController {
	
	@Autowired
	private PerformanceRepository performanceRepository;
	
	@Autowired
	private PriceRepository priceRepository;
	
	@Autowired
	private AboutRepository aboutRepository;
	
	@Autowired
	private CardAboutRepository cardAboutRepository;

	@GetMapping("/")
	public String getAllIndex(Model model) {
		model.addAttribute("perf1", performanceRepository.getOne("Performances 1").getPhoto());
		model.addAttribute("perf2", performanceRepository.getOne("Performances 2").getPhoto());
		model.addAttribute("perf3", performanceRepository.getOne("Performances 3").getPhoto());
		model.addAttribute("perf4", performanceRepository.getOne("Performances 4").getPhoto());
		
		model.addAttribute("desc2", performanceRepository.getOne("Performances 2").getDescription());
		model.addAttribute("desc3", performanceRepository.getOne("Performances 3").getDescription());
		model.addAttribute("desc4", performanceRepository.getOne("Performances 4").getDescription());

		return "index";
	}
	
	@GetMapping("/about")
	public String getAllImage(Model model) {
		model.addAttribute("indexImage2", aboutRepository.getOne("image1").getPhoto());
		model.addAttribute("indexImage3", aboutRepository.getOne("image2").getPhoto());
		model.addAttribute("indexImage4", aboutRepository.getOne("image3").getPhoto());
		model.addAttribute("indexImage5", aboutRepository.getOne("image4").getPhoto());
		model.addAttribute("cards", cardAboutRepository.findAll());
		return "about";
	}
	
	@GetMapping("/price")
	public String getPrice(Model model) {
		model.addAttribute("prices", priceRepository.findAll());
		return "Prices";
	}
	
	@GetMapping("/contact")
	public String contactPage(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact",contact);

		return "contactUs";
	}
}
