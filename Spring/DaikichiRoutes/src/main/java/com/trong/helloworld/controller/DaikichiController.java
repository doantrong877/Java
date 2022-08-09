package com.trong.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController



public class DaikichiController {
	@RequestMapping("/omikuji")
	public String welcome() {
		return "omikuji.jsp";
	}
	@RequestMapping("/read")
	public String read() {
		return "redeirect:/show";
	}
	@RequestMapping("/show")
	public String show() {
		return "show.jsp";
	}
}
