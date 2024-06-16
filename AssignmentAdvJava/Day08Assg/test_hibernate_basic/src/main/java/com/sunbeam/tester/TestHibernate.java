package com.sunbeam.tester;

import org.hibernate.SessionFactory;
import static com.sunbeam.utils.HibernateUtils.getfactory;

public class TestHibernate {
	
	public static void main(String[] args) {
		try (SessionFactory sf = getfactory()){
			System.out.println("Hibernate up and running..........");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
