package com.rishabh.login.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;*/
//import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "USER_TBL")
@Document(collection = "User")
public class User {
    
	 @Transient
	    public static final String SEQUENCE_NAME = "user_sequence";
	
	 // @GeneratedValue(strategy = GenerationType.AUTO)
    
	@Id 
    private int id;
    private String userName;
    private String password;
    private String email;
    private String role;
    
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email + ", role="
				+ role + "]";
	}

	public User(int id, String userName, String password, String email, String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

	public String getRole() {
		return role;
	}

	public User() {
			}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(int id, String userName, String password, String email) {
		
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	
	
}
