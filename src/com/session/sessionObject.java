package com.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class sessionObject {

	public static Session getSession() {
		Configuration con = new AnnotationConfiguration().configure();
		SessionFactory sf = con.buildSessionFactory();
		Session s = sf.openSession();
		return s;
		
	}
}
