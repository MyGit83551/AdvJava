package com.sunbeam.beans;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class RegistrationBean {
	private String full_name;
	private String email;
	private String passwd;
	private String phone_no;
	private int count;
	
	
	
	public RegistrationBean() {
		
	}



	public RegistrationBean(String full_name, String email, String passwd, String phone_no, int count) {
		super();
		this.full_name = full_name;
		this.email = email;
		this.passwd = passwd;
		this.phone_no = phone_no;
		this.count = count;
	}

	

	public String getFull_name() {
		return full_name;
	}



	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPasswd() {
		return passwd;
	}



	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}



	public String getPhone_no() {
		return phone_no;
	}



	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public void registerUser()
	{
		User u = new User(0, full_name, email, passwd, phone_no);
		try(UserDao userDao = new UserDaoImpl()) {
			count = userDao.save(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
