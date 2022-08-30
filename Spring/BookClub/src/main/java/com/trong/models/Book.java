package com.trong.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message="Title is required!")
    @Size(min=2, max=100, message="Title must be between 2 and 100 characters")
    private String title;
	
	@NotEmpty(message="Author's name is required!")
    @Size(min=2, max=30, message="Author's name must be between 2 and 30 characters")
    private String author;
	
	
    private String posted;
	
	public String getPosted() {
		return posted;
	}
	public void setPosted(String posted) {
		this.posted = posted;
	}

	@NotEmpty(message="Thought is required!")
    @Size(min=2, max=2000, message="Thought name must be between 2 and 30 characters")
    private String thought;
	
	 @Column(updatable= false)
	    private Date createdAt;
	    private Date updatedAt;
	    @PrePersist
	    protected void onCreate() {
	    	this.createdAt = new Date();
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
		@PreUpdate
	    protected void onUpdated() {
	    	this.updatedAt = new Date();
	    }
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getThought() {
		return thought;
	}

	public void setThought(String thought) {
		this.thought = thought;
	}
	
	
}
