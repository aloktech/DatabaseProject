/**
 * 
 */
package com.imos.hb.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.imos.hb.generic.GenericObject;
import com.imos.hb.onetoone.PersonDetail;

/**
 * @author Pintu
 *
 */
@SuppressWarnings("serial")
@Entity
@NamedQueries({ @NamedQuery(name = "Address.findAll", query = "select a from Address a") })
public class Address implements Serializable, GenericObject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADDRESS_ID")
	private Long id;

	@ManyToMany
	@JoinTable(name="PERSON_ADDRESS", joinColumns={@JoinColumn(name="ADDRESS_ID",insertable = false, updatable = false)},
	inverseJoinColumns={@JoinColumn(name="PD_ID",insertable = false, updatable = false)})
	private final List<PersonDetail> userDetails = new ArrayList<>();

	@Column(name = "ADDRESS_TYPE")
	private String addressType;

	@Column(name = "FIRST_STREET")
	private String firstStreet;

	@Column(name = "SECOND_STREET")
	private String secondStreet;
	
	@Column(name = "LOCATION")
	private String location;

	@Column(name = "CITY")
	private String city;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "STATE")
	private String state;

	@Column(name = "PIN_CODE")
	private int pinCode;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstStreet
	 */
	public String getFirstStreet() {
		return firstStreet;
	}

	/**
	 * @param firstStreet
	 *            the firstStreet to set
	 */
	public void setFirstStreet(String firstStreet) {
		this.firstStreet = firstStreet;
	}

	/**
	 * @return the secondStreet
	 */
	public String getSecondStreet() {
		return secondStreet;
	}

	/**
	 * @param secondStreet
	 *            the secondStreet to set
	 */
	public void setSecondStreet(String secondStreet) {
		this.secondStreet = secondStreet;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the pinCode
	 */
	public int getPinCode() {
		return pinCode;
	}

	/**
	 * @param pinCode
	 *            the pinCode to set
	 */
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	/**
	 * @return the addressType
	 */
	public String getAddressType() {
		return addressType;
	}

	/**
	 * @param addressType
	 *            the addressType to set
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	/**
	 * @return the userDetails
	 */
	public List<PersonDetail> getUserDetails() {
		return userDetails;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}


}
