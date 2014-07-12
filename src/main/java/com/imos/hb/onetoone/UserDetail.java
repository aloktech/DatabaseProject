/**
 * 
 */
package com.imos.hb.onetoone;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.imos.hb.generic.GenericObject;
import com.imos.hb.manytomany.Address;
import com.imos.hb.manytomany.Company;
import com.imos.hb.manytomany.Domain;
import com.imos.hb.onetomany.Skill;
import com.imos.hb.onetomany.SkillType;

/**
 * @author Pintu
 *
 */
@SuppressWarnings("serial")
@Entity
public class UserDetail implements Serializable, GenericObject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_DETAIL_ID")
	private Long id;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_DU_ID")
	private final List<Address> addresses = new ArrayList<>();
	
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_UD_ID")
	private final List<Company> companies = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_DU_ID")
	private final  List<Project> projects = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_DU_ID")
	private final List<Domain> domains = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_DU_ID")
	private final List<SkillType> skillTypes = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_DU_ID")
	private final List<Skill> skills = new ArrayList<>();

	/**
	 * @return the addresses
	 */
	public List<Address> getAddresses() {
		return addresses;
	}

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
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the companies
	 */
	public List<Company> getCompanies() {
		return companies;
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

	/**
	 * @return the skillTypes
	 */
	public List<SkillType> getSkillTypes() {
		return skillTypes;
	}

	/**
	 * @return the skills
	 */
	public List<Skill> getSkills() {
		return skills;
	}
	
}
