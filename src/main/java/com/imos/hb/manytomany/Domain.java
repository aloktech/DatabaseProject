/**
 * 
 */
package com.imos.hb.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.imos.hb.onetomany.SkillType;

/**
 * @author Pintu
 *
 */
@SuppressWarnings("serial")
@Entity
public class Domain implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(targetEntity=Company.class, mappedBy="domains")
	private final List<Company> companies = new ArrayList<>();
	
	@OneToMany(targetEntity=SkillType.class, mappedBy="domain")
	private final List<SkillType> skillTypes = new ArrayList<>();
	
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
