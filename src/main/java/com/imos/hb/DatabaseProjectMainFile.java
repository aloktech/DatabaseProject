/**
 * 
 */
package com.imos.hb;

import java.util.List;

import org.hibernate.Session;

import com.imos.hb.generic.GenericActionImpl;
import com.imos.hb.model.Address;
import com.imos.hb.model.User;
import com.imos.hb.model.UserDetail;
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
		hu.setFilePath("F:\\Tools\\Eclipse SDK\\workspace2\\DatabaseProject\\src\\com\\imos\\hb\\model");
		hu.setDatabaseName("smdb");
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

		List<User> users = null;
		User user = new User();
		user.setFirstName("Alok");
		user.setMiddleName("Ranjan");
		user.setLastName("Meher");
		user.setEmployeeId("NI1826");
		user.setGender(Gender.MALE.toString());
		
		UserDetail userDetail = new UserDetail();
		
		Address address = new Address();
		address.setFirstStreet("5th Main Road Avenue");
		address.setState("Tamilnadu");
		address.setPinCode(600042);
		address.setAddressType(AddressType.RESIDENCE.toString());
		userDetail.getAddresses().add(address);
		
		address = new Address();
		address.setFirstStreet("Shriram IT Gateway");
		address.setState("Tamilnadu");
		address.setPinCode(600042);
		address.setAddressType(AddressType.OFFICE.toString());
		userDetail.getAddresses().add(address);
		
		address = new Address();
		address.setFirstStreet("Samaleswari");
		address.setState("Tamilnadu");
		address.setPinCode(600042);
		address.setAddressType(AddressType.PERMANENT.toString());
		userDetail.getAddresses().add(address);
		
		user.setUserDetail(userDetail);

		action.saveData(session, User.class, user);
		
		session.flush();

		user = new User();
		user.setFirstName("Nithya");
		user.setMiddleName("");
		user.setLastName("Mathavan");
		user.setEmployeeId("NI1825");
		user.setGender(Gender.FEMALE.toString());
		
		userDetail = new UserDetail();
		
		address = new Address();
		address.setFirstStreet("Chengalpattu");
		address.setState("Tamilnadu");
		address.setPinCode(600042);
		address.setAddressType(AddressType.PERMANENT.toString());
		userDetail.getAddresses().add(address);
		
		address = new Address();
		address.setFirstStreet("L&T Technology");
		address.setState("Tamilnadu");
		address.setPinCode(600042);
		address.setAddressType(AddressType.OFFICE.toString());
		userDetail.getAddresses().add(address);
		
		user.setUserDetail(userDetail);

		action.saveData(session, User.class, user);
		
		session.flush();

		users = action.findAll(session, "User.findAll");

		if (users != null) {
			for (User u : users) {
				System.out.println(u.getFirstName());
			}
		}

		/*user = new User();
		user.setFirstName("Nithya");
		user.setMiddleName("");
		user.setLastName("Mathavan");
		user.setEmployeeId("NI1825");
		user.setGender(Gender.MALE.toString());*/

		User us = action.findById(session, User.class, user, false);
		if (!us.equals(user)) {
			copyObjects(user, us);

			action.updateData(session, us);
		}

		users = action.findAll(session, "User.findAll");

		if (users != null) {
			for (User u : users) {
				System.out.println(u.getFirstName());
			}
		}

		/*//us = action.findById(session, User.class, user, false);
		action.removeData(session, us);
		
		hu.close();
		hu.createSession();

		session = hu.getSession();
		action.removeData(session, user);

		users = action.findAll(session, "User.findAll");

		if (users != null) {
			for (User u : users) {
				System.out.println(u.getFirstName());
			}
		}*/
	}

	public void copyObjects(User user, User us) {
		us.setFirstName(user.getFirstName());
		us.setMiddleName(user.getMiddleName());
		us.setLastName(user.getLastName());
		us.setGender(user.getGender());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new DatabaseProjectMainFile().testOne();
	}

}
