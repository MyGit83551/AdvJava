package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;
import static com.sunbeam.utils.HibernateUtils.getfactory;

public class AddProduct {

	public static void main(String[] args) {
		try (SessionFactory sf = getfactory();
				Scanner sc=new Scanner(System.in)
				) {
			//create dao instance
			ProductDao prodao=new ProductDaoImpl();
			System.out.println("Enter Product details - Product_Category, Product_name, Price, Available_quantity \r\n");
			Product newProduct=new Product(Category.valueOf(sc.next().toUpperCase()), sc.next(), sc.nextDouble(), sc.nextInt());
		
			System.out.println(prodao.addProduct(newProduct));
		} //JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
