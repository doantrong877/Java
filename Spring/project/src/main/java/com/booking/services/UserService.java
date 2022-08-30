package com.booking.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.booking.models.Login;
import com.booking.models.User;
import com.booking.repositories.MemberIDRepository;
import com.booking.repositories.UserRepository;



@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private MemberIDRepository memberIDRepo;
	
	public User register(User newUser, BindingResult result) {
        if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
        	result.rejectValue("email", "Unique", "Email is already in use");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
        	result.rejectValue("email", "Match", "Password dont match");
        }
        
        if(result.hasErrors()) {
        	return null;
        }
        String hash_brows = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hash_brows);
        return userRepo.save(newUser);
    }
	
	
	 public User login(Login newLoginObject, BindingResult result) {
	        // TO-DO: Additional validations!
	    	if(result.hasErrors()) {
	    		return null;
	    	}
	    	Optional<User> user =userRepo.findByEmail(newLoginObject.getEmail());
	    	if(!user.isPresent()) {
	    		result.rejectValue("email", "Unique", "Invalid Credentials");
	    		return null;
	    	} 
	    	
	    	User user1 = user.get();
	    	
	    	if(!BCrypt.checkpw(newLoginObject.getPassword(), user1.getPassword())) {
	    		result.rejectValue("password", "Matches", "Invalid Credentials");
	    		return null;
	    	}
	        return user1;
	    }
	 
	 
	 public User getOne(Long id) {
	    	return userRepo.findById(id).orElse(null);
	    }
	 
	 
	 public String getRole(Long id) {
		 User user = getOne(id);
		 return user.getRole();
	 }
	 
	 public void setRole(Long id,String role) {
		 User user = getOne(id);
		 user.setRole(role);
		 String newId = user.getMemberID().getMemberId();
		 
		 if(role.equals("staff")) {			 
			 char[] temp = newId.toCharArray();
			 temp[0] = 's';
			 newId = String.valueOf(temp);
		 } else if(role.equals("manager")){
			 char[] temp = newId.toCharArray();
			 temp[0] = 'm';
			 newId = String.valueOf(temp);
		 }
		 user.getMemberID().setMemberId(newId);
		 
	 }
	 public List<User> allUser(){
		 return userRepo.findAll();
	 }
	 
	 
	 public void deleteUser(Long id) {
			User user = getOne(id);
			memberIDRepo.deleteById(user.getMemberID().getId());
			userRepo.deleteById(id);
		}
}
