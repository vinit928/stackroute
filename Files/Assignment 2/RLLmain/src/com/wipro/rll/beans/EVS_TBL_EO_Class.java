package com.wipro.rll.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = " EVS_TBL_EO")
public class EVS_TBL_EO_Class {

	@Id
	@Column(name = "electoralOfficerID")
	String electoralOfficerID;
	@Column(name = "constituency")
	String constituency;
	public String getElectoralOfficerID() {
		return electoralOfficerID;
	}
	public void setElectoralOfficerID(String electoralOfficerID) {
		this.electoralOfficerID = electoralOfficerID;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	
}
