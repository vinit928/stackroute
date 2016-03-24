package com.wipro.rll.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVS_TBL_Result")
public class EVS_TBL_Result_Class {

	@Id
	@Column(name = "SerialNo")
	int SerialNo;
	@Column(name = "candidateID")
	String candidateID;
	@Column(name = "electionID")
	String electionID;
	@Column(name = "votecount")
	int votecount;

	public int getSerialNo() {
		return SerialNo;
	}

	public void setSerialNo(int serialNo) {
		SerialNo = serialNo;
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

	public int getVotecount() {
		return votecount;
	}

	public void setVotecount(int votecount) {
		this.votecount = votecount;
	}

}
