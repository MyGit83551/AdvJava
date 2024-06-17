package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getfactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;

public class PurchaseProduct {

    public static void main(String[] args) {
        try (SessionFactory sf = getfactory(); 
             Scanner sc = new Scanner(System.in)) {
             
            ProductDao dao = new ProductDaoImpl();
            
            System.out.println("Enter product id for purchase:");
            long productId = sc.nextLong();
            
            System.out.println("Enter quantity to purchase:");
            int quantity = sc.nextInt();
            
            String result = dao.purchaseProduct(productId, quantity);
            System.out.println(result);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

