package com.trong.dojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.trong.dojos.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja,Long> {
	List<Ninja> findAll();
}
