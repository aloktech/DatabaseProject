/**
 * 
 */
package com.imos.hb.util.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.imos.hb.DatabaseProjectMainFile;
import com.imos.hb.onetoone.User;

/**
 * @author Pintu
 *
 */
public class UtilityTest {
	
	@Test
	public void testCopyObjects() {
		DatabaseProjectMainFile ins = new DatabaseProjectMainFile();
		User us1 = new User();
		us1.setFirstName("Alok");
		us1.setMiddleName("Ranjan");
		us1.setLastName("Meher");
		User us2 = new User();
		
		assertNotEquals(us1.getFirstName(), us2.getFirstName());
		assertNotEquals(us1.getMiddleName(), us2.getMiddleName());
		assertNotEquals(us1.getLastName(), us2.getLastName());
		ins.copyObjects(us1, us2);
		assertEquals(us1.getFirstName(), us2.getFirstName());
		assertEquals(us1.getMiddleName(), us2.getMiddleName());
	}
}
