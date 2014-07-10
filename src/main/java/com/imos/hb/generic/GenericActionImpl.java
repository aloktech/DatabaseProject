/**
 * 
 */
package com.imos.hb.generic;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Pintu
 *
 */
public class GenericActionImpl implements GenericAction<GenericObject> {
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends GenericObject> T findById(Session session, Class<T> type, T entity, boolean lock) {
		return (T) session.get(type, (Serializable) entity.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends GenericObject> List<T> findAll(Session session, String namedQuery) {
		Query query = session.getNamedQuery(namedQuery);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends GenericObject> T saveData(Session session,Class<T> type, T entity) {
		Transaction tran = session.getTransaction();
		T obj = null;
		if (entity.getId() != null) {
			obj = (T) session.get(type, (Serializable) entity.getId());
		}
		if (obj == null) {
			try {
				tran.begin();
				session.persist(entity);
				tran.commit();
			} catch (Exception e) {
				tran.rollback();
				e.printStackTrace();
				return entity;
			} 
		} 
		return entity;
	}

	@Override
	public <T extends GenericObject> T updateData(Session session, T entity) {
		Transaction tran = session.getTransaction();

		try {
			tran.begin();
			session.saveOrUpdate(entity);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();
			return entity;
		} finally {
			session.flush();
			session.clear();
		}
		return entity;
	}

	@Override
	public int removeData(Session session, GenericObject entity) {
		Transaction tran = session.getTransaction();

		try {
			tran.begin();
			session.delete(entity);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();
			return 0;
		} finally {
			session.flush();
			session.clear();
		}
		return 1;
	}
}
