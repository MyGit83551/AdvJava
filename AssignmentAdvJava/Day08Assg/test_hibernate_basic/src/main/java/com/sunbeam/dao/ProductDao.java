package com.sunbeam.dao;

import com.sunbeam.entities.*;

public interface ProductDao {
String addProduct(Product product);
Product getProductById(Long Id);
}
