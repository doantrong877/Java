package com.trong.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trong.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
	Optional<Book> findByTitle(String title);
	Optional<Book> findByid(Long id);
	List<Book> findAll();
}
