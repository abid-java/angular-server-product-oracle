package com.app.samples.springboot.controller;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductController {

	/** The class name. */
	private final String CLASS_NAME = "ProductController";
	
	/** The logger. */
	Logger logger = Logger.getLogger(ProductController.class.getName());

}
