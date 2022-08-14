package com.trong.travel.services;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.trong.travel.models.Travel;
import com.trong.travel.repositories.TravelRepository;

@Service
public class TravelService {

	private final TravelRepository travelRepo;
	
	public TravelService(TravelRepository travelRepo) {
		this.travelRepo = travelRepo;
	}
	
	//retrieve all travels
	public List<Travel> allTravel(){
		return travelRepo.findAll();
	}
	
	//retrieve one travel
	public Travel findTravel(Long id) {
		Optional<Travel> optionalTravel = travelRepo.findById(id);
		if(optionalTravel.isPresent()) {
			return optionalTravel.get();
		} else {
			return null;
		}
	}
	
	//creates a Travel
	public Travel createTravel(Travel travel) {
		return travelRepo.save(travel);
	}
	
	//edit travel
	public Travel updateTravel(Travel a) {
		Travel travel = findTravel(a.getId());
		if(travel != null) {
			travel.setExpense(a.getExpense());
			travel.setVendor(a.getVendor());
			travel.setAmount(a.getAmount());
			travel.setDescription(a.getDescription());
			travel.setUpdatedAt(new Date());
			travelRepo.save(travel);
		}
		return travel;
	}
	
	//delete travel
	public void deleteTravel(Long id) {
		travelRepo.deleteById(id);
	}
	
}
