/**
 * 
 */
package com.imos.hb.onetoone;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

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
public class PersonDetail implements GenericObject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PD_ID")
	private Long id;

	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;
	
	@OneToOne(targetEntity=Person.class, mappedBy="personDetail")
	private Person person;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="PERSON_ADDRESS", joinColumns={@JoinColumn(name="PD_ID",insertable = false, updatable = false)},
	inverseJoinColumns={@JoinColumn(name="ADDRESS_ID",insertable = false, updatable = false)})
	private final List<Address> addresses = new ArrayList<>();

	@ManyToMany
	@JoinTable(name="PERSON_COMPANY", joinColumns={@JoinColumn(name="PD_ID",insertable = false, updatable = false)},
	inverseJoinColumns={@JoinColumn(name="COMPANY_ID",insertable = false, updatable = false)})
	private final List<Company> companies = new ArrayList<>();

	@ManyToMany
	@JoinTable(name="PERSON_PROJECT", joinColumns={@JoinColumn(name="PD_ID",insertable = false, updatable = false)},
	inverseJoinColumns={@JoinColumn(name="PROJECT_ID",insertable = false, updatable = false)})
	private final List<Project> projects = new ArrayList<>();

	@ManyToMany
	@JoinTable(name="PERSON_DOMAIN", joinColumns={@JoinColumn(name="PD_ID",insertable = false, updatable = false)},
	inverseJoinColumns={@JoinColumn(name="DOMAIN_ID",insertable = false, updatable = false)})
	private final List<Domain> domains = new ArrayList<>();

	@ManyToMany
	@JoinTable(name="PERSON_SKILLTYPE", joinColumns={@JoinColumn(name="PD_ID",insertable = false, updatable = false)},
	inverseJoinColumns={@JoinColumn(name="SKILLTYPE_ID",insertable = false, updatable = false)})
	private final List<SkillType> skillTypes = new ArrayList<>();

	@ManyToMany
	@JoinTable(name="PERSON_SKILL", joinColumns={@JoinColumn(name="PD_ID",insertable = false, updatable = false)},
	inverseJoinColumns={@JoinColumn(name="SKILL_ID",insertable = false, updatable = false)})
	private final List<Skill> skills = new ArrayList<>();
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PersonDetail) {
			if (obj == this) {
				return true;
			}
			PersonDetail pd = (PersonDetail) obj;
			
			return pd.getDateOfBirth().equals(getDateOfBirth());
		}
		return super.equals(obj);
	}

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
	 * @param id
	 *            the id to set
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
	 * @param dateOfBirth
	 *            the dateOfBirth to set
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

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

}
