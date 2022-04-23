package com.medibox.admin.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.medibox.admin.model.MedicineMaster;
import com.medibox.admin.reprository.MedicineMasterReprository;
import com.medibox.admin.service.MedicineMasterService;

@Service
public class MedicineMasterImplementation implements MedicineMasterService {

	@Autowired
	private MedicineMasterReprository medicineMasterRepro;

	@Override
	public MedicineMaster saveMedicine(MedicineMaster med) {

		return medicineMasterRepro.save(med);
	}

	@Override
	public MedicineMaster findByMedicineId(Integer medicineId) {

		if (medicineId != null)
			return medicineMasterRepro.findByMedicineId(medicineId);
		return null;
	}

	@Override
	public void deleteMedicine(MedicineMaster med) {
		if (med != null) {
			medicineMasterRepro.delete(med);
		}
	}

	@Override
	public void editMedicine(MedicineMaster med) {
		if (med != null) {
			medicineMasterRepro.save(med);
		}
	}

	@Override
	public List<MedicineMaster> listOfMedicineMaster() {

		return medicineMasterRepro.findAll();
	}

	@Override
	public List<MedicineMaster> listOfMedicineNameId() {

		return medicineMasterRepro.listOfMedicineNameIdTypeOfsellMrpSalt();
	}

	@Override
	public List<MedicineMaster> findMedicineByNameLike(String str) {

		return medicineMasterRepro.findByMedicineName(str);
	}

	@Override
	public Page<MedicineMaster> listOfMedicineByPage(Pageable pageable) {

		return medicineMasterRepro.findMedicinebyPageable(pageable);
	}

	@Override
	public float getMedicineMrp(int mid) {
		
		return medicineMasterRepro.getMedicineMrp(mid);
	}

}
