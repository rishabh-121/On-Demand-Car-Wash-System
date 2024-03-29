package com.rishabh.eureka.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Profile")
public class Profile {
	
	@Id
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Profile() {
		super();
	}
	public Profile(String username, String firstName, String lastName, String email, String phone, String street, String city,
			String state, String zip) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email=email;
		this.phone = phone;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
	
	

}
