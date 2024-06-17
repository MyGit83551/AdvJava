package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;

import static com.sunbeam.utils.HibernateUtils.getfactory;


import java.util.Scanner;

public class GetProductsByPriceAndCategory {

	public static void main(String[] args) {
		try (SessionFactory sf = getfactory();
				Scanner sc = new Scanner(System.in);)
		{
			ProductDao dao = new ProductDaoImpl();
		System.out.print("Enter price min range: ");
		double min = sc.nextDouble();
		System.out.print("Enter price max range: ");
		double max = sc.nextDouble();
		System.out.print("Enter product category: ");
		Category category = Category.valueOf(sc.next().toUpperCase());
	    
		dao.getProductsByPriceAndCategory(min, max, category).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
