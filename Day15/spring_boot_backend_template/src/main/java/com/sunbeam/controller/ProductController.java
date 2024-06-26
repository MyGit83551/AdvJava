package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;
import com.sunbeam.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/products")
public class ProductController {

	//dependency
	@Autowired
	private ProductService productService;
	
	public ProductController() {
		System.out.println("In constructor"+ getClass());
	}
	
	@GetMapping
	public List<Product> listAllProducts()
	{
		System.out.println("In List");
		return productService.getAllProducts();
	}
	
	@PostMapping
	@Operation(description = "Create new Product")
	public ResponseEntity<?> addProduct(@RequestBody Product newProduct)
	{
		System.out.println("In add products" + newProduct);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(productService.addNewProduct(newProduct));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
			
		}
	}
	
	@GetMapping("/{proId}")
	public ResponseEntity<?> getProductDetails(@PathVariable Long proId)
	{
		System.out.println("In get product " + proId);
		try {
			return ResponseEntity.ok(productService.getProductDetails(proId));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()) );
		}
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<?> updateProduct(@PathVariable Long productId, @RequestBody Product product)
	{
		System.out.println("In update " + productId + " " + product);
		return ResponseEntity.ok(productService.updateProductDetails(productId, product));
	}
	
	@DeleteMapping("/{proId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long proId)
	{
		System.out.println("In delete "+proId);
		return ResponseEntity.ok(productService.deleteProductDetails(proId));
	}
}
