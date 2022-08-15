package com.trong.dojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.trong.dojos.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();
}
