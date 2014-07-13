/**
 * 
 */
package com.imos.hb.onetoone;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.imos.hb.generic.GenericObject;

/**
 * @author Pintu
 *
 */
@Embeddable
public class PersonPrimaryKey implements GenericObject {
	
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

	@Override
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
