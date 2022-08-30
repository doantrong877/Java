package com.booking.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.booking.models.Login;
import com.booking.models.User;
import com.booking.services.UserService;

@Controller
public class UserController {
	@Autowired 
	private UserService userServ;
	
	//login page
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("login", new Login());
		return "login.jsp";
	}
	
	@GetMapping("/client")
	public String client(Model model) {
		model.addAttribute("login", new Login());
		return "clientLogin.jsp";
	}@GetMapping("/associate")
	public String associate(Model model) {
		model.addAttribute("login", new Login());
		return "associateLogin.jsp";
	}
	
	@GetMapping("/manager")
	public String manager(Model model) {
		model.addAttribute("login", new Login());
		return "managerLogin.jsp";
	}
	
	
//	@PostMapping("/login")
//	public String login(@Valid @ModelAttribute("login") Login login, BindingResult result,
//			Model model, HttpSession session) {
//		User user = userServ.login(login, result);
//		 if(result.hasErrors()) {
//	            model.addAttribute("newUser", new User());
//	            return "login.jsp";
//	        }
//		 session.setAttribute("userId", user.getId());
//		 String role = userServ.getRole(user.getId());
//		 
//		 if(role.equals("associate")) {
//			 return "redirect:/associate";
//			 
//		 } else if(role.equals("manager")) {
//			 return "redirect:/manager";
//		 } 
//			
//		 return "redirect:/client";
//		 
//	}
	
	//Register Page
	@GetMapping("/register")
	public String register() {
		return "register.jsp";
	}
	
	@PostMapping("/register/post")
	public String registerPost
	
	//Reset password Page
		@GetMapping("/resetpw")
		public String reset() {
			
			return "resetpassword.jsp";
		}
	@PostMapping("/reset/post")
	public String resetpw() {
		return "reset.jsp";
	}
	
	
}
