/**
 * 
 */
package com.imos.hb.onetomany;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.imos.hb.onetoone.Project;

/**
 * @author Pintu
 *
 */
@Entity
public class UserCompanyDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 978005478436650731L;

	@Id
	private long id;
	
	@Column
	private String companyName;
	
	@OneToMany
	@JoinColumn(name="FK_UCD_ID")
	private List<Project> projects = new ArrayList<>();
	
	@Column
	private Date dateOfJoin;
	
	@Column
	private Date dateOfRelease;

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
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the projects
	 */
	public List<Project> getProjects() {
		return projects;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(List<Project> projects) {
		this.projects = projects;
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
	 * @return the dateOfRelease
	 */
	public Date getDateOfRelease() {
		return dateOfRelease;
	}

	/**
	 * @param dateOfRelease the dateOfRelease to set
	 */
	public void setDateOfRelease(Date dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}

	
}
