package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;

import static com.sunbeam.utils.HibernateUtils.getfactory;

import java.util.Scanner;

public class FindProduct {

	public static void main(String[] args) {
		try (SessionFactory sf = getfactory();
				Scanner sc = new Scanner(System.in))
				{
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter product id: ");
			System.out.println(dao.getProductById(sc.nextLong()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
