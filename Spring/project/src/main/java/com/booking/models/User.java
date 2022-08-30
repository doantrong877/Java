package com.booking.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="First name is required!")
    @Size(min=2, max=30, message="First name must be between 2 and 30 characters")
    private String firstName;
	
	@NotEmpty(message="Last name is required!")
    @Size(min=2, max=30, message="Last name must be between 2 and 30 characters")
    private String lastName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public MemberID getMemberID() {
		return memberID;
	}
	public void setMemberID(MemberID memberID) {
		this.memberID = memberID;
	}
	public Set<Message> getMessages() {
		return messages;
	}
	public void setMessages(Set<Message> messages) {
		this.messages = messages;
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
	@NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
	
	@NotEmpty(message="no role has been assigned")
	private String role;
	
	@NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
	
	@Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
	
	@Transient
    @NotEmpty(message="memberID is required!")
    @Size(min=8, max=255, message="memberID Password must be between 8 and 255 characters")
    private String memberIDConfirm;
	
	public String getMemberIDConfirm() {
		return memberIDConfirm;
	}
	public void setMemberIDConfirm(String memberIDConfirm) {
		this.memberIDConfirm = memberIDConfirm;
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "member_id", referencedColumnName = "id")
	private MemberID memberID;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private Set<Message> messages;
	
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
   
	
	
}
