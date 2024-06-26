package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;

public interface ProductService {

	List<Product> getAllProducts();
	Product addNewProduct(Product product);
	Product getProductDetails(Long productId);
	ApiResponse updateProductDetails(Long productId,Product existingProduct);
	ApiResponse deleteProductDetails(Long productId);
}
