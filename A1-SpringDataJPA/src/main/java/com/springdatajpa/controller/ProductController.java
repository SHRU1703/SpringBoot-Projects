package com.springdatajpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdatajpa.entities.Product;
import com.springdatajpa.services.ProductService;

@Controller
@RequestMapping("/products")

public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	// Endpoint to create a new product
//create
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		System.out.println("Received product: " + product); // Log received product
		Product savedProduct = productService.addProduct(product);
		System.out.println("Saved product: " + savedProduct); // Log saved product
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}

	// Endpoint to get all products
	//retrieve
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> getAllProducts = productService.getAllProducts();

		return new ResponseEntity<>(getAllProducts, HttpStatus.OK);
	}

	//retrieve by id
	// Endpoint to get product by ID
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
	    Optional<Product> optionalProduct = productService.getProductById(id);
	    if (optionalProduct.isPresent()) {
	        Product product = optionalProduct.get();
	        return new ResponseEntity<>(product, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}


	//update
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		// Ensure the product id in the path matches the id in the request body
		if (!id.equals(product.getId())) {
			throw new IllegalArgumentException("Product ID in path must match the ID in the request body");
		}
		return productService.updateProduct(product);
	}

	

	// Endpoint to delete a product by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
