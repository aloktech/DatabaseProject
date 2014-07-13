/**
 * 
 */
package com.imos.hb.generic;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.imos.hb.util.DPLogger;

/**
 * @author Pintu
 *
 */
public class GenericActionImpl implements GenericAction<GenericObject> {
	
	private final Logger LOGGER = Logger.getLogger(GenericActionImpl.class.getSimpleName());
	
	public GenericActionImpl() {
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends GenericObject> T findById(Session session, Class<T> type, T entity) {
		return (T) session.get(type, (Serializable) entity.getId());
	}
	
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
	public <T extends GenericObject> T saveData(Session session, Class<T> type, T entity) {
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
				DPLogger.info(LOGGER, type, "is saved to the database");
			} catch (Exception e) {
				tran.rollback();
				DPLogger.warning(LOGGER, type, "is not saved to the database");
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
			DPLogger.info(LOGGER, entity.getClass(), "is saved to the database");
		} catch (Exception e) {
			tran.rollback();
			DPLogger.warning(LOGGER, entity.getClass(), "is not saved to the database");
			return entity;
		} finally {
			session.flush();
			session.clear();
		}
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends GenericObject> void removeData(Session session, Class<T> type, T entity) {
		Transaction tran = session.getTransaction();
		T obj = null;
		if (entity.getId() != null) {
			obj = (T) session.get(type, (Serializable) entity.getId());
		}
		if (obj != null) {
			try {
				tran.begin();
				session.delete(obj);
				tran.commit();
				DPLogger.info(LOGGER, entity.getClass(), "is deleted from the");
			} catch (Exception e) {
				tran.rollback();
				DPLogger.warning(LOGGER, type, "is not saved to the database");
			}  finally {
				session.flush();
				session.clear();
			}
		}
	}
}
