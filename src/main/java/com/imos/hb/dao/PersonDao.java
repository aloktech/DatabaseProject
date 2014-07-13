/**
 * 
 */
package com.imos.hb.dao;

import org.hibernate.Session;

import com.imos.hb.generic.GenericActionImpl;
import com.imos.hb.onetoone.Person;
import com.imos.hb.util.HibernateUtility;

/**
 * @author Pintu
 *
 */
public class PersonDao extends GenericActionImpl {
	
	private HibernateUtility hu = HibernateUtility.getInstance();
	
	public void addPerson(Person person) {
		Session session = hu.getSession();
		if (session == null) {
			hu.createSession();
			session = hu.getSession();
		}
		if (person.getId() != null && session != null) {
			saveData(session, Person.class, person);
		}
	}
	
	public void updatePerson(Person person, boolean full){
		Session session = hu.getSession();
		if (session == null) {
			hu.createSession();
			session = hu.getSession();
		}
		if (person.getId() != null && session != null) {
			Person p = findById(session, Person.class, person);
			copyPerson(person, p, full);
			updateData(session, p);
		}
	}
	
	public void copyPerson(Person src, Person dest, boolean full) {
		if (full && !dest.equals(src)) {
			dest.setFirstName(src.getFirstName());
		} else {
			if (src.getFirstName() != null) {
				dest.setFirstName(src.getFirstName());
			} else if (src.getGender() != null) {
				dest.setGender(src.getGender());
			} 
		}
	}
}
