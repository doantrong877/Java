package com.trong.dojos.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.trong.dojos.models.Ninja;
import com.trong.dojos.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	//get all ninjas
	public List<Ninja> allNinja(){
		return ninjaRepo.findAll();
	}
	
	//get ninja by id
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}else {
			return null;
		}
	}
	
	//create Ninja
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	//delete Ninja
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
	
	//update Ninja
	public void updateDojo(Ninja ninja) {
	 Ninja temp = findNinja(ninja.getId());
	 if(temp != null) {
		 temp.setFirstName(ninja.getFirstName());
		 temp.setLastName(ninja.getLastName());
		 temp.setAge(ninja.getAge());
		 temp.setUpdatedAt(new Date());
	 }
	}
}