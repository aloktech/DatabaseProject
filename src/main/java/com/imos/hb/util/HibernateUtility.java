/**
 * 
 */
package com.imos.hb.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * @author Pintu
 *
 */
public class HibernateUtility {

	private static HibernateUtility instance = new HibernateUtility();

	private Configuration cfg = new Configuration();

	private Session session;
	private SessionFactory sessionFactory;
	private ServiceRegistry serviceRegistry;

	private boolean createDatabase;

	private String filePath, databaseName, url = "hibernate.connection.url";

	private HibernateUtility() {
	}

	public static HibernateUtility getInstance() {
		if (instance == null) {
			instance = new HibernateUtility();
		}

		return instance;
	}

	public void configure() {

		for (String path : CommonUtility.extractPackageNameFromFilePath(filePath, "src\\main\\java\\", "java")) {
			try {
				cfg.addAnnotatedClass(Class.forName(path));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		Properties prop = new Properties();
		try {
			prop.load(new FileReader("src/main/resources/mysql-resources.properties"));
			cfg.setProperties(prop);
			cfg.setProperty(url, cfg.getProperty(url) + "/" + databaseName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (createDatabase) {
			new SchemaExport(cfg).create(true, true);
		}
	}

	public Session createSession() {
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		boolean createSession = false;
		if (session == null) {
			createSession = true;
		} else if (!session.isOpen()) {
			createSession = true;
		}
		if (createSession) {
			if (sessionFactory == null) {
				sessionFactory = cfg.buildSessionFactory(serviceRegistry);
			} else if (sessionFactory.isClosed()) {
				sessionFactory = cfg.buildSessionFactory(serviceRegistry);
			}
			session = sessionFactory.openSession();
		}

		return session;
	}

	public void close() {
		if (session.isOpen()) {
			session.flush();
			session.clear();
			session.close();
		}

		sessionFactory.close();

		if (serviceRegistry != null) {
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
		}
	}

	/**
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @return the createDatabase
	 */
	public boolean isCreateDatabase() {
		return createDatabase;
	}

	/**
	 * @param createDatabase
	 *            the createDatabase to set
	 */
	public void setCreateDatabase(boolean createDatabase) {
		this.createDatabase = createDatabase;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath
	 *            the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @return the databaseName
	 */
	public String getDatabaseName() {
		return databaseName;
	}

	/**
	 * @param databaseName
	 *            the databaseName to set
	 */
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

}
