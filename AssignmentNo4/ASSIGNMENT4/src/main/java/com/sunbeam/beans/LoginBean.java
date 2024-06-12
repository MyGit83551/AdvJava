package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginBean {
	private String email;
	private String password;
	private User user;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public LoginBean() {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void authenticate() {
		try (UserDao userDao = new UserDaoImpl()){
			User user= userDao.findByEmail(email);
			
			if (user != null && user.getPassword().equals(password)) {
                
                setUser(user);
                System.out.println("Login successful!");
            } else {
                
                System.out.println("Login failed. Please check your credentials.");
            }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}
	

}
