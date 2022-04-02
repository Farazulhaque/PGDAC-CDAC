package com.cdac.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class TherapeuticClass {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private int therapeuticClassId;

	@Column(nullable = false)
	private String tName;

	private String tDescription;

	public int getTherarpeuticClassId() {
		return therapeuticClassId;
	}

	public void setTherarpeuticClassId(int therarpeuticClassId) {
		this.therapeuticClassId = therarpeuticClassId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettDescription() {
		return tDescription;
	}

	public void settDescription(String tDescription) {
		this.tDescription = tDescription;
	}
}
