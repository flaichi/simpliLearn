package com.fl.hibernate.util;


import com.fl.hibernate.model.*;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.*;

public class HibernateUtil {
	private static  SessionFactory sessionFactory;
	
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
				Configuration cfg =  new Configuration();
				//hibernate settings equivalent to hiernate.cfg.xml
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/sampledb?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "farouk");
				settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				cfg.setProperties(settings);
				//cfg.addAnnotatedClass(Login.class);
				cfg.addAnnotatedClass(Sale.class);
				//cfg.addAnnotatedClass(Support.class);
				ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings (cfg.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = cfg.buildSessionFactory(sr);	
			} catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		return sessionFactory;
	}
}