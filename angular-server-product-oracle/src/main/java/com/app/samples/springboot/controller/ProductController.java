package com.app.samples.springboot.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.samples.springboot.repository.ProductRepository;
import com.app.samples.springboot.repository.ProductDAO;
import com.app.samples.springboot.util.ProductUtil;
import com.app.samples.springboot.entity.Product;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductController.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductController {

	/** The class name. */
	private final String CLASS_NAME = "ProductController";
	
	/** The logger. */
	Logger logger = Logger.getLogger(ProductController.class.getName());
	
	/** The product repository. */
	@Autowired
	private ProductRepository productRepository;
	
	/** The product util. */
	@Autowired
	private ProductUtil productUtil;
	
	/** The product dao. */
	@Autowired
	private ProductDAO productDao;
	
	/**
	 * Creates the product.
	 *
	 * @param product the product
	 * @return the response entity
	 */
	@PostMapping("/createProduct")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		ResponseEntity<Product> responseEntity = null;
		String METHOD_NAME = "createProduct";
		logger.info("<<===== executing " + METHOD_NAME + " in " + CLASS_NAME +" =====>>");
		Product savedproduct = null;
		if(product != null) {
			logger.info("creating product : " + product.toString());
			savedproduct = productRepository.save(product);			
			if(savedproduct != null) {
				responseEntity = ResponseEntity.ok().body(product);
			} else {
				throw new DataAccessResourceFailureException("Error Connecting Database");
			}
		}
		return responseEntity;
	}

}
