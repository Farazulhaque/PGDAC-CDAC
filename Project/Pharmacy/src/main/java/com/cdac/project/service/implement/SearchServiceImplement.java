package com.cdac.project.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.project.model.MedicineMaster;
import com.cdac.project.repository.SearchRepository;
import com.cdac.project.service.SearchService;

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
