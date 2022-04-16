package com.medibox.admin.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;

@Entity
public class TherapeuticClass {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int therapeuticClassId;

	@Column(unique = true)
	private String tName;

	@Column(length = 1000)
	private String tDescription;

	@OneToMany(mappedBy = "therapeuticClass", cascade = CascadeType.ALL)
	private List<MedicineMaster> medicineMaster;

	public TherapeuticClass() {
		this.therapeuticClassId = therapeuticClassId;
		this.tName = tName;
		this.tDescription = tDescription;
	}

	public TherapeuticClass(int therapeuticClassId, String tName, String tDescription) {
		this.therapeuticClassId = therapeuticClassId;
		this.tName = tName;
		this.tDescription = tDescription;
	}

	public int getTherapeuticClassId() {
		return therapeuticClassId;
	}

	public void setTherapeuticClassId(int therapeuticClassId) {
		this.therapeuticClassId = therapeuticClassId;
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

	public List<MedicineMaster> getMedicineMaster() {
		return medicineMaster;
	}

	public void setMedicineMaster(List<MedicineMaster> medicineMaster) {
		this.medicineMaster = medicineMaster;
	}

}