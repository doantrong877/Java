package com.trong.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="courses")
public class Course {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotEmpty(message="Name is required!")
	    @Size(min=3, max=30, message="Name must be between 3 and 30 characters")
	    private String name;
	    
	    @NotEmpty(message="Description is required!")
	    @Size(min=3, max=2000, message="Description must be between 3 and 2000 characters")
	    private String description;
	    
	    private String instructor;
	    
	    public String getInstructor() {
			return instructor;
		}
		public void setInstructor(String instructor) {
			this.instructor = instructor;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		@NotEmpty(message="Day of Week is required!")
	    private String dayOfWeek;
	    
	    @NotNull(message="Price is required!")
	    @Min(value= 1, message="Must be at least 1")
	    private Integer price;
	
	    
	   
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    
	    
	    private User user;
	    
	    
	    @Column(updatable= false)
	    private Date createdAt;
	    private Date updatedAt;
	    @PrePersist
	    protected void onCreate() {
	    	this.createdAt = new Date();
	    }
		@PreUpdate
	    protected void onUpdated() {
	    	this.updatedAt = new Date();
	    }
	    public Course() {}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDayOfWeek() {
			return dayOfWeek;
		}
		public void setDayOfWeek(String dayOfWeek) {
			this.dayOfWeek = dayOfWeek;
		}
		public Integer getPrice() {
			return price;
		}
		public void setPrice(Integer price) {
			this.price = price;
		}
		
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
}
