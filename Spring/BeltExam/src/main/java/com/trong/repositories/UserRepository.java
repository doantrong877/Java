package com.trong.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trong.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	Optional<User> findByEmail(String email);
	Optional<User> findByid(Long id);
	List<User> findAll();
}
