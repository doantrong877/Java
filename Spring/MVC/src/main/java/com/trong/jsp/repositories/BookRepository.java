package com.trong.jsp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trong.jsp.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();
	List<Book> findByDescriptionContaining(String search);
	
}
