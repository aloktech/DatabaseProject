package com.imos.hb.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import com.imos.hb.generic.GenericObject;

@Entity
@NamedQueries({
	@NamedQuery(name="User.findAll", query="select u from User u")
})
public class User implements Serializable, GenericObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -693808501172324257L;
	
	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;
	
	@Column(name="MIDDLE_NAME")
	private String middleName;
	
	@Column(name="LAST_NAME", nullable=false)
	private String lastName;
	
	@Id
	@Column(name="EMPLOYEE_ID", nullable=false)
	private String employeeId;
	
	@Column(name="GENDER", nullable=false)
	private String gender;
	
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="FK_UD_ID")
	private UserDetail userDetail;
	
	private Company company;
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			User u = (User) obj;
			if (u == this) {
				return true;
			}
			
			if (u.getFirstName().equals(this.getFirstName())) {
				if (u.getMiddleName().equals(this.getMiddleName())) {
					if (u.getLastName().equals(this.getLastName())) {
						if (u.getGender().equals(this.getGender())) {
							return true;
						}
					}
				}
			}
			
			return false;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		int value = 15 * this.getFirstName().hashCode() + 
		15 * this.getMiddleName().hashCode() + 
		15 * this.getLastName().hashCode() + 
		15 * this.getGender().hashCode();
		return value;
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

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public Object getId() {
		return employeeId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
