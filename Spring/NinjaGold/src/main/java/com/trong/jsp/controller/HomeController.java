package com.trong.jsp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String toHome() {
		return "redirect:/gold";
	}
	
	@RequestMapping("/gold")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/process", method = RequestMethod.POST)
	public String getForm(
			@RequestParam(value="box") String box,
			HttpSession session) {
		if(box == "farm") {
			session.setAttribute("point", session.getAttribute("point"));
		} else if(box =="cave")
		
	}
}
