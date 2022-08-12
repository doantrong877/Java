package com.trong.jsp.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.trong.jsp.models.Book;
import com.trong.jsp.repositories.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;
		
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	 public List<Book> allBooks() {
	        return bookRepository.findAll();
	    }
	    // creates a book
	    public Book createBook(Book b) {
	        return bookRepository.save(b);
	    }
	    // retrieves a book
	    public Book findBook(Long id) {
	        Optional<Book> optionalBook = bookRepository.findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
	    //update book
	    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
	    	Book a = findBook(id);
	    	if(a != null) {
	    		a.setTitle(title);
	    		a.setDescription(desc);
	    		a.setLanguage(lang);
	    		a.setNumberOfPages(numOfPages);
	    		a.setUpdatedAt(new Date());
	    		bookRepository.save(a);
	    	}
	    	return a;
	    }
	    
	    public void deleteBook(Long id) {
	    	bookRepository.deleteById(id);
	    }
}
