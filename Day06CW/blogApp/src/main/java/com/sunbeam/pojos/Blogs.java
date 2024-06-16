package com.sunbeam.pojos;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Blogs 
{
	private int id;
	private String title;
	private String contents;
	private Timestamp blog_created_date_time;
	private int user_id;
	private int category_id;
	public Blogs() {
		super();
	}
	public Blogs(String title, String contents, Timestamp currentDateTimeBlog) {
		super();
		this.title = title;
		this.contents = contents;
		this.blog_created_date_time = currentDateTimeBlog;
	}
	

	public Blogs(String title2, String description) {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Timestamp getCurrentDateTimeBlog() {
		return blog_created_date_time;
	}
	public void setCurrentDateTimeBlog(Timestamp currentDateTimeBlog) {
		this.blog_created_date_time = currentDateTimeBlog;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	@Override
	public String toString() {
		return "Blogs [id=" + id + ", title=" + title + ", contents=" + contents + ", currentDateTimeBlog="
				+ blog_created_date_time + ", user_id=" + user_id + ", category_id=" + category_id + "]";
	}
	
	
}