package com.sunbeam.dao;

import java.util.List;
import com.sunbeam.entities.*;


public interface ProductDao {
String addProduct(Product product);
Product getProductById(Long Id);
List<Product> getAllProducts();
List<Product> getProductsByPriceAndCategory(double min, double max, Category category);
String applyDiscount(Category cat, double discount);
String deleteProductDetails(String productname);
String purchaseProduct(Long productId, int quantity);
}
