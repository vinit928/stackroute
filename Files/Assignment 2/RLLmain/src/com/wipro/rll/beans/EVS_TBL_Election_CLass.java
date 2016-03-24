package com.wipro.rll.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "EVS_TBL_Election")
public class EVS_TBL_Election_CLass {

	@Id
	@Column(name = "electionID")
	String electionID;
	@Column(name = "name")
	String name;
	@Column(name = "electionDate")
	Date electionDate;
	@Column(name = "district")
	String district;
	@Column(name = "constituency")
	String constituency;
	@Column(name = "countionDate")
	Date countionDate;

	public String getElectionID() {
		return electionID;
	}

	public void setElectionID(String electionID) {
		this.electionID = electionID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getElectionDate() {
		return electionDate;
	}

	public void setElectionDate(Date electionDate) {
		this.electionDate = electionDate;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	public Date getCountionDate() {
		return countionDate;
	}

	public void setCountionDate(Date countionDate) {
		this.countionDate = countionDate;
	}
}
