package com.medibox.admin.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class MedicineMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int medicineId;

	@Column(nullable = false)
	private String medicineName;

	@Column
	private int prescription;

	@Column(nullable = false)
	private String typeOfSell;

	@Column(nullable = false, length = 200)
	private String salt;

	@Column(nullable = false)
	private float mrp;

	@Column(nullable = false, length = 1000)
	private String uses;

	@Column(nullable = false, length = 1000)
	private String alternateMedicines;

	@Column(nullable = false, length = 1000)
	private String sideEffects;

	@Column(nullable = false)
	private String howToUse;

	@ManyToOne
	private ChemicalClass chemicalClass;

	@ManyToOne
	private TherapeuticClass therapeuticClass;

	@ManyToOne
	private ManufactureMaster manufacture;

	@Column(nullable = false, length = 1000)
	private String habitForming;

	@Column(nullable = false, length = 1000)
	private String actionClass;

	private String medicineUrl1;

	private String medicineUrl2;

	@OneToMany(mappedBy = "medicineMaster", cascade = CascadeType.ALL)
	private List<SellerMedicneManager> sellerMedicneManager;

	@OneToMany(mappedBy = "medicineMaster", cascade = CascadeType.ALL)
	private List<OrderDetails> orderDetails;

	/////////////////////////////////////////////////////////////////////////////////////////////////

	public int getMedicineId() {
		return medicineId;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public List<SellerMedicneManager> getSellerMedicneManager() { //////////////////
		return sellerMedicneManager;
	}

	public void setSellerMedicneManager(List<SellerMedicneManager> sellerMedicneManager) {
		this.sellerMedicneManager = sellerMedicneManager;
	}

	/////////////////////
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

	public ChemicalClass getChemicalClass() {
		return chemicalClass;
	}

	public void setChemicalClass(ChemicalClass chemicalClass) {
		this.chemicalClass = chemicalClass;
	}

	public TherapeuticClass getTherapeuticClass() {
		return therapeuticClass;
	}

	public void setTherapeuticClass(TherapeuticClass therapeuticClass) {
		this.therapeuticClass = therapeuticClass;
	}

	public ManufactureMaster getManufacture() {
		return manufacture;
	}

	public void setManufacture(ManufactureMaster manufacture) {
		this.manufacture = manufacture;
	}

	public String getHabitForming() {
		return habitForming;
	}

	public void setHabitForming(String habitForming) {
		this.habitForming = habitForming;
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

	@Override
	public String toString() {
		return "MedicineMaster [medicineId=" + medicineId + ", medicineName=" + medicineName + ", prescription="
				+ prescription + ", typeOfSell=" + typeOfSell + ", salt=" + salt + ", mrp=" + mrp + ", uses=" + uses
				+ ", alternateMedicines=" + alternateMedicines + ", sideEffects=" + sideEffects + ", howToUse="
				+ howToUse + ", chemicalClass=" + chemicalClass + ", therapeuticClass=" + therapeuticClass
				+ ", manufacture=" + manufacture + ", habitForming=" + habitForming + ", actionClass=" + actionClass
				+ ", medicineUrl1=" + medicineUrl1 + ", medicineUrl2=" + medicineUrl2 + ", sellerMedicneManager="
				+ sellerMedicneManager + "]";
	}

}
