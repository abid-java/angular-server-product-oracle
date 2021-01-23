package com.app.samples.springboot.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

// TODO: Auto-generated Javadoc
/**
 * The Class Product.
 */
@Entity
@Table(name="products")
public class Product {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	
	/** The name. */
	@Column(name="product_name")
	private String productName;
	
	/** The description. */
	@Column(name="description")
	private String description;
	
	/** The price. */
	@Column(name = "price")
	private BigDecimal price;
	
	/** The created at. */
	@CreationTimestamp
	private Date createdAt;
	
	/** The product locations. */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pc_fid", referencedColumnName = "productId")
	List<ProductLocation> productLocations = new ArrayList<>();
	
	/**
	 * Instantiates a new product.
	 */
	public Product() {
		super();
	}
	
	/**
	 * Post.
	 *
	 * @param id the id
	 * @param name the name
	 * @param description the description
	 * @param price the price
	 * @param createdAt the created at
	 * @param productLocations the product locations
	 */
	public Product(long productId, String productName, String description, BigDecimal price, Date createdAt, List<ProductLocation> productLocations) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.createdAt = createdAt;
		this.productLocations = productLocations;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * Gets the created at.
	 *
	 * @return the created at
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * Sets the created at.
	 *
	 * @param createdAt the new created at
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Gets the product locations.
	 *
	 * @return the product locations
	 */
	public List<ProductLocation> getProductLocations() {
		return productLocations;
	}

	/**
	 * Sets the product locations.
	 *
	 * @param productLocations the new product locations
	 */
	public void setProductLocations(List<ProductLocation> productLocations) {
		this.productLocations = productLocations;
	}
	
}
