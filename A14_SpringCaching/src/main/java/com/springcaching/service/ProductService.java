package com.springcaching.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.springcaching.entities.Product;
import com.springcaching.repository.ProductRepository;

/*import com.springdatajpa.entities.Product;
import com.springdatajpa.repository.ProductRepository;*/

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
	@Cacheable(cacheNames="product",key="#id")
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	// update
	@CachePut(cacheNames="product",key="#book.id")
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	

	// delete by idd
	@CacheEvict(cacheNames="product",key="#id")
	public void deleteProduct(Long id) {

		productRepository.deleteById(id);
	}

}
