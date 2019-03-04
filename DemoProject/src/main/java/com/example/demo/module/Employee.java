package com.example.demo.module;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee 
{
	@Id
	private int eid;
	private String eName;
	private String eDesignation;
	

	public int getEid() {
		return eid;
	}


	public void setEid(int eid) {
		this.eid = eid;
	}





	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Employee eid ="+eid +" ename="+eName +" eDesignation="+eDesignation;
	}


	public String geteName() {
		return eName;
	}


	public void seteName(String eName) {
		this.eName = eName;
	}


	public String geteDesignation() {
		return eDesignation;
	}


	public void seteDesignation(String eDesignation) {
		this.eDesignation = eDesignation;
	}
	
	
}
