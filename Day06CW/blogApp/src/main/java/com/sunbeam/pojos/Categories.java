package com.sunbeam.pojos;

import java.sql.Timestamp;
import java.util.Scanner;

public class Categories 
{
	private int category_id;
	private String title;
	private String description;
	public Categories() {
		super();
	}
	public Categories(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getId() {
		return category_id;
	}
	public void setId(int id) {
		this.category_id = id;
	}
	public void acceptCategories()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Category title : ");
		sc.next();
		title = sc.next();
		System.out.print("Enter Category Description : ");
		description = sc.next();
	}
}
