package com.app.samples.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.samples.springboot.entity.Product;
import com.app.samples.springboot.entity.ProductLocation;
import com.app.samples.springboot.repository.ProductDAO;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDao;
	
	public Product updateProduct(Product product) {
		List<ProductLocation> productLocations = null;
		long productId = 0L;
		if(product != null) {
			productId = product.getProductId();
			//store product details first
			productDao.updateProduct(product, productId);
			//iterate through product locations and store each product location to a given productId
			productLocations = product.getProductLocations();
			for(ProductLocation productLocation : productLocations) {
				productDao.updateProductLocation(productLocation, productId);
			}
		}
		return product;
	}	
}
