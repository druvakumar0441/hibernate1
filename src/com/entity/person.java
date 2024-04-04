package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="person")
public class person {

	@Id
	@GeneratedValue
	private int pid;
	private String pname;
	private int page;
	private String paddress;
	
	@ManyToMany(mappedBy = "p",cascade = CascadeType.ALL)
	private List<course> course;
	@OneToMany(mappedBy = "p",cascade = CascadeType.ALL)
	private List<simcard> simcard;
	@OneToOne(mappedBy = "p",cascade = CascadeType.ALL)
	private passport passport;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public List<course> getCourse() {
		return course;
	}

	public void setCourse(List<course> course) {
		this.course = course;
	}

	public List<simcard> getSimcard() {
		return simcard;
	}

	public void setSimcard(List<simcard> simcard) {
		this.simcard = simcard;
	}

	public passport getPassport() {
		return passport;
	}

	public void setPassport(passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "person [pid=" + pid + ", pname=" + pname + ", page=" + page + ", paddress=" + paddress + "]";
	}

	public person(String pname, int page, String paddress) {
		super();
		this.pname = pname;
		this.page = page;
		this.paddress = paddress;
	}

	public person() {
		super();
	}
	
}
