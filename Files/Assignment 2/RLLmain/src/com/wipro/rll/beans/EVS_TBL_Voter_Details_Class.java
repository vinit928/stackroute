package com.wipro.rll.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVS_TBL_Voter_Details")
public class EVS_TBL_Voter_Details_Class {

	@Id
	@Column(name = "serialNo")
	int serialNo;
	@Column(name = "candidateID")
	String candidateID;
	@Column(name = "electionID")
	String electionID;
	@Column(name = "voterID")
	String voterID;
	@Column(name = "confrm")
	String confrm;
	@Column(name = "Reject")
	String Reject;

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getCandidateID() {
		return candidateID;
	}

	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}

	public String getElectionID() {
		return electionID;
	}

	public void setElectionID(String electionID) {
		this.electionID = electionID;
	}

	public String getVoterID() {
		return voterID;
	}

	public void setVoterID(String voterID) {
		this.voterID = voterID;
	}

	public String getConfrm() {
		return confrm;
	}

	public void setConfrm(String confrm) {
		this.confrm = confrm;
	}

	public String getReject() {
		return Reject;
	}

	public void setReject(String reject) {
		Reject = reject;
	}


}
