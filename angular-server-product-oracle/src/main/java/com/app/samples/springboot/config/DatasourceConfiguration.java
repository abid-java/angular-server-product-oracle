package com.app.samples.springboot.config;

import java.util.logging.Logger;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

// TODO: Auto-generated Javadoc
/**
 * The Class DatasourceConfiguration.
 */
@Configuration
@PropertySources({@PropertySource("classpath:application.properties")})
public class DatasourceConfiguration {
	
	/** The class name. */
	private final String CLASS_NAME = "DatasourceConfiguration";

	/** The jdbc template. */
	JdbcTemplate jdbcTemplate = null;
	
	/** The logger. */
	Logger logger = Logger.getLogger(DatasourceConfiguration.class.getName());
	
	/** The driver class name. */
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	
	/** The db url. */
	@Value("${spring.datasource.url}")
	private String dbUrl;
	
	/** The db user name. */
	@Value("${spring.datasource.username}")
	private String dbUserName;
	
	/** The db password. */
	@Value("${spring.datasource.password}")
	private String dbPassword;
	
	/**
	 * Creates the data source.
	 *
	 * @return the data source
	 */
	@Bean 
	public DataSource createDataSource() {
		logger.info("connecting to database : "+CLASS_NAME);
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUserName);
		dataSource.setPassword(dbPassword);
		return dataSource;
	}
	
	/**
	 * Jdbc template.
	 *
	 * @param dataSource the data source
	 * @return the jdbc template
	 */
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		logger.info(" creating jdbcTemplate : "+CLASS_NAME);		
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;
	}
}
