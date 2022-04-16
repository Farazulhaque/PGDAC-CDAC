package com.medibox.admin.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medibox.admin.model.ChemicalClass;
import com.medibox.admin.reprository.ChemicalClassReprository;
import com.medibox.admin.service.ChemicalClassService;

@Service
public class ChemicalClassImplemention implements ChemicalClassService {

	@Autowired
	private ChemicalClassReprository chemicalClassReprositoryRepo;

	@Override
	public ChemicalClass addChemicalClass(ChemicalClass cClass) {
		// TODO Auto-generated method stub
		return chemicalClassReprositoryRepo.save(cClass);
	}

	@Override
	public ChemicalClass findByChemicalClassId(Integer ChemicalClassId) {
		if (ChemicalClassId != null) {
			return chemicalClassReprositoryRepo.findChemicalClassById(ChemicalClassId);
		}
		return null;
	}

	@Override
	public void deleteChemicalClass(ChemicalClass cClass) {
		if (cClass != null) {
			chemicalClassReprositoryRepo.delete(cClass);
			;
		}

	}

	@Override
	public void editChemicalClass(ChemicalClass cClass) {
		if (cClass != null) {
			chemicalClassReprositoryRepo.save(cClass);
		}

	}

	@Override
	public List<ChemicalClass> listOfChemicalClass() {

		return chemicalClassReprositoryRepo.findAll();
	}

}
