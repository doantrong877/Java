package com.trong.services;
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
    
    // TO-DO: Write register and login methods!
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
        return null;
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!
        return null;
    }
    
    public User getOne(Long id) {
    	return userRepo.findById(id).orElse(null);
    }
}