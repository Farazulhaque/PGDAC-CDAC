package com.medibox.admin.service;

import java.util.List;

import com.medibox.admin.model.ManufactureMaster;

public interface ManufactureMasterService {

	
	ManufactureMaster addManufactureMaster(ManufactureMaster manufMaster);
	
	List<ManufactureMaster> listOfManufactureMaster();
	
	ManufactureMaster findByManufactureId(Integer manufactureId);

	void deleteManufacture(ManufactureMaster manufMaster);

	void editManufacture(ManufactureMaster manufMaster);
}
