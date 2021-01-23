package com.app.samples.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.samples.springboot.entity.Product;

/**
 * The Interface ProductRepository.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
