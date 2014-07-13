/**
 * 
 */
package com.imos.hb.onetoone;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author Pintu
 *
 */
@Embeddable
public class PersonPrimaryKey implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -530429399355449561L;

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PERSON_ID")
	private long id;
	
	@Column(name="EMPLOYEE_ID")
	private String employeeId;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
	
	
}
