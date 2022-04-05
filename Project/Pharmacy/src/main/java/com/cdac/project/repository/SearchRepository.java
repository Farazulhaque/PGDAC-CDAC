package com.cdac.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cdac.project.model.MedicineMaster;

public interface SearchRepository extends JpaRepository<MedicineMaster, Integer> {

	@Query("select mm from MedicineMaster mm where mm.medicineName like %?1%")
	public List<MedicineMaster> findByMedicineName(String query);

	@Query("select mm from MedicineMaster mm where mm.medicineId=?1")
	public MedicineMaster findMedicineById(Integer mid);

	@Query("select mm from MedicineMaster mm where mm.salt = ?1")
	public List<MedicineMaster> findAlternateMedicines(String salt);
	
}
