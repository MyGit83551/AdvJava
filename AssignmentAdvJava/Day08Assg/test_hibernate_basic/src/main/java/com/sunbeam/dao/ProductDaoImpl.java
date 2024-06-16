package com.sunbeam.dao;

import com.sunbeam.entities.Product;
import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getfactory;

import java.io.Serializable;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProduct(Product product) {
		String msg="Product registration failed....!!!";
		Session session=getfactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Serializable Id = session.save(product);
			tx.commit();
			msg="Product added successfully , with ID"+Id;
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return msg;
	}

	@Override
	public Product getProductById(Long Id) {
		Product product=null;
		Session session=getfactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			product=session.get(Product.class, Id);
			product=session.get(Product.class, Id);
			product=session.get(Product.class, Id);
			product=session.get(Product.class, Id);
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return product;
	}

}
