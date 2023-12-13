package com.springcaching.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springcaching.entities.Product;

/*import com.springdatajpa.entities.Product;
*/
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.name = :productName")
    List<Product> findByProductName(@Param("productName") String productName);
    
    
    @Query("SELECT p FROM Product p WHERE p.id = :productId")
    Optional<Product> findByProductId(@Param("productId") Long productId);
}
