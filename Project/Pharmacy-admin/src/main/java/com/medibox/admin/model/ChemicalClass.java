package com.medibox.admin.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class ChemicalClass {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int chemicalId;

	@Column(nullable = false)
	private String chemicalName;

	@OneToMany(mappedBy = "chemicalClass", cascade = CascadeType.ALL)
	private List<MedicineMaster> medicineMaster;

	public List<MedicineMaster> getMedicineMaster() {
		return medicineMaster;
	}

	public void setMedicineMaster(List<MedicineMaster> medicineMaster) {
		this.medicineMaster = medicineMaster;
	}

	public int getChemicalId() {
		return chemicalId;
	}

	public void setChemicalId(int chemicalId) {
		this.chemicalId = chemicalId;
	}

	public String getChemicalName() {
		return chemicalName;
	}

	public void setChemicalName(String chemicalName) {
		this.chemicalName = chemicalName;
	}

	@Override
	public String toString() {
		return "ChemicalClass [chemicalId=" + chemicalId + ", chemicalName=" + chemicalName + ", medicineMaster="
				+ medicineMaster + "]";
	}

}