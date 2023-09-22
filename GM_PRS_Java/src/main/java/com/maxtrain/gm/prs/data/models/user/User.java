package com.maxtrain.gm.prs.data.models.user;

import jakarta.persistence.*;

@Entity
@Table(name="Users", uniqueConstraints=@UniqueConstraint(name="UIDX_Username", columnNames = {"Username"}))
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	@Column(length=30,nullable=false)
	public String username;
	
	@Column(length=30,nullable=false)
	public String password;
	
	@Column(length=30,nullable=false)
	public String firstname;
	
	@Column(length=30,nullable=false)
	public String lastname;
	
	@Column(length=12,nullable=true)
	public String phone;
	
	@Column(length=255,nullable=true)
	public String email;
	
	@Column(columnDefinition="bit not null")
	public boolean isReviewer;
	
	@Column(columnDefinition="bit not null")
	public boolean isAdmin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isReviewer() {
		return isReviewer;
	}

	public void setReviewer(boolean isReviewer) {
		this.isReviewer = isReviewer;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
