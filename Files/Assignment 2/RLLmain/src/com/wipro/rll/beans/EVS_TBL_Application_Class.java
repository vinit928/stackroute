package com.wipro.rll.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVS_TBL_Application")
public class EVS_TBL_Application_Class {

	@Id
	@Column(name = "userID")
	String userID;
	@Column(name = "constituency")
	String constituency;
	@Column(name = "passesStatus")
	int passesStatus;
	@Column(name = "approvedStatus")
	int approvedStatus;
	@Column(name = "voterID")
	String voterID;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	public int getPassesStatus() {
		return passesStatus;
	}

	public void setPassesStatus(int passesStatus) {
		this.passesStatus = passesStatus;
	}

	public int getApprovedStatus() {
		return approvedStatus;
	}

	public void setApprovedStatus(int approvedStatus) {
		this.approvedStatus = approvedStatus;
	}

	public String getVoterID() {
		return voterID;
	}

	public void setVoterID(String voterID) {
		this.voterID = voterID;
	}
}
