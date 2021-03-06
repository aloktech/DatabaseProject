package com.imos.hb.onetoone;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.imos.hb.generic.GenericObject;
import com.imos.hb.manytomany.Company;
import com.imos.hb.manytomany.Domain;

/**
 * @author Pintu
 *
 */
@SuppressWarnings("serial")
@Entity
public class Project implements GenericObject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PROJECT_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "COMPANY_ID")
	private Company company;

	@OneToOne
	@JoinColumn(name="DOMAIN_PROJECT")
	private Domain domain;

	@OneToMany(targetEntity=PersonDetail.class, mappedBy="")
	private List<PersonDetail> users = new ArrayList<>();

	@OneToOne
	@JoinColumn(name="FK_PROJECT_DETAIL_ID")
	private ProjectDetail projectDetail;

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
	 * @return the domain
	 */
	public Domain getDomain() {
		return domain;
	}

	/**
	 * @param domain
	 *            the domain to set
	 */
	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	/**
	 * @return the users
	 */
	public List<PersonDetail> getUsers() {
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(List<PersonDetail> users) {
		this.users = users;
	}

	/**
	 * @return the projectDetail
	 */
	public ProjectDetail getProjectDetail() {
		return projectDetail;
	}

	/**
	 * @param projectDetail
	 *            the projectDetail to set
	 */
	public void setProjectDetail(ProjectDetail projectDetail) {
		this.projectDetail = projectDetail;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
