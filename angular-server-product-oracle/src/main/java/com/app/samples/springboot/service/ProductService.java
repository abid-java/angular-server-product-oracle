package com.app.samples.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.samples.springboot.entity.Product;
import com.app.samples.springboot.entity.ProductLocation;
import com.app.samples.springboot.repository.ProductDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductService.
 */
@Service
public class ProductService {
	
	/** The product dao. */
	@Autowired
	private ProductDAO productDao;
	
	/**
	 * Update product.
	 *
	 * @param product the product
	 * @return the product
	 */
	public Product updateProductDetails(Product product, long productId) {
		List<ProductLocation> productLocations = null;
		long productLocationProductId = 0L;
		if(product != null) {
			//update product details first
			productDao.updateProduct(product, productId);
			//iterate through product locations and update each product location to a given productId
			productLocations = product.getProductLocations();
			for(ProductLocation productLocation : productLocations) {
				productLocationProductId = productLocation.getProductId();
				productDao.updateProductLocation(productLocation, productId,productLocationProductId);
			}
		}
		return product;
	}	
}
