/**
 * 
 */
package com.imos.hb.generic;

import java.util.List;

import org.hibernate.Session;

/**
 * @author Pintu
 *
 */
public interface GenericAction<T extends GenericObject> {
	
	@SuppressWarnings("hiding")
	<T extends GenericObject> T findById(Session session, Class<T> type, T entity);
	
	@SuppressWarnings("hiding")
	<T extends GenericObject> T findById(Session session, Class<T> type, T entity, boolean lock);

	@SuppressWarnings("hiding")
	<T extends GenericObject> List<T> findAll(Session session, String namedQuery);

	@SuppressWarnings("hiding")
	<T extends GenericObject> T saveData(Session session, Class<T> type, T entity);

	@SuppressWarnings("hiding")
	<T extends GenericObject> T updateData(Session session, T entity);

	@SuppressWarnings("hiding")
	<T extends GenericObject> void removeData(Session session, Class<T> type, T entity);
}
