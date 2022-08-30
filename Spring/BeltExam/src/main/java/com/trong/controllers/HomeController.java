package com.trong.controllers;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.trong.models.Course;
import com.trong.models.LoginUser;
import com.trong.models.User;
import com.trong.services.CourseService;
import com.trong.services.UserService;

@Controller
public class HomeController {
	@Autowired
    private UserService userServ;
	
	@Autowired
	private CourseService courseServ;
	
	 @GetMapping("/")
	    public String index(Model model) {
	    
	        // Bind empty User and LoginUser objects to the JSP
	        // to capture the form input
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	    }
	 
	 @GetMapping("/classes")
	    public String classes(Model model, HttpSession session ) {
		 	
		 User user = userServ.getOne((long)session.getAttribute("userId"));
	        // Bind empty User and LoginUser objects to the JSP
	        // to capture the form input
	        model.addAttribute("user", user);
	        model.addAttribute("courses", courseServ.allCourse());
	        return "home.jsp";
	    }
	 
	 @GetMapping("/classes/new")
	 public String newCourse(Model model, HttpSession session,@ModelAttribute("course") Course course) {
		 User user = userServ.getOne((long)session.getAttribute("userId"));
		 model.addAttribute("user", user);
		 return "insert.jsp";
		 
	 }
	 
	 @GetMapping("/classes/{id}/edit")
	 public String edit(@PathVariable("id") Long id, Model model) {
		 Course course = courseServ.findCourse(id);
		 model.addAttribute("course", course);
		 return "edit.jsp";
	 }
	 
	 @PostMapping("/postedit")
	 public String postEdit(@Valid @ModelAttribute("course") Course course, BindingResult result, Model model, HttpSession session) {
		 if(result.hasErrors()) {
			 User user = userServ.getOne((long) session.getAttribute("userId"));
			 model.addAttribute("user", user);
			 return "edit.jsp";
		 }
		 courseServ.updateCourse(course);
		 return "redirect:/classes";
	 }
	 
	 @GetMapping("/classes/{id}")
	 public String display(@PathVariable("id") Long id, Model model) {
		 Course course = courseServ.findCourse(id);
		 model.addAttribute("course", course);
		 return "display.jsp";
	 }
	 
	 @PostMapping("/postcourse")
	public String postCourse(@Valid @ModelAttribute("course") Course course, BindingResult result, Model model, HttpSession session) {
		 if(result.hasErrors()) {
			 User user = userServ.getOne((long) session.getAttribute("userId"));
			 model.addAttribute("user", user);
			 return "insert.jsp";
		 }
		 courseServ.createCourse(course,result);
		 return "redirect:/classes";
	 }
	 
	 
	 @GetMapping("/logout")
	    public String logout(HttpSession session) {
	    	session.removeAttribute("userId");
	    	return "redirect:/";
	 }
	 
	 @GetMapping("/delete/{id}")
	 public String delete(@PathVariable("id") Long id) {
		 courseServ.deleteCourse(id);
		 return "redirect:/classes";
	 }
	    @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
	        User user = userServ.register(newUser, result);
	        // TO-DO Later -- call a register method in the service 
	        // to do some extra validations and create a new user!
	        
	        if(result.hasErrors()) {
	            // Be sure to send in the empty LoginUser before 
	            // re-rendering the page.
	            model.addAttribute("newLogin", new LoginUser());
	            return "index.jsp";
	        }
	        session.setAttribute("userId", user.getId());
	        // No errors! 
	        // TO-DO Later: Store their ID from the DB in session, 
	        // in other words, log them in.
	    
	        return "redirect:/classes";
	    }
	    
	    
	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        
	        // Add once service is implemented:
	         User user = userServ.login(newLogin, result);
	    
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "index.jsp";
	        }
	        session.setAttribute("userId", user.getId());
	        // No errors! 
	        // TO-DO Later: Store their ID from the DB in session, 
	        // in other words, log them in.
	    
	        return "redirect:/classes";
	    }
	    
}
