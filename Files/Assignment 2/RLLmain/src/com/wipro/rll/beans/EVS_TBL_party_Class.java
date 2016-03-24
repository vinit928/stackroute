package com.wipro.rll.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVS_TBL_party")
public class EVS_TBL_party_Class {

	@Id
	@Column(name = "party_id")
	String party_id;

	@Column(name = "name")
	String name;
	
	@Column(name = "leader")
	String leader;
	
	@Column(name = "image")
	byte [] image;

	
	public String getParty_id() {
		return party_id;
	}

	public void setParty_id(String party_id) {
		this.party_id = party_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	
}
