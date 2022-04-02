package com.cdac.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class MedicineMaster {

	@Id
	@OneToMany
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int medicineId;

	@Column(nullable = false)
	private String medicineName;

	@Column(columnDefinition = "integer default 0")
	private int prescription;

	@Column(nullable = false)
	private String typeOfSell;

	@OneToOne(targetEntity = ManufacturerClass.class, cascade = CascadeType.ALL)
	private ManufacturerClass manufactureId;

	@Column(nullable = false)
	private String salt;

	@Column(nullable = false)
	private float mrp;

	@Column(nullable = false)
	private String uses;

	@Column(nullable = false)
	private String alternateMedicines;

	@Column(nullable = false)
	private String sideEffects;

	@Column(nullable = false)
	private String howToUse;

	@OneToOne(targetEntity = ChemicalClass.class, cascade = CascadeType.ALL)
	private ChemicalClass chemicalClassId;

	@Column(nullable = false)
	private String habitForming;

	@OneToOne(targetEntity = TherapeuticClass.class, cascade = CascadeType.ALL)
	private TherapeuticClass theraputicClassId;

	@Column(nullable = false)
	private String actionClass;

	private String medicineUrl1;

	private String medicineUrl2;

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getPrescription() {
		return prescription;
	}

	public void setPrescription(int prescription) {
		this.prescription = prescription;
	}

	public String getTypeOfSell() {
		return typeOfSell;
	}

	public void setTypeOfSell(String typeOfSell) {
		this.typeOfSell = typeOfSell;
	}

	public ManufacturerClass getManufactureId() {
		return manufactureId;
	}

	public void setManufactureId(ManufacturerClass manufactureId) {
		this.manufactureId = manufactureId;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public float getMrp() {
		return mrp;
	}

	public void setMrp(float mrp) {
		this.mrp = mrp;
	}

	public String getUses() {
		return uses;
	}

	public void setUses(String uses) {
		this.uses = uses;
	}

	public String getAlternateMedicines() {
		return alternateMedicines;
	}

	public void setAlternateMedicines(String alternateMedicines) {
		this.alternateMedicines = alternateMedicines;
	}

	public String getSideEffects() {
		return sideEffects;
	}

	public void setSideEffects(String sideEffects) {
		this.sideEffects = sideEffects;
	}

	public String getHowToUse() {
		return howToUse;
	}

	public void setHowToUse(String howToUse) {
		this.howToUse = howToUse;
	}

	public ChemicalClass getChemicalClassId() {
		return chemicalClassId;
	}

	public void setChemicalClassId(ChemicalClass chemicalClassId) {
		this.chemicalClassId = chemicalClassId;
	}

	public String getHabitForming() {
		return habitForming;
	}

	public void setHabitForming(String habitForming) {
		this.habitForming = habitForming;
	}

	public TherapeuticClass getTheraputicClassId() {
		return theraputicClassId;
	}

	public void setTheraputicClassId(TherapeuticClass theraputicClassId) {
		this.theraputicClassId = theraputicClassId;
	}

	public String getActionClass() {
		return actionClass;
	}

	public void setActionClass(String actionClass) {
		this.actionClass = actionClass;
	}

	public String getMedicineUrl1() {
		return medicineUrl1;
	}

	public void setMedicineUrl1(String medicineUrl1) {
		this.medicineUrl1 = medicineUrl1;
	}

	public String getMedicineUrl2() {
		return medicineUrl2;
	}

	public void setMedicineUrl2(String medicineUrl2) {
		this.medicineUrl2 = medicineUrl2;
	}

}
