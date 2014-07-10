/**
 * 
 */
package com.imos.hb.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Pintu
 *
 */
@Entity
public class ProjectDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1735804770457978305L;

	@Id
	private long id;
	
	@Column
	private String projectName;
	
	@Column
	private Date dateOfJoin;
	
	@Column
	private Date dateOfReleave;

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
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the dateOfJoin
	 */
	public Date getDateOfJoin() {
		return dateOfJoin;
	}

	/**
	 * @param dateOfJoin the dateOfJoin to set
	 */
	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	/**
	 * @return the dateOfReleave
	 */
	public Date getDateOfReleave() {
		return dateOfReleave;
	}

	/**
	 * @param dateOfReleave the dateOfReleave to set
	 */
	public void setDateOfReleave(Date dateOfReleave) {
		this.dateOfReleave = dateOfReleave;
	}
	
	
}
