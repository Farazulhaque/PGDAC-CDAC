package com.medibox.admin.reprository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medibox.admin.model.ChemicalClass;

public interface ChemicalClassReprository extends JpaRepository<ChemicalClass, Integer> {

	@Query("select u from ChemicalClass u where u.chemicalId=?1")
	ChemicalClass findChemicalClassById(Integer chemicalId );
	

	
	
//	@Modifying
//	@Query("update User u set u.chemicalName =  where u.lastLoginDate < :cClass")
//	void editContact(@Param("cClass") ChemicalClass cClass);
}
