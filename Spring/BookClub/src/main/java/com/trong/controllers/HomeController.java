package com.trong.controllers;

import java.util.List;

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

import com.trong.models.Book;
import com.trong.models.LoginUser;
import com.trong.models.User;
import com.trong.services.BookService;
import com.trong.services.UserService;

@Controller
public class HomeController {
	@Autowired
    private UserService userServ;
	@Autowired
	private BookService bookServ;
	
	 @GetMapping("/")
	    public String index(Model model) {
	    
	        // Bind empty User and LoginUser objects to the JSP
	        // to capture the form input
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	    }
	 @GetMapping("/books")
	    public String home(Model model,HttpSession session) {
	    	User user = userServ.getOne((long) session.getAttribute("userId"));
	    	List<Book> books = bookServ.allBook();
	    	model.addAttribute("books", books);
	    	model.addAttribute("user", user);
	    	return "home.jsp";
	    	
	    }
	 @GetMapping("/books/new")
	    public String insert(Model model,HttpSession session) {
	    	User user = userServ.getOne((long) session.getAttribute("userId"));
	    	
	    	model.addAttribute("books", new Book());
	    	model.addAttribute("user", user);
	    	return "insert.jsp";
	    	
	    }
	 @GetMapping("/books/{id}")
	 public String detail(@PathVariable("id") Long id, HttpSession session, Model model) {
		 model.addAttribute("book", bookServ.getOne(id));
		 model.addAttribute("user", userServ.getOne((long) session.getAttribute("userId")));
		 return "detail.jsp";
	 }
	 @GetMapping("/books/{id}/edit")
	 public String edit(@PathVariable("id") Long id, HttpSession session, Model model) {
		 model.addAttribute("book", bookServ.getOne(id));
		 model.addAttribute("user", userServ.getOne((long) session.getAttribute("userId")));
		 return "edit.jsp";
	 }
	 
	 @PostMapping("/postedit/")
	 public String postEdit(@Valid @ModelAttribute("book") Book book,BindingResult result, Model model,HttpSession session) {
		 
		 if(result.hasErrors()) {
			 User user = userServ.getOne((long) session.getAttribute("userId"));
			 model.addAttribute("user", user);
			 return "edit.jsp";
		 }
		 bookServ.save(book, result);
		 return "redirect:/books";
	 }
	 
	 @PostMapping("/postbook")
	 public String postBook(@Valid @ModelAttribute("books") Book book,BindingResult result, Model model,HttpSession session) {
		 
		 if(result.hasErrors()) {
			 User user = userServ.getOne((long) session.getAttribute("userId"));
			 model.addAttribute("user", user);
			 return "insert.jsp";
		 }
		 bookServ.save(book, result);
		 return "redirect:/books";
	 }
	 @GetMapping("/logout")
	    public String logout(HttpSession session) {
	    	session.removeAttribute("userId");
	    	return "redirect:/";
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
	    
	        return "redirect:/books";
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
	    
	        return "redirect:/books";
	    }
	    
}
