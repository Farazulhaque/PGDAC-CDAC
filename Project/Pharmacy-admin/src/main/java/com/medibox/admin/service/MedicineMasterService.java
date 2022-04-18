package com.medibox.admin.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.medibox.admin.model.ChemicalClass;
import com.medibox.admin.model.MedicineMaster;
import com.medibox.admin.model.TherapeuticClass;

public interface MedicineMasterService {

	List<MedicineMaster> listOfMedicineMaster();

	MedicineMaster saveMedicine(MedicineMaster med);

	MedicineMaster findByMedicineId(Integer medicineId);

	void deleteMedicine(MedicineMaster med);

	void editMedicine(MedicineMaster med);

	List<MedicineMaster> findMedicineByNameLike(String str);

	List<MedicineMaster> listOfMedicineNameId();

	Page<MedicineMaster> listOfMedicineByPage(Pageable pageable);

	float getMedicineMrp(int mid);
}
