package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class RegistrationBean {
	
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String birth;
	private int status=0;
	private String role="Voter";
	private User user;
	
	public RegistrationBean() {
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getBirth() {
		return birth;
	}



	public void setBirth(String birth) {
		this.birth = birth;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}
	
	



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "RegistrationBean [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", birth=" + birth + ", status=" + status + ", role=" + role + "]";
	}



	public void registerUser() {
		try(UserDao userDao = new UserDaoImpl()) {
			
			user = new User();
			user.setFirstName(firstname);
	        user.setLastName(lastname);
	        user.setBirth(java.sql.Date.valueOf(birth));
	        user.setEmail(email);
	        user.setPassword(password);
	        user.setRole(role);
	        user.setStatus(status);
	        
	        userDao.save(user); 
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
