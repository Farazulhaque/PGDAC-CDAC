package com.medibox.admin.service;

import java.util.List;

import com.medibox.admin.model.MedicineMaster;

public interface SearchService {
	
	public List<MedicineMaster> findByMedicineName(String query);

	public MedicineMaster findMedicineById(Integer mid);

	public List<MedicineMaster> findAlternateMedicines(String salt);
}
