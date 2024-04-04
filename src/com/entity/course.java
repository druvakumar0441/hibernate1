package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class course {

	@Override
	public String toString() {
		return "course [cid=" + cid + ", cname=" + cname + "]";
	}
	@Id
	@GeneratedValue
	private int cid;
	private String cname;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="person_course",
			joinColumns = @JoinColumn(name="cid"),
			inverseJoinColumns = @JoinColumn(name="pid")
			)
	private List<person> p;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public List<person> getP() {
		return p;
	}
	public void setP(List<person> p) {
		this.p = p;
	}
	
}
