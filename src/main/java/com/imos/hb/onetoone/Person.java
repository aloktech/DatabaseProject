package com.imos.hb.onetoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import com.imos.hb.generic.GenericObject;

@Entity
@NamedQueries({ @NamedQuery(name = "Person.findAll", query = "select p from Person p") })
public class Person implements Serializable, GenericObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -693808501172324257L;
	
	@Id
	@EmbeddedId
	private PersonPrimaryKey id;
	
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name = "GENDER", nullable = false)
	private String gender;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="FK_PD_ID")
	private PersonDetail personDetail;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person u = (Person) obj;
			if (u == this) {
				return true;
			}

			if (u.getFirstName().equals(this.getFirstName())) {
				if (u.getMiddleName().equals(this.getMiddleName())) {
					if (u.getLastName().equals(this.getLastName())) {
						if (u.getGender().equals(this.getGender())) {
							return true;
						}
					}
				}
			}

			return false;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int value = 15 * this.getFirstName().hashCode() + 15 * this.getMiddleName().hashCode() + 15
				* this.getLastName().hashCode() + 15 * this.getGender().hashCode();
		return value;
	}

	/**
	 * @return the personDetail
	 */
	public PersonDetail getPersonDetail() {
		return personDetail;
	}

	/**
	 * @param personDetail the personDetail to set
	 */
	public void setPersonDetail(PersonDetail personDetail) {
		this.personDetail = personDetail;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName
	 *            the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the id
	 */
	public PersonPrimaryKey getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(PersonPrimaryKey id) {
		this.id = id;
	}
}
