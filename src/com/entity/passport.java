package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="passport")
public class passport {

	@Override
	public String toString() {
		return "passport [ppid=" + ppid + ", ppnum=" + ppnum + "]";
	}
	@Id
	@GeneratedValue
	private int ppid;
	private String ppnum;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pid")
	private person p;
	public int getPid() {
		return ppid;
	}
	public void setPid(int pid) {
		this.ppid = pid;
	}
	public String getPnum() {
		return ppnum;
	}
	public void setPnum(String pnum) {
		this.ppnum = pnum;
	}
	public person getP() {
		return p;
	}
	public void setP(person p) {
		this.p = p;
	}
	
}
