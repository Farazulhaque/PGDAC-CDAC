package com.medibox.admin.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medibox.admin.model.ManufactureMaster;

import com.medibox.admin.reprository.ManufactureMasterReprository;
import com.medibox.admin.service.ManufactureMasterService;

@Service
public class ManufactureMasterImplemention implements ManufactureMasterService {

	@Autowired
	private ManufactureMasterReprository manufactureMasterRepo;

	@Override
	public ManufactureMaster addManufactureMaster(ManufactureMaster manufMaster) {
		// TODO Auto-generated method stub
		return manufactureMasterRepo.save(manufMaster);
	}

	@Override
	public void deleteManufacture(ManufactureMaster manufMaster) {
		if (manufMaster != null) {
			manufactureMasterRepo.delete(manufMaster);
		}
	}

	@Override
	public void editManufacture(ManufactureMaster manufMaster) {
		if (manufMaster != null) {
			manufactureMasterRepo.save(manufMaster);
		}
	}

	@Override
	public ManufactureMaster findByManufactureId(Integer manufactureId) {
		if (manufactureId != null) {
			return manufactureMasterRepo.findByManufactureId(manufactureId);
		}
		return null;
	}

	@Override
	public List<ManufactureMaster> listOfManufactureMaster() {

		return manufactureMasterRepo.findAll();
	}

}
