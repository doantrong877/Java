package com.trong.dojos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.trong.dojos.models.Dojo;
import com.trong.dojos.models.Ninja;
import com.trong.dojos.services.DojoService;
import com.trong.dojos.services.NinjaService;

@Controller
public class NinjaController {
	
	@Autowired
	NinjaService ninjaService;
	@Autowired
	DojoService dojoService;
	
	@GetMapping("/ninjas/new")
	public String create(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> dojo = dojoService.allDojo();
		model.addAttribute("dojos", dojo);
		return "createNinja.jsp";
	}
	

	
	@PostMapping("/postninja")
	public String postNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "createNinja.jsp";
		}else {
			ninjaService.createNinja(ninja);
			return "redirect:/";
		}
	}
}
