package com.medibox.admin.service;

import java.util.List;

import com.medibox.admin.model.ChemicalClass;
import com.medibox.admin.model.ManufactureMaster;

public interface ChemicalClassService {
	
	
	ChemicalClass addChemicalClass(ChemicalClass cClass);

	List<ChemicalClass> listOfChemicalClass();
	
	
	
	ChemicalClass findByChemicalClassId(Integer ChemicalClassId);
	
	

	void deleteChemicalClass(ChemicalClass cClass);

	void editChemicalClass(ChemicalClass cClass);
	
}
