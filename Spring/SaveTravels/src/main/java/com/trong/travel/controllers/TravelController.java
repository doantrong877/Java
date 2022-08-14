package com.trong.travel.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.trong.travel.models.Travel;
import com.trong.travel.services.TravelService;

@Controller
public class TravelController {
	@Autowired
	TravelService travelService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String index(Model model, @ModelAttribute("form") Travel form) {
		List<Travel> travel = travelService.allTravel();
		model.addAttribute("travels", travel);
		return "index.jsp";
	}
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("form") Travel form,
							BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			travelService.createTravel(form);
			return "redirect:/expenses";
		}
		
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		travelService.deleteTravel(id);
		return "redirect:/";
	}
	
	@GetMapping("expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model, @ModelAttribute("form") Travel form ) {
		Travel travel = travelService.findTravel(id);
		model.addAttribute("travel", travel);
		return "edit.jsp";
	}
	
	@PostMapping("/expenses/update")
	public String update(@Valid @ModelAttribute("form") Travel form,
							BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			travelService.updateTravel(form);
			return "redirect:/expenses";
		}
		
	}
	@GetMapping("/expenses/{id}")
	public String display(@PathVariable("id")Long id, Model model) {
		Travel travel = travelService.findTravel(id);
		model.addAttribute("travel", travel);
		return "detail.jsp";
	}
	
}
