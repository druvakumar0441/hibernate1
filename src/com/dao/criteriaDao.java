package com.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.entity.course;
import com.entity.person;
import com.entity.simcard;
import com.session.sessionObject;

public class criteriaDao {

	public static void main1(String[] args) {
		Session s= sessionObject.getSession();
		Session s1= sessionObject.getSession();
		Transaction t = s.beginTransaction();
		Criteria c=s.createCriteria(person.class);
		c.add(Restrictions.like("pname", "%kishore"));
		List<person> p=c.list();
		for (person person : p) {
			System.out.print(person.getPid()+"==="+person.getPname()+"===");
			List<simcard> sc=person.getSimcard();
			for (simcard simcard : sc) {
				System.out.println(simcard.getSname()+"=="+simcard.getSnum());
			}
		}
		Query query=s1.createQuery("select p.pid, p.pname, sc.sname, sc.snum from person p join p.simcard sc where p.pname like '%kishore'");
				List<Object[]> oblist=query.list();
				for (Object[] objects : oblist) {
				System.out.println(objects[0]+ " "+ objects[1]+ " "+ objects[2]+ " "+ objects[3]);
				}
	}
	public static void main2(String[] args) {

		Session s= sessionObject.getSession();
		Transaction t = s.beginTransaction();
		Criteria c=s.createCriteria(person.class);
		c.add(Restrictions.like("pname", "%naveen"));
		List<person> p=c.list();
		for (person person : p) {
			System.out.print(person.getPid()+"==="+person.getPname()+"===");
			List<simcard> sc=person.getSimcard();
			for (simcard simcard : sc) {
				System.out.println(simcard.getSname()+"=="+simcard.getSnum());
			}
		}
	}
	public static void main3s(String[] args) {
			Session s= sessionObject.getSession();
			Transaction t = s.beginTransaction();
			
			List<String> clist = new ArrayList<String>();
			clist.add("css");
			clist.add("html");
			Criteria c=s.createCriteria(course.class);
			
			c.add(Restrictions.in("cname", clist));
			List<course> p=c.list();
			for (course course : p) {
				System.out.println(course.getCid()+"=="+course.getCname());
			}
			
	}public static void main3(String[] args) {
		Session s = sessionObject.getSession();
		Criteria c = s.createCriteria(person.class, "p");
		c.createAlias("p.simcard", "sc");
		c.add(Restrictions.eq("sc.sname", "jio"));
		List<person>scl = c.list();
		for (person per : scl) {
			System.out.println(per.getPid()+"="+per.getPname()+"="+per.getSimcard());
		}
	}
	public static void main(String[] args) {
		Session s = sessionObject.getSession();
	
		Criteria cr=s.createCriteria(person.class,"p");
		cr.createAlias("p.passport","pp");
		cr.createAlias("p.simcard", "sc");
		cr.add(Restrictions.between("p.page", 30, 40));
		List<person> plist= cr.list();
		for (person per : plist) {
		System.out.println(per.getPid()+"="+per.getPname()+"="+per.getPage()+"="+per.getPassport()+"="+per.getSimcard());
		/*
		 * List<Vendor> vlist=product.getV(); Iterator<Vendor> vli=vlist.iterator();
		 * while(vli.hasNext()) { System.out.println(vli.next().getVendorname());
		 * System.out.println(vli.next().getAvailability()); }
		 */
		System.out.println(" ------------------------------------------------ ");
	}}
}
