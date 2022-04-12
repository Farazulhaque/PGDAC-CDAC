package com.medibox.admin.service;

import java.util.List;

import com.medibox.admin.model.ManufactureMaster;
import com.medibox.admin.model.TherapeuticClass;

public interface TherapeuticClassService {

	TherapeuticClass addTherapeuticClass(TherapeuticClass tclass);
	
	List<TherapeuticClass> listOfTherapeuticClass();
	
	
	
	TherapeuticClass findByTherapeuticClassId(Integer therapeuticClassId);


	void deleteTherapeuticClass(TherapeuticClass tclass);

	void editTherapeuticClass(TherapeuticClass tclass);
}
