/**
 * 
 */
package com.imos.hb.util.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.imos.hb.util.HibernateUtility;

/**
 * @author Pintu
 *
 */
public class HibernateUtilityTest {

	@Test
	public void test() {
		HibernateUtility hu = HibernateUtility.getInstance();
		assertTrue(hu != null);
	}
}
