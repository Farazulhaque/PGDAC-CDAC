package com.medibox.admin.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ManufactureMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int manufactureId;

	@Column(unique = true)
	private String manufactureName;

	@Column(length = 1000)
	private String mDescription;

	@Column(columnDefinition = "integer default 1")
	private int isActive;

	@OneToMany(mappedBy = "manufacture", cascade = CascadeType.ALL)
	private List<MedicineMaster> medicineMaster;

	public int getManufactureId() {
		return manufactureId;
	}

	public void setManufactureId(int manufactureId) {
		this.manufactureId = manufactureId;
	}

	public String getManufactureName() {
		return manufactureName;
	}

	public void setManufactureName(String manufactureName) {
		this.manufactureName = manufactureName;
	}

	public String getmDescription() {
		return mDescription;
	}

	public void setmDescription(String mDescription) {
		this.mDescription = mDescription;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public List<MedicineMaster> getMedicineMaster() {
		return medicineMaster;
	}

	public void setMedicineMaster(List<MedicineMaster> medicineMaster) {
		this.medicineMaster = medicineMaster;
	}
}
