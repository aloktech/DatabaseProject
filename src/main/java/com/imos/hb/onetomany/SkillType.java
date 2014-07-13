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
import javax.persistence.OneToMany;

import com.imos.hb.generic.GenericObject;
import com.imos.hb.manytomany.Domain;

/**
 * @author Pintu
 *
 */
@SuppressWarnings("serial")
@Entity
public class SkillType implements GenericObject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ST_ID")
	private Long id;

	@OneToMany(mappedBy="skillType")
	private List<Skill> skill = new ArrayList<>();
	
	@Column(name="NAME")
	private String name;
	
	@ManyToMany
	@JoinTable(name="DOMAIN_SKILLTYPE", joinColumns={@JoinColumn(name="ST_ID",insertable = false, updatable = false)},
	inverseJoinColumns={@JoinColumn(name="DOMAIN_ID",insertable = false, updatable = false)})
	private List<Domain> domains;

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
	 * @return the skill
	 */
	public List<Skill> getSkill() {
		return skill;
	}

	/**
	 * @param skill
	 *            the skill to set
	 */
	public void setSkill(List<Skill> skill) {
		this.skill = skill;
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
	 * @return the domains
	 */
	public List<Domain> getDomains() {
		return domains;
	}

	/**
	 * @param domains the domains to set
	 */
	public void setDomains(List<Domain> domains) {
		this.domains = domains;
	}


}
