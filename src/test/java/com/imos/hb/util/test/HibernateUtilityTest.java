/**
 * 
 */
package com.imos.hb.util.test;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;

import com.imos.hb.util.CommonUtility;

/**
 * @author Pintu
 *
 */
public class HibernateUtilityTest {

	@Test
	public void extractPackageNameFromFilePathTest() {
		String filePath = "src\\test\\resources\\com\\imos\\testing\\";
		List<String> paths = null;

		paths = CommonUtility.extractPackageNameFromFilePath(filePath, "src\\main\\java\\", "java");
		assertTrue(paths.size() == 2);
		assertNotNull(filePath);
		assertFalse(filePath.isEmpty());
	}
}
