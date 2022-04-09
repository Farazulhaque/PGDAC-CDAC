package com.cdac.project.service;

import java.util.List;
import com.cdac.project.model.MedicineMaster;

public interface SearchService {

	public List<MedicineMaster> findByMedicineName(String query);

	public MedicineMaster findMedicineById(Integer mid);

	public List<MedicineMaster> findAlternateMedicines(String salt);
}
