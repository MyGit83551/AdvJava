package com.sunbeam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.ProductDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	//dependency
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> getAllProducts() {
		// return all product
		return productDao.findAll();
	}

	@Override
	public Product addNewProduct(Product product) {
		// save product details
		Product persistentProduct = productDao.save(product);
		return persistentProduct;
	}

	@Override
	public Product getProductDetails(Long productId) {
		// return product details
		return productDao.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Product Id!!!!! "));
	}

	@Override
	public ApiResponse updateProductDetails(Long productId, Product existingProduct) 
	{
		String mesg="Product Updation Failed : invalid id!!!!!";
		//validate - check if product exist or not
		if(productDao.existsById(productId))
		{
			productDao.save(existingProduct);
			mesg="Updated Product details";
		}
		return new ApiResponse(mesg);
	}

	@Override
	public ApiResponse deleteProductDetails(Long productId) {
		if(productDao.existsById(productId))
		{
			productDao.deleteById(productId);
			return new ApiResponse("Delete product details....!!!");
		}
		return new ApiResponse("Product Deletion failed");
	}

}
