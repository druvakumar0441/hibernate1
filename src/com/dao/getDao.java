package com.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.course;
import com.entity.person;
import com.entity.simcard;
import com.session.sessionObject;

public class getDao {
	
	public static void main1(String[] args) {
		Session s =sessionObject.getSession();
		
		person p = (person) s.get(person.class, 2);
		System.out.println(p.getPname()+",,"+p.getPassport().getPnum());
		s.close();
	}
	public static void main2(String[] args) {
		Session s =sessionObject.getSession();
		course p = (course) s.get(course.class, 8);
		System.out.println(p);
		s.close();
	
	}
	public static void main3(String[] args) {
		Session s =sessionObject.getSession();
		Transaction t = s.beginTransaction();
		course p = (course) s.get(course.class, 15);
		p.setCname("html");
		s.update(p);
		t.commit();
		s.close();
	}
	public static void main4(String[] args) {

		Session s =sessionObject.getSession();
		Transaction t = s.beginTransaction();
		person p = (person) s.get(person.class, 44);
		System.out.println(p);
		if(p!=null) {
			System.out.println("printd");
		}else {
			System.out.println("null prints");
		}
		s.close();
	
	}
	
	public static void main5(String[] args) {
		Session s =sessionObject.getSession();
		
		course p = (course) s.get(course.class, 8);
		System.out.println(p.getP());
		s.close();
	
	}
	public static void main6(String[] args) {
		Session s =sessionObject.getSession();
		
		Query q = s.createQuery("select p.pname, c.sname from person p inner join p.simcard c where p.pid =16");
		List<Object[]> l =q.list();
		for (Object[] result : l) {
		   	System.out.print(result[0]+"===");
		   	System.out.println(result[1]);
		}
		s.close();
	
		
	}

	public static void main7(String[] args) {
		Session s =sessionObject.getSession();
		
		Query q = s.createQuery("select p.pname, c.cname from course c inner join c.p p where p.pid =60");
		List<Object[]> l =q.list();
		for (Object[] result : l) {
		   	System.out.print(result[0]+"===");
		   	System.out.println(result[1]);
		}
		s.close();
	}
	public static void main8(String[] args) {Session s = sessionObject.getSession();
	Transaction t = s.beginTransaction();

	// Load the person entity
	person p = (person) s.load(person.class, 1); // Use session.get() instead of session.load()

	// Verify if the person entity is null
	if (p == null) {
	    System.out.println("Person entity with ID 1 not found.");
	    // Handle the error or return
	    return;
	}

	System.out.println(p.getPname() + "==" + p.getSimcard());

	// Delete existing simcard entities
	p.getSimcard().clear(); // Clear the existing simcard list

	// Create new simcard entities and associate them with the person
	simcard sc = new simcard(); sc.setSname("airtel"); sc.setSnum(342342); sc.setP(p);
	simcard sc1 = new simcard(); sc1.setSname("jio"); sc1.setSnum(342342); sc1.setP(p);
	simcard sc2 = new simcard(); sc2.setSname("bsnl"); sc2.setSnum(342342); sc2.setP(p);

	List<simcard> scl = new ArrayList<simcard>(Arrays.asList(sc, sc1, sc2));
	p.setSimcard(scl);

	// Update the person entity
	s.update(p);

	// Commit the transaction and close the session
	t.commit();
	s.close();

	System.out.println("done");
}
	public static void main9(String[] args) {
	Session s =sessionObject.getSession();
		
		Query q = s.createQuery("select p.pid ,p.pname, sc.sname, sc.snum from person p inner join p.simcard sc where sc.sname =?");
		q.setString(0, "jio");
		List<Object[]>scl = q.list();
		for (Object[] per : scl) {
			System.out.println(per[0]+"="+per[1]+"="+per[2]+"="+per[3]);
		}
	}
	public static void main11(String[] args) {	Session s =sessionObject.getSession();
		Query q=s.createQuery("select p.pid, p.pname,p.page,m.ppnum, v.sname,v.snum from person p join p.simcard v join p.passport m where p.page between 30 and 40");
				List<Object[]> obj=q.list();
				for (Object[] o : obj) {
				System.out.println(o[0]+" "+o[1]+" "+o[2]+" "+o[3]+" "+o[4]+" "+o[5]);
				}
	}
	
}
