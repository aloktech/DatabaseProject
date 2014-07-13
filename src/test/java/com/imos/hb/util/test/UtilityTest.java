/**
 * 
 */
package com.imos.hb.util.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.imos.hb.DatabaseProjectMainFile;
import com.imos.hb.onetoone.Person;

/**
 * @author Pintu
 *
 */
public class UtilityTest {

	@Test
	public void testCopyObjects() {
		DatabaseProjectMainFile ins = new DatabaseProjectMainFile();
		Person person1 = new Person();
		person1.setFirstName("Alok");
		person1.setMiddleName("Ranjan");
		person1.setLastName("Meher");
		Person person2 = new Person();

		assertNotEquals(person1.getFirstName(), person2.getFirstName());
		assertNotEquals(person1.getMiddleName(), person2.getMiddleName());
		assertNotEquals(person1.getLastName(), person2.getLastName());
		ins.copyPerson(person1, person2);
		assertEquals(person1.getFirstName(), person2.getFirstName());
		assertEquals(person1.getMiddleName(), person2.getMiddleName());
	}
}
