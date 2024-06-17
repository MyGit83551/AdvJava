package com.sunbeam.dao;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;
import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getfactory;

import java.io.Serializable;
import java.util.List;

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

	@Override
	public List<Product> getAllProducts() {
		String jpql = "select p from Product p";
		List<Product> prod = null;
		Session session = getfactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			prod = session.createQuery(jpql, Product.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return prod;
	}

	@Override
	public List<Product> getProductsByPriceAndCategory(double min, double max, Category prodCat) {
		String jpql = "select p from Product p where p.price between :minimum and :maximum and p.category=:cat";
		List<Product> prod = null;
		Session session = getfactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			prod = session.createQuery(jpql, Product.class)
					.setParameter("minimum", min)
					.setParameter("maximum", max)
					.setParameter("cat", prodCat)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx !=  null)
				tx.rollback();
			throw e;
		}
		return prod;
	}

	@Override
	public String applyDiscount(Category cat, double discount) {
		String msg = "Applying discount failed !!!!";
		String jpql = "update Product p set p.price=p.price-:disc where p.category=:ct";
		Session session = getfactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			int rows = session.createQuery(jpql)
					.setParameter("disc", discount)
					.setParameter("ct", cat)
					.executeUpdate();
			tx.commit();
			msg = "Applied discount to products - " + rows;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String deleteProductDetails(String productname) {
	    String msg = "Deletion failed";
	    String jpql = "select p from Product p where p.productname=:nm";
	    Session session = getfactory().getCurrentSession();
	    Transaction tx = null;
	    
	    try {
	        tx = session.beginTransaction();
	        
	        Product prod = (Product) session.createQuery(jpql)
	                                        .setParameter("nm", productname)
	                                        .uniqueResult();
	        
	        if (prod != null) {
	            session.delete(prod);
	            msg = "Product details deleted successfully.";
	        }
	        
	        tx.commit();
	    } catch (RuntimeException e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        throw e;
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	    
	    return msg;
	}

	public String purchaseProduct(Long productId, int quantity) {
	    String msg = "Purchase failed";
	    Session session = getfactory().getCurrentSession();
	    Transaction tx = null;
	    
	    try {
	        tx = session.beginTransaction();
	        Product product = session.get(Product.class, productId);
	        if (product != null && product.getAvailablequantity() >= quantity) 
	        {
	            product.setAvailablequantity(product.getAvailablequantity() - quantity);
	            msg = "Purchase Product successfully........";
	        } else {
	            msg = "Insufficient Product stock available!!!!!!!!";
	        }
	        
	        tx.commit();
	    } catch (RuntimeException e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        throw e;
	    } 
	    return msg;
	}

	

}
