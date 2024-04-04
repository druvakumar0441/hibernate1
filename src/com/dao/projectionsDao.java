package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.entity.person;
import com.session.sessionObject;

public class projectionsDao {

	public static void main1(String[] args) {
		Session s = sessionObject.getSession();
		Criteria cr=s.createCriteria(person.class,"p");
		cr.createAlias("p.course", "c");
		cr.createAlias("p.simcard", "sc");
		cr.createAlias("p.passport", "pp");
		ProjectionList pl=Projections.projectionList();
		pl.add(Projections.property("p.pid"));
		pl.add(Projections.property("p.pname"));
		pl.add(Projections.property("pp.ppnum"));
		pl.add(Projections.property("sc.sname"));
		pl.add(Projections.property("c.cname"));
		
		cr.setProjection(pl);
		
		cr.add(Restrictions.gt("p.page", 30));
		
		List<Object[]> objlist=cr.list();
		for (Object[] o : objlist) {
		System.out.println(o[0]+" "+o[1]+" "+o[2]+" "+o[3]+" "+o[4]) ;}
		
	}
	///OR
	public static void main(String[] args) {
		Session s = sessionObject.getSession();
		Criteria cr=s.createCriteria(person.class,"p");
		cr.createAlias("p.course", "c");
		cr.createAlias("p.simcard", "sc");
		cr.createAlias("p.passport", "pp");
		ProjectionList pl=Projections.projectionList();
		pl.add(Projections.property("p.pid")).add(Projections.property("p.pname"))
		.add(Projections.property("pp.ppnum")).add(Projections.property("sc.sname"))
		.add(Projections.property("c.cname"));
		
		cr.setProjection(pl);
		
		cr.add(Restrictions.gt("p.page", 30));
		
		List<Object[]> objlist=cr.list();
		for (Object[] o : objlist) {
		System.out.println(o[0]+" "+o[1]+" "+o[2]+" "+o[3]+" "+o[4]) ;}
		
	}
}
