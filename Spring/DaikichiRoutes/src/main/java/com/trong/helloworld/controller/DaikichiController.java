package com.trong.helloworld.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DaikichiController {
	@RequestMapping("/")
	public String welcome1() {
		return "redirect:/omikuji";
	}
	@RequestMapping("/omikuji")
	public String welcome() {
		return "omikuji.jsp";
	}
	
	@RequestMapping(value="/read", method=RequestMethod.POST)
	public String read(HttpSession session,
			@RequestParam(value="number") int number,
			@RequestParam(value="city") String city,
			@RequestParam(value="name") String name,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="thing") String thing,
			@RequestParam(value="message") String message) {
		
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name",name );
		session.setAttribute("hobby",hobby);
		session.setAttribute("thing",thing);
		session.setAttribute("message",message);
		
		return "redirect:/show";
	}
	
	@RequestMapping("/show")
	public String show(Model model, HttpSession session) {
		
		model.addAttribute("number", session.getAttribute("number"));
		model.addAttribute("city", session.getAttribute("city"));
		model.addAttribute("name", session.getAttribute("name"));
		model.addAttribute("hobby", session.getAttribute("hobby"));
		model.addAttribute("thing", session.getAttribute("thing"));
		model.addAttribute("message", session.getAttribute("message"));
		
		return "show.jsp";
	}
}
