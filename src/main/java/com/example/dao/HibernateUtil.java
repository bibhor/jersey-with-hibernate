package com.example.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.SimpleModel;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	 
    private static SessionFactory buildSessionFactory() {
        try {
        	Configuration c = new Configuration();
        	c.addAnnotatedClass(SimpleModel.class);
            // Create the SessionFactory from hibernate.cfg.xml        	
            return c.configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }

}
