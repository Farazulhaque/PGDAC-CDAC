package com.medibox.admin.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medibox.admin.model.MedicineMaster;
import com.medibox.admin.reprository.SearchRepository;
import com.medibox.admin.service.SearchService;

@Service
public class SearchServiceImplement implements SearchService {

	@Autowired
	SearchRepository searchRepository;

	@Override
	public List<MedicineMaster> findByMedicineName(String query) {
		// TODO Auto-generated method stub
		return searchRepository.findByMedicineName(query);
	}

	@Override
	public MedicineMaster findMedicineById(Integer mid) {
		// TODO Auto-generated method stub
		return searchRepository.findMedicineById(mid);
	}

	@Override
	public List<MedicineMaster> findAlternateMedicines(String salt) {
		// TODO Auto-generated method stub
		return searchRepository.findAlternateMedicines(salt);
	}

}

