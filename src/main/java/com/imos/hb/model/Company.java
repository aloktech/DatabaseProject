/**
 * 
 */
package com.imos.hb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Pintu
 *
 */
@SuppressWarnings("serial")
@Entity
public class Company implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany(targetEntity=Project.class, mappedBy="company", cascade=CascadeType.ALL)
	private final List<Project> projects = new ArrayList<>();
	
	@OneToMany(targetEntity=Domain.class, mappedBy="company", cascade=CascadeType.ALL)
	private final List<Domain> domains = new ArrayList<>();
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the projects
	 */
	public List<Project> getProjects() {
		return projects;
	}
	/**
	 * @return the domains
	 */
	public List<Domain> getDomains() {
		return domains;
	}
	
}
