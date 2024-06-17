package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;

import static com.sunbeam.utils.HibernateUtils.getfactory;

public class ApplyDiscount {

	public static void main(String[] args) {
		try (SessionFactory sf = getfactory(); 
				Scanner sc = new Scanner(System.in)){
			ProductDao dao = new ProductDaoImpl();
			System.out.print("Enter discount amount:  ");
			double discount = sc.nextDouble();
			System.out.print("Enter product category: ");
			Category category = Category.valueOf(sc.next().toUpperCase());
			System.out.println(dao.applyDiscount(category, discount));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
