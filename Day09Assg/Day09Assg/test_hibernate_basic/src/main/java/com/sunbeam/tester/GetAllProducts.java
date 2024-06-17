package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;

import static com.sunbeam.utils.HibernateUtils.getfactory;

public class GetAllProducts {

	public static void main(String[] args) {
		try (SessionFactory sf = getfactory()) {
			ProductDao dao = new ProductDaoImpl();
			dao.getAllProducts().forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
