package com.app.samples.springboot.repository;

import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;


import com.app.samples.springboot.util.ProductUtil;
import com.app.samples.springboot.entity.Product;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductDAO.
 */
@Repository
public class ProductDAO {

	/** The class name. */
	private final String CLASS_NAME = "ProductDAO";

	/** The logger. */
	Logger logger = Logger.getLogger(ProductDAO.class.getName());
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ProductUtil productUtil; 
	
	public Product updateProduct(Product product) {
		String METHOD_NAME = "updateProduct";
		logger.info("<<===== executing " + METHOD_NAME + " in " + CLASS_NAME +" =====>>");
		SimpleJdbcCall simpleJdbcCall = null;
		String jsonProduct = null;
		Map<String, Object> inParamMap = null;
		SqlParameterSource sqlParameterSource = null;
		Map<String, Object> simpleJdbcCallResult = null;
		try {
			inParamMap = new HashMap<String, Object>();
			simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("updateproduct");
			if(product != null) {
				jsonProduct = productUtil.convertObjectToJson(product);
				logger.info("v_product : " + jsonProduct);
				inParamMap.put("v_product", jsonProduct);//product json object
				logger.info("v_product_id : " + product.getProductId());
				inParamMap.put("v_product_id", product.getProductId()); //product id
			}
			sqlParameterSource = new MapSqlParameterSource(inParamMap);
			simpleJdbcCallResult = simpleJdbcCall.execute(sqlParameterSource);
		}
		catch(DataAccessException dataAccessException) {
			dataAccessException.printStackTrace();
		}
		return product;
	}
}
