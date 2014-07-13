/**
 * 
 */
package com.imos.hb.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.imos.hb.onetoone.Project;

/**
 * @author Pintu
 *
 */
@SuppressWarnings("serial")
@Entity
public class Company implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="COMPANY_ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;

	@OneToMany(targetEntity = Project.class, mappedBy = "company", cascade = CascadeType.ALL)
	private final List<Project> projects = new ArrayList<>();

	@ManyToMany
	@JoinTable(name="COMPANY_DOMAIN", joinColumns={@JoinColumn(name="COMPANY_ID",insertable = false, updatable = false)},
	inverseJoinColumns={@JoinColumn(name="DOMAIN_ID",insertable = false, updatable = false)})
	private final List<Domain> domains = new ArrayList<>();

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
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
