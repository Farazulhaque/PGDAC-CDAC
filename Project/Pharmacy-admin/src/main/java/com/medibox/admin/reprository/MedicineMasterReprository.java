package com.medibox.admin.reprository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medibox.admin.model.MedicineMaster;

public interface MedicineMasterReprository extends JpaRepository<MedicineMaster, Integer> {

	// void editMedicine(MedicineMaster med);

	@Query("select u from MedicineMaster u where u.medicineId=?1")
	MedicineMaster findByMedicineId(Integer medicineId);

	@Query("select mm from MedicineMaster mm where mm.medicineName like %?1%")
	public List<MedicineMaster> findByMedicineName(String query);

	@Query("select mm.medicineId, mm.medicineName, mm.salt, mm.typeOfSell, mm.mrp from MedicineMaster mm")
	List<MedicineMaster> listOfMedicineNameIdTypeOfsellMrpSalt();

	@Query("Select u from MedicineMaster u")
	public Page<MedicineMaster> findMedicinebyPageable(Pageable pePageable);

	
	@Query("select m.mrp from MedicineMaster m where m.medicineId=?1")
	public float getMedicineMrp(int mid);
	
	
}
//@Query("select mm from MedicineMaster mm where mm.medicineName like %?1%")