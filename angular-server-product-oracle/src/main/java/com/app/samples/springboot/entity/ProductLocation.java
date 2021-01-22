package com.app.samples.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductLocation.
 */
@Entity
@Table(name="product_locations")
public class ProductLocation {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/** The address line 1. */
	@Column(name = "addressLine_1")
	private String addressLine1;
	
	/** The address line 2. */
	@Column(name = "addressLine_2")
	private String addressLine2;
	
	/** The city. */
	@Column(name="city")
	private String city;
	
	/** The state. */
	@Column(name="state")
	private String state;
	
	/** The country. */
	@Column(name="country")
	private String country;
	
	/** The zip code. */
	@Column(name="zip_code")
	private long zipCode;
	
	/**
	 * Instantiates a new product location.
	 */
	public ProductLocation() {
		super();
	}
	
	/**
	 * Instantiates a new product location.
	 *
	 * @param id the id
	 * @param addressLine1 the address line 1
	 * @param addressLine2 the address line 2
	 * @param city the city
	 * @param state the state
	 * @param country the country
	 * @param zipCode the zip code
	 */
	public ProductLocation(long id, String addressLine1, String addressLine2, String city, String state, String country, long zipCode) {
		super();
		this.id = id;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the address line 1.
	 *
	 * @return the address line 1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * Sets the address line 1.
	 *
	 * @param addressLine1 the new address line 1
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * Gets the address line 2.
	 *
	 * @return the address line 2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * Sets the address line 2.
	 *
	 * @param addressLine2 the new address line 2
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the zip code.
	 *
	 * @return the zip code
	 */
	public long getZipCode() {
		return zipCode;
	}

	/**
	 * Sets the zip code.
	 *
	 * @param zipCode the new zip code
	 */
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
	
}
