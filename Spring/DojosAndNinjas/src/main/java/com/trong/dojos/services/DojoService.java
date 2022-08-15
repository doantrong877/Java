package com.trong.dojos.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.trong.dojos.models.Dojo;
import com.trong.dojos.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	//get all dojos
	public List<Dojo> allDojo(){
		return dojoRepo.findAll();
	}
	
	//get dojo by id
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else {
			return null;
		}
	}
	
	//create Dojo
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	//delete Dojo
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
	
	//update Dojo
	public void updateDojo(Dojo dojo) {
	 Dojo temp = findDojo(dojo.getId());
	 if(temp != null) {
		 temp.setName(dojo.getName());
		 temp.setUpdatedAt(new Date());
	 }
	}
}
