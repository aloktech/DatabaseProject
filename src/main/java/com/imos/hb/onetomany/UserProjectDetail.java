package com.imos.hb.onetomany;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import com.imos.hb.onetoone.Project;

public class UserProjectDetail {
	
	@Id
	private long id;
	
	@Column
	private String companyName;
	
	@Column
	private List<Project> projects = new ArrayList<>();
	
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
