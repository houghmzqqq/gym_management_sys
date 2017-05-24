package com.xyz.gym_management_sys.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUTIL 
{
	private static SessionFactory sessionFactory;
	private static Session session;
	
	//
	static
	{
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}
	
	//
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
	//获取session
	public static Session getSession()
	{
		session = sessionFactory.openSession();
		return session;
	}
	
	//关闭session
	public static void closeSession(Session session)
	{
		if(session != null)
		{
			session.close();
		}
	}
}
