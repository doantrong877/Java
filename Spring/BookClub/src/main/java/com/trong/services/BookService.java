package com.trong.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;


import com.trong.models.Book;
import com.trong.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepo;
	
	
	 public Book getOne(Long id) {
		 if(id == null) {
			 return null;
		 }
		 Optional<Book> optionalBook = bookRepo.findById(id);
			if(optionalBook.isPresent()) {
				return optionalBook.get();
			}else {
				return null;
			}
	    	
	    }
	 
	 public List<Book> allBook(){
		 return bookRepo.findAll();
	 }
	 public Book save(Book book,BindingResult result) {
		 if(result.hasErrors()) {
	        	return null;
		 }
		 Book book2 = getOne(book.getId());
	       if( book2 != null) {
	    	   book.setTitle(book.getTitle());
	    	   book.setAuthor(book.getAuthor());
	    	   book.setThought(book.getPosted());
	    	   book.setUpdatedAt(new Date());
	       }
		 return bookRepo.save(book);
	 }
	
}
