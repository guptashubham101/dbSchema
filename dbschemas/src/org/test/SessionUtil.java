package org.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
	private static SessionFactory sessionFactory;

    static {

        /* Configuration configuration = new Configuration();
         configuration.configure();
         StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
         */
    	sessionFactory=new Configuration().configure().buildSessionFactory(); 
     
    }

   

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
