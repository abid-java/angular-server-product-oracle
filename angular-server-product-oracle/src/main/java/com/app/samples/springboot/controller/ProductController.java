package com.app.samples.springboot.controller;

import java.util.logging.Logger;
import java.util.List;

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
import com.app.samples.springboot.service.ProductService;
import com.app.samples.springboot.repository.ProductDAO;
import com.app.samples.springboot.util.ProductUtil;
import com.app.samples.springboot.entity.Product;
import com.app.samples.springboot.exception.ResourceNotFoundException;



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
	
	@Autowired
	private ProductService productService;
	
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
	
	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts() {
		String METHOD_NAME = "getAllProducts";
		List<Product> products = null;
		logger.info("<<===== executing " + METHOD_NAME + " in " + CLASS_NAME +" =====>>");
		ResponseEntity<List<Product>> responseEntity = null;
		products = productRepository.findAll();
			if(products.size() > 0) {
				responseEntity = ResponseEntity.ok().body(products);
			} else {
				throw new ResourceNotFoundException("No Records Found : ");
			}
		return responseEntity;
	}
	
	/**
	 * Gets the product by id.
	 *
	 * @param productId the product id
	 * @return the product by id
	 */
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") long productId) {
		String METHOD_NAME = "getProductById";
		logger.info("<<===== executing " + METHOD_NAME + " in " + CLASS_NAME +" =====>>");
		ResponseEntity<Product> responseEntity = null;
		Product existingProduct = productUtil.existingProduct(productId);
		if(existingProduct != null) {
			responseEntity = ResponseEntity.ok().body(existingProduct);
		} else {
			throw new ResourceNotFoundException("Product Not Found with Id : " + productId);
		}
		return responseEntity;
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("productId") long productId) {
		ResponseEntity<Product> responseEntity = null;
		Product updatedProduct = null;
		String METHOD_NAME = "updateProduct";
		logger.info("<<===== executing " + METHOD_NAME + " in " + CLASS_NAME +" =====>>");
		updatedProduct = productService.updateProductDetails(product, productId);
		if(updatedProduct != null) {
			responseEntity = ResponseEntity.ok().body(updatedProduct);
		} else {
			throw new ResourceNotFoundException("Product Not Found with Id : " + productId);
		}
		return responseEntity;		
	}

}
