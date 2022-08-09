package com.trong.human.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required = false) String name,
			@RequestParam(value="last_name", required = false) String lastName) {
	
		if(name == null && lastName == null) {
			
			return "Hello Human";
		}
		if(lastName == null) {
			lastName = "";
		}
		if(name == null) {
			name = "";
		}
		return "Hello " + name + " " + lastName;
	}
	
}
