package com.trong.jsp.controllers;



import java.util.List;

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
	@GetMapping("/books")
	public String index( Model model) {
		
		List<Book>book = bookService.allBooks();
		
		System.out.println(book);
		model.addAttribute("books", book);
		return "index.jsp";
	}
	@GetMapping("/books/{id}")
	public String info(@PathVariable("id") Long bookId, Model model) {
		
		Book book = bookService.findBook(bookId);
		
		System.out.println(book);
		model.addAttribute("book", book);
		return "display.jsp";
	}
}
