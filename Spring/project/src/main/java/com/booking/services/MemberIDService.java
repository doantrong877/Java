package com.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.models.MemberID;
import com.booking.repositories.MemberIDRepository;

@Service
public class MemberIDService {
	
	@Autowired
	private MemberIDRepository memberIDRepo;
	
	
	public String checkIdType(String id) {
		String result = "";
		List<MemberID> memberId = memberIDRepo.findAll();
		 boolean checkId = false;
       
       for(MemberID member : memberId) {
       	if(id.equals(member.getMemberId())) {
       		checkId = true;
       	}
       };
       if(checkId == false) {
       	return null;
       }
       
       switch((id.charAt(0))) {
       case 'c':  result = "client";
       break;
       case 's': result = "staff";
       break;
       case 'm': result = "manager";
       default: result = null;
       break;
       }
       return result;
	}
	
	
	
}
