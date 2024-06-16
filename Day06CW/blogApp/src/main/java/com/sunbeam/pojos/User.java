package com.sunbeam.pojos;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class User 
{
	private int user_id;
	private String full_name;
	private String email;
	private String password;
	private String phone_no;
	private Timestamp user_created_date_time;
	
	public User() {
		super();
	}

	public User(int user_id, String full_name, String email, String password, String phone_no,
			Timestamp user_created_date_time) {
		super();
		this.user_id = user_id;
		this.full_name = full_name;
		this.email = email;
		this.password = password;
		this.phone_no = phone_no;
		this.user_created_date_time = user_created_date_time;
	}
	
	

	public User(int user_id, String full_name, String email, String password, String phone_no) {
		super();
		this.user_id = user_id;
		this.full_name = full_name;
		this.email = email;
		this.password = password;
		this.phone_no = phone_no;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public Timestamp getUser_created_date_time() {
		return user_created_date_time;
	}

	public void setUser_created_date_time(Timestamp user_created_date_time) {
		this.user_created_date_time = user_created_date_time;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", full_name=" + full_name + ", email=" + email + ", password=" + password
				+ ", phone_no=" + phone_no + ", user_created_date_time=" + user_created_date_time + "]";
	}
	
	
	
}
