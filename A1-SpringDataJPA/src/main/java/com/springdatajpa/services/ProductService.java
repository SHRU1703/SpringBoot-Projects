package com.springdatajpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.entities.Product;
import com.springdatajpa.repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// create
	public Product addProduct(Product product) {
		System.out.println("Received product in service: " + product);
		Product savedProduct = productRepository.save(product);
		System.out.println("Saved product in service: " + savedProduct);
		return savedProduct;
	}

	// retrieve
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	// retrieve by id
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	// update
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	// delete by idd
	public void deleteProduct(Long id) {

		productRepository.deleteById(id);
	}

}
