package com.wildCircus.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wildCircus.demo.entity.Price;
import com.wildCircus.demo.repository.PriceRepository;

@Controller
public class PriceController {

	@Autowired
	private PriceRepository priceRepository;

	
	@GetMapping("/admin/price")
	public String getPrice(Model model) {


		model.addAttribute("prices", priceRepository.findAll());
		return "adminPrice";
	}
	
	@GetMapping("/admin/price/edit")
	public String getHoraire(Model model, @RequestParam(required = false) Long id) {

		Price price = new Price();
		if (id != null) {
			Optional<Price> optionalPrice = priceRepository.findById(id);
			if (optionalPrice.isPresent()) {
				price = optionalPrice.get();
			}
		}
		model.addAttribute("price", price);

		return "adminPriceEdit";
	}

	@PostMapping("/price")
	public String postWizard(@ModelAttribute Price price) {

		priceRepository.save(price);
		return "redirect:/admin/price";
	}
}
