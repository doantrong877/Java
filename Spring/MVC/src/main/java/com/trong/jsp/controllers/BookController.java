package com.trong.jsp.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.trong.jsp.models.Book;
import com.trong.jsp.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	@GetMapping("/books/{bookId}")
	public String index(@PathVariable("bookId") Long bookId, Model model) {
		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
		
		System.out.println(book);
		model.addAttribute("book", book);
		return "index.jsp";
	}
}
