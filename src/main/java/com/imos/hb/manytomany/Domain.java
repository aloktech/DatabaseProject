/**
 * 
 */
package com.imos.hb.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.imos.hb.onetomany.SkillType;

/**
 * @author Pintu
 *
 */
@SuppressWarnings("serial")
@Entity
public class Domain implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="DOMAIN_ID")
	private Long id;

	@ManyToMany
	@JoinTable(name="COMPANY_DOMAIN", joinColumns={@JoinColumn(name="DOMAIN_ID",insertable = false, updatable = false)},
	inverseJoinColumns={@JoinColumn(name="COMPANY_ID",insertable = false, updatable = false)})
	private final List<Company> companies = new ArrayList<>();

	@ManyToMany
	@JoinTable(name="DOMAIN_SKILLTYPE", joinColumns={@JoinColumn(name="DOMAIN_ID",insertable = false, updatable = false)},
	inverseJoinColumns={@JoinColumn(name="SKILLTYPE_ID",insertable = false, updatable = false)})
	private final List<SkillType> skillTypes = new ArrayList<>();

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
	 * @return the companies
	 */
	public List<Company> getCompanies() {
		return companies;
	}

	/**
	 * @return the skillTypes
	 */
	public List<SkillType> getSkillTypes() {
		return skillTypes;
	}

}
