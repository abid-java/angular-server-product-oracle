package com.app.samples.springboot.util;

import java.util.logging.Logger;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;

import com.app.samples.springboot.repository.ProductRepository;
import com.app.samples.springboot.entity.Product;

@Service
public class ProductUtil {

	@Autowired
	private ProductRepository productRepository; 
	
	/** The class name. */
	private final String CLASS_NAME = "ProductUtil";
	
	/** The logger. */
	Logger logger = Logger.getLogger(ProductUtil.class.getName());
	
	public Product existingProduct(Long productId) {
		String METHOD_NAME = "existingProduct";
		logger.info("<<===== executing " + METHOD_NAME + " in " + CLASS_NAME +" =====>>");
		Product existingProduct = null;
		List<Product> productsList = productRepository.findAll();
		for(Product product : productsList) {
			if(product != null) {
				if(productId.equals(product.getProductId())) {
					existingProduct = product;
				} 
			}
		}
		return existingProduct;
	}
	
	public String convertObjectToJson(Object javaObject) {
		String METHOD_NAME = "convertObjectToJson";
		logger.info("<<===== executing " + METHOD_NAME + " in " + CLASS_NAME +" =====>>");
		String jsonObject = "";
		if(javaObject != null) {
			jsonObject = new Gson().toJson(javaObject);
		}
		return jsonObject;
	}
}
