package com.trong.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HomeController {
	
	@RequestMapping("")
	public String index() {
		return "<h1>Hello World1</h1>";
	}
	@RequestMapping("/world")
	public String world() {
		return "second world";
	}
}
