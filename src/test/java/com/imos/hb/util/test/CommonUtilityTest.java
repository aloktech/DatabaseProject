/**
 * 
 */
package com.imos.hb.util.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.imos.hb.DatabaseProjectMainFile;
import com.imos.hb.onetoone.Person;
import com.imos.hb.util.CommonUtility;

/**
 * @author Pintu
 *
 */
public class CommonUtilityTest {

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
	
	@Test
	public void extractPackageNameFromFilePathTestOne() {
		String filePath = "src\\test\\resources\\com\\imos\\testing1\\";
		List<String> paths = null;

		paths = CommonUtility.extractPackageNameFromFilePath(filePath, "src\\main\\java\\", "java");
		assertTrue(paths.size() == 0);
		assertNotNull(filePath);
		assertFalse(filePath.isEmpty());
	}
	
	@Test
	public void extractPackageNameFromFilePathTestTwo() {
		String filePath = "src\\test\\resources\\com\\imos\\testing\\";
		List<String> paths = null;

		paths = CommonUtility.extractPackageNameFromFilePath(filePath, "src\\main\\java\\", "java");
		assertTrue(paths.size() == 2);
		assertNotNull(filePath);
		assertFalse(filePath.isEmpty());
	}
}
