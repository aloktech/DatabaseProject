package com.imos.hb.dao;

import java.util.List;

import org.hibernate.Session;

import com.imos.hb.generic.GenericActionImpl;
import com.imos.hb.manytomany.Address;
import com.imos.hb.onetoone.Person;
import com.imos.hb.util.HibernateUtility;

public class AddressDao extends GenericActionImpl {
	
	private Session session;
	
	public void addAddress(Person person, Address address) {
		if (session == null) {
			session = HibernateUtility.getInstance().createSession();
		}
		Person destPerson = findById(session, Person.class, person, false);
		destPerson.getPersonDetail().getAddresses().add(address);
		saveData(session, Person.class, person);
	}
	
	public void addAddresses(Person person, List<Address> addresses) {
		if (session == null) {
			session = HibernateUtility.getInstance().createSession();
		}
		Person destPerson = findById(session, Person.class, person, false);
		for (Address address : addresses) {
			destPerson.getPersonDetail().getAddresses().add(address);
		}
		saveData(session, Person.class, person);
	}
	
	public void updateAddress(Address address) {
		if (session == null) {
			session = HibernateUtility.getInstance().createSession();
		}
		Address addr = findById(session, Address.class, address, false);
		copyAddress(address, addr, true);
		updateData(session, addr);
	}
	
	public void copyAddress(Address src, Address dest, boolean full) {
		/*if (full && !dest.equals(src)) {
			dest.setFirstName(src.getFirstName());
		} else {
			if (src.getFirstName() != null) {
				dest.setFirstName(src.getFirstName());
			} else if (src.getGender() != null) {
				dest.setGender(src.getGender());
			} 
		}*/
	}
}
