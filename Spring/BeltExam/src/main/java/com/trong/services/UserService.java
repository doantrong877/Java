package com.trong.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.trong.models.LoginUser;
import com.trong.models.User;
import com.trong.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
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
	 public User login(LoginUser newLoginObject, BindingResult result) {
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
	 public List<User> allUser(){
		 return userRepo.findAll();
	 }
		public void deleteUser(Long id) {
			userRepo.deleteById(id);
		}
}
