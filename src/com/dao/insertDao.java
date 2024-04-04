package com.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.course;
import com.entity.passport;
import com.entity.person;
import com.entity.simcard;
import com.session.sessionObject;

public class insertDao {

	public static void main1(String[] args) {
	Session s	= sessionObject.getSession();
		person p= new person("shiva", 32,"delhi");
		person p1= new person("chinna", 33,"goa");
		person p2= new person("srinu", 55,"goa");
		person p3= new person("ajay", 33,"kerala");
		
		simcard sc = new simcard(); sc.setSname("docomo"); sc.setSnum(434343);
		 simcard sc1 = new simcard(); sc1.setSname("uninor"); sc1.setSnum(343434);
		 simcard sc3 = new simcard(); sc3.setSname("idea"); sc3.setSnum(454544);
		 simcard sc2 = new simcard(); sc2.setSname("docomo"); sc2.setSnum(434343);
		 simcard sc4 = new simcard(); sc4.setSname("uninor"); sc4.setSnum(343434);
		 simcard sc5 = new simcard(); sc5.setSname("idea"); sc5.setSnum(454544);
		 simcard sc6= new simcard(); sc6.setSname("docomo"); sc6.setSnum(434343);
		 simcard sc7 = new simcard(); sc7.setSname("uninor"); sc7.setSnum(343434);
		 simcard sc8 = new simcard(); sc8.setSname("idea"); sc8.setSnum(454544);
		 simcard sc9= new simcard(); sc9.setSname("docomo"); sc9.setSnum(434343);
		 simcard sc10 = new simcard(); sc10.setSname("uninor"); sc10.setSnum(343434);
		 simcard sc11 = new simcard(); sc11.setSname("idea"); sc11.setSnum(454544);
	
		passport pp = new passport();
		pp.setP(p);
		pp.setPnum("343dfv");
		passport pp1 = new passport();
		pp1.setP(p1);
		pp1.setPnum("343dfv");passport pp2 = new passport();
		pp2.setP(p2);
		pp2.setPnum("343dfv");passport pp3 = new passport();
		pp3.setP(p3);
		pp3.setPnum("343dfv");
		
		List<person> lc = new ArrayList<person>(Arrays.asList(p, p1, p2,p3));
		course c = new course();
		c.setCname("database");
		c.setP(lc);
		sc.setP(p);sc1.setP(p);sc3.setP(p);
		sc2.setP(p1);sc6.setP(p1);sc9.setP(p1);
		sc4.setP(p2);sc7.setP(p2);sc10.setP(p2);
		sc5.setP(p3);sc8.setP(p3);sc11.setP(p3);
		
		Transaction t = s.beginTransaction();
		s.save(p);s.save(p1);s.save(p2);s.save(p3);
	s.save(pp);s.save(pp1);s.save(pp2);s.save(pp3);
	
		s.save(sc);s.save(sc1);s.save(sc3);s.save(sc2);s.save(sc9);s.save(sc4);s.save(sc5);s.save(sc6);s.save(sc7);s.save(sc8);s.save(sc10);s.save(sc11);
		s.save(c);
		t.commit();
		s.close();
	}
	public static void main2(String[] args) {

		Session s	= sessionObject.getSession();
		course c = new course();
		c.setCname("mysql");
		Transaction t = s.beginTransaction();
		s.save(c);
		t.commit();
		s.close();
	}
	public static void main3(String[] args) {
		Session s	= sessionObject.getSession();
		person p = new person("krishna", 56, "mysur");
		passport pp = new passport();
		pp.setP(p);
		pp.setPnum("666jjj");
		p.setPassport(pp);
		Transaction t = s.beginTransaction();
		s.save(p);
		t.commit();
		s.close();
	}public static void main(String[] args) {
		Session s	= sessionObject.getSession();
		Transaction t = s.beginTransaction();
		person p = new person("bharath", 56, "mysur");
		s.save(p);

		// Create course entities and associate them with the person
		course c1 = new course(); c1.setCname("cloud");c1.setP(new ArrayList<person>(Arrays.asList(p))); ;
		course c2 = new course(); c2.setCname("devops");c2.setP(new ArrayList<person>(Arrays.asList(p))); 
		course c3 = new course(); c3.setCname("sql");c3.setP(new ArrayList<person>(Arrays.asList(p)));
		s.save(c1);
		s.save(c2);
		s.save(c3);

		t.commit();
		s.close();
	}

}
