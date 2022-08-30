package com.trong.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.trong.models.Course;
import com.trong.repositories.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepo;
	 public Course findCourse(Long id) {
		 if(id == null){
			 return null;
		 }
		 Optional<Course> optionalCourse = courseRepo.findById(id);
			if(optionalCourse.isPresent()) {
				return optionalCourse.get();
			}else {
				return null;
			}
	    }
	 public List<Course> allCourse(){
		 return courseRepo.findAll();
	 }
	//delete 
		public void deleteCourse(Long id) {
			courseRepo.deleteById(id);
		}
		
		public Course createCourse(Course course,BindingResult result) {
			if(result.hasErrors()) {
	        	return null;
		 }
			
			return courseRepo.save(course);
		}
		public Course createCourse(Course course) {
		
			
			return courseRepo.save(course);
		}
		
		public void updateCourse(Course course) {
			 Course temp = findCourse(course.getId());
				 temp.setName(course.getName());
				 temp.setPrice(course.getPrice());
				 temp.setDayOfWeek(course.getDayOfWeek());
				 temp.setDescription(course.getDescription());
				 temp.setUpdatedAt(new Date());
			 
			 createCourse(temp);
			}
		
}
