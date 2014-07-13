/**
 * 
 */
package com.imos.hb;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;

import com.imos.hb.dao.AddressDao;
import com.imos.hb.dao.PersonDao;
import com.imos.hb.generic.GenericActionImpl;
import com.imos.hb.manytomany.Address;
import com.imos.hb.onetoone.Person;
import com.imos.hb.onetoone.PersonDetail;
import com.imos.hb.onetoone.PersonPrimaryKey;
import com.imos.hb.util.AddressType;
import com.imos.hb.util.Gender;
import com.imos.hb.util.HibernateUtility;

/**
 * @author Pintu
 *
 */
public class DatabaseProjectMainFile {

	private GenericActionImpl action;

	private HibernateUtility hu = HibernateUtility.getInstance();

	public DatabaseProjectMainFile() {

	}

	private void testOne() {
		action = new GenericActionImpl();

		hu.setDatabaseName("sm");
		String basePath = "src\\main\\java\\com\\imos\\hb";
		hu.setFilePath(basePath + "\\model," + basePath + "\\onetoone," + basePath + "\\onetomany," + basePath
				+ "\\manytomany");
		hu.setDatabaseName("smdb");
		hu.setCreateDatabase(false);
		//hu.setCreateDatabase(true);

		hu.configure();
		hu.createSession();

		Session session = hu.getSession();

		try {
			execute(session);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			hu.close();
		}
	}

	private void execute(Session session) {

		Person person = new Person();
		person.setFirstName("Alok");
		person.setMiddleName("Ranjan");
		person.setLastName("Meher");
		
		PersonPrimaryKey ppk = new PersonPrimaryKey();
		ppk.setEmployeeId("NI1826");
		person.setId(ppk);
		person.setGender(Gender.MALE.toString());

		PersonDetail pd = new PersonDetail();
		pd.setDateOfBirth(new Date(GregorianCalendar.getInstance().getTimeInMillis()));
		pd.setPerson(person);

		List<Address> addresses = new ArrayList<>();
		Address address = new Address();
		address.setFirstStreet("5th Main Road Avenue");
		address.setLocation("Dandeswaran");
		address.setState("Tamilnadu");
		address.setCity("Chennai");
		address.setPinCode(600042);
		address.setAddressType(AddressType.RESIDENCE.toString());
		//pd.getAddresses().add(address);
		addresses.add(address);

		address = new Address();
		address.setFirstStreet("Shriram IT Gateway");
		address.setLocation("Perangalathur");
		address.setCity("Chennai");
		address.setState("Tamilnadu");
		address.setPinCode(600042);
		address.setAddressType(AddressType.OFFICE.toString());
		//pd.getAddresses().add(address);
		addresses.add(address);

		address = new Address();
		address.setFirstStreet("Samaleswari");
		address.setLocation("Bolangir");
		address.setState("Tamilnadu");
		address.setCity("Chennai");
		address.setPinCode(600042);
		address.setAddressType(AddressType.PERMANENT.toString());
		//
		//addAddress(session, address, person);
		addresses.add(address);
		
		address = new Address();
		address.setFirstStreet("Tambaram");
		address.setLocation("Tambaram");
		address.setCity("Chennai");
		address.setState("Tamilnadu");
		address.setPinCode(600042);
		address.setAddressType(AddressType.RESIDENCE.toString());
		//pd.getAddresses().add(address);
		addresses.add(address);

		person.setPersonDetail(pd);

		action.saveData(session, Person.class, person);
		
		AddressDao addressDao = new AddressDao();
		addressDao.addAddresses(person, addresses);

		session.flush();

		person = new Person();
		person.setFirstName("Nithya");
		person.setMiddleName("");
		person.setLastName("Mathavan");
		ppk = new PersonPrimaryKey();
		ppk.setEmployeeId("NI1825");
		person.setId(ppk);
		person.setGender(Gender.FEMALE.toString());

		pd = new PersonDetail();
		pd.setPerson(person);

		address = new Address();
		address.setFirstStreet("Chengalpattu");
		address.setLocation("Tambaram");
		address.setCity("Chennai");
		address.setState("Tamilnadu");
		address.setPinCode(600042);
		address.setAddressType(AddressType.PERMANENT.toString());
		pd.getAddresses().add(address);

		address = new Address();
		address.setFirstStreet("L&T Technology");
		address.setLocation("Tambaram");
		address.setCity("Chennai");
		address.setState("Tamilnadu");
		address.setPinCode(600042);
		address.setAddressType(AddressType.OFFICE.toString());
		pd.getAddresses().add(address);

		person.setPersonDetail(pd);

		action.saveData(session, Person.class, person);
		
		session.flush();

		/*users = action.findAll(session, "Person.findAll");

		if (users != null) {
			for (Person u : users) {
				System.out.println(u.getFirstName());
			}
		}*/

		/*person = new Person();
		ppk = new PersonPrimaryKey();
		ppk.setEmployeeId("NI1825");
		person.setId(ppk);
		 
		person.setPersonDetail(pd);
		
		updatePerson(session, person);*/
		
		person = new Person();
		ppk = new PersonPrimaryKey();
		ppk.setEmployeeId("NI1825");
		person.setId(ppk);
		person.setGender(Gender.OTHERS.toString());
		
		PersonDao personDao = new PersonDao();
		personDao.updatePerson(person, false);

		/*users = action.findAll(session, "Person.findAll");

		if (users != null) {
			for (Person u : users) {
				System.out.println(u.getFirstName());
			}
		}*/

		/*
		 * //us = action.findById(session, User.class, user, false);
		 * action.removeData(session, us);
		 * 
		 * hu.close(); hu.createSession();
		 * 
		 * session = hu.getSession(); action.removeData(session, user);
		 * 
		 * users = action.findAll(session, "User.findAll");
		 * 
		 * if (users != null) { for (User u : users) {
		 * System.out.println(u.getFirstName()); } }
		 */
	}
	
	private void addAddress(Session session, Address address, Person person) {
		Person destPerson = action.findById(session, Person.class, person, false);
		destPerson.getPersonDetail().getAddresses().add(address);
	}
	
	private void updateAddress(Session session, Address address, Person person) {
		Address addr = action.findById(session, Address.class, address, false);
		copyAddress(address, addr);
		action.updateData(session, addr);
	}
	private void updatePerson(Session session, Person srcPerson) {
		Person destPerson = action.findById(session, Person.class, srcPerson, false);
		destPerson.setGender(Gender.FEMALE.toString());
		action.updateData(session, destPerson);
	}

	public void copyPerson(Person srcPerson, Person destPerson) {
		destPerson.setFirstName(srcPerson.getFirstName());
		destPerson.setMiddleName(srcPerson.getMiddleName());
		destPerson.setLastName(srcPerson.getLastName());
		destPerson.setGender(srcPerson.getGender());
	}
	
	public void copyAddress(Address src, Address dest) {
		dest.setAddressType(src.getAddressType());
		dest.setFirstStreet(src.getFirstStreet());
		dest.setSecondStreet(src.getSecondStreet());
		dest.setLocation(src.getLocation());
		dest.setCity(src.getCity());
		dest.setCountry(src.getCountry());
		dest.setPinCode(src.getPinCode());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new DatabaseProjectMainFile().testOne();
	}

}
