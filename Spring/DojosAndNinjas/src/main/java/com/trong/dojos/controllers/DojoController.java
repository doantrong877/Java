package com.trong.dojos.controllers;

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

import com.trong.dojos.models.Dojo;
import com.trong.dojos.models.Ninja;
import com.trong.dojos.services.DojoService;
import com.trong.dojos.services.NinjaService;

@Controller
public class DojoController {
	@Autowired
	DojoService dojoService;
	@Autowired
	NinjaService ninjaService;
	@GetMapping("/")
	public String home(Model model,@ModelAttribute("dojo1") Dojo dojo) {
		List<Dojo> dojos = dojoService.allDojo();
		model.addAttribute("dojos", dojos);
		return "home.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String create(@ModelAttribute("dojo") Dojo dojo) {
		return "createDojo.jsp";
	}
	
	@PostMapping("/postdojo")
	public String postDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "createDojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	@PostMapping("/dojos/post")
	public String dis(@Valid @ModelAttribute("dojo1") Dojo dojo,BindingResult result) {
		
		if(result.hasErrors()) {
			return "createDojo.jsp";
		} else {
			return "redirect:/dojos/" + String.valueOf(dojo.getId());
		}
		
	}
	
	@GetMapping("/dojos/{id}")
	public String display(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		List<Ninja> ninjas = dojo.getNinjas();
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", ninjas);
		return "displayNinja.jsp";
	}
	
}
