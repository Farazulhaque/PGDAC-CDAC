package com.medibox.admin.reprository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medibox.admin.model.ManufactureMaster;

public interface ManufactureMasterReprository extends JpaRepository<ManufactureMaster, Integer> {

	
	@Query("select u from ManufactureMaster u where u.manufactureId=?1")
	ManufactureMaster findByManufactureId(Integer manufactureId);


	//	void editManufacture(ManufactureMaster manufMaster);


	//	@Query("select u.manufactureId u.manufactureName from ManufactureMaster u")
	//	ManufactureMaster findByAll();
	 
}
