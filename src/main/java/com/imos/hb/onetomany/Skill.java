package com.imos.hb.onetomany;

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
import javax.persistence.ManyToOne;

import com.imos.hb.generic.GenericObject;
import com.imos.hb.onetoone.PersonDetail;

/**
 * @author Pintu
 *
 */
@SuppressWarnings("serial")
@Entity
public class Skill implements GenericObject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SKILL_ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="FK_ST_ID")
	private SkillType skillType;
	
	@ManyToMany
	@JoinTable(name="PERSON_SKILL", joinColumns={@JoinColumn(name="SKILL_ID",insertable = false, updatable = false)},
	inverseJoinColumns={@JoinColumn(name="PD_ID",insertable = false, updatable = false)})
	private List<PersonDetail> personDetails = new ArrayList<>(); 

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
	 * @return the skillType
	 */
	public SkillType getSkillType() {
		return skillType;
	}

	/**
	 * @param skillType the skillType to set
	 */
	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

	/**
	 * @return the personDetails
	 */
	public List<PersonDetail> getPersonDetails() {
		return personDetails;
	}

	/**
	 * @param personDetails the personDetails to set
	 */
	public void setPersonDetails(List<PersonDetail> personDetails) {
		this.personDetails = personDetails;
	}
	
	
}
