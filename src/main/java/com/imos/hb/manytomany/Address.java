/**
 * 
 */
package com.imos.hb.manytomany;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.imos.hb.generic.GenericObject;
import com.imos.hb.onetoone.UserDetail;

/**
 * @author Pintu
 *
 */
@SuppressWarnings("serial")
@Entity
@NamedQueries({
	@NamedQuery(name="Address.findAll", query="select a from Address a")
})
public class Address implements Serializable, GenericObject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ADDR_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="FK_ADDR_ID")
	private UserDetail userDetail;
	
	@Column(name="ADDRESS_TYPE")
	private String addressType;
	
	@Column(name="FIRST_STREET")
	private String firstStreet;
	
	@Column(name="SECOND_STREET")
	private String secondStreet;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="PIN_CODE")
	private int pinCode;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the userDetail
	 *//*
	public List<UserDetail> getUserDetail() {
		return userDetail;
	}*/

	/**
	 * @return the firstStreet
	 */
	public String getFirstStreet() {
		return firstStreet;
	}

	/**
	 * @param firstStreet the firstStreet to set
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
	 * @param secondStreet the secondStreet to set
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
	 * @param city the city to set
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
	 * @param country the country to set
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
	 * @param state the state to set
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
	 * @param pinCode the pinCode to set
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
	 * @param addressType the addressType to set
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	/**
	 * @return the userDetail
	 */
	public UserDetail getUserDetail() {
		return userDetail;
	}

	/**
	 * @param userDetail the userDetail to set
	 */
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	
	
}
