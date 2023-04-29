package com.acadamy.util;

import org.hibernate.SessionFactory;
import com.teacher.entity.ETeacher;
import com.learn.entity.EClass;

import org.hibernate.cfg.Configuration;
public class HibernateUtil {
static SessionFactory sessionFactory=null;
public static SessionFactory buildSessionFactory() {
	
	if (sessionFactory!=null) {
		return sessionFactory;
	}
	//step 1 : create configuration object
	
	Configuration cfg=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EClass.class);
	sessionFactory =cfg.buildSessionFactory();

	
	return sessionFactory;
	
	
}

}
