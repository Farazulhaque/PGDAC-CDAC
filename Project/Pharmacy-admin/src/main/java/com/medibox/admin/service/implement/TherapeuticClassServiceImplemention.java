package com.medibox.admin.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medibox.admin.model.TherapeuticClass;
import com.medibox.admin.reprository.TherapeuticClassReprository;
import com.medibox.admin.service.TherapeuticClassService;

@Service
public class TherapeuticClassServiceImplemention  implements TherapeuticClassService{
	
	@Autowired
	TherapeuticClassReprository therapeuticClassRepo;

	@Override
	public TherapeuticClass addTherapeuticClass(TherapeuticClass tclass) {
		// TODO Auto-generated method stub
		return therapeuticClassRepo.save(tclass);
	}

	@Override
	public List<TherapeuticClass> listOfTherapeuticClass() {
		
			return therapeuticClassRepo.findAll();
		
	}

	@Override
	public TherapeuticClass findByTherapeuticClassId(Integer therapeuticClassId) {
		if( therapeuticClassId!=null) {
		    return therapeuticClassRepo.findTherapeuticClassById(therapeuticClassId);
		}
		return null;
	}

	@Override
	public void deleteTherapeuticClass(TherapeuticClass tclass) {
		if( tclass!=null) {
		     therapeuticClassRepo.delete(tclass);
		}
	}

	@Override
	public void editTherapeuticClass(TherapeuticClass tclass) {
		if( tclass!=null) {
		  therapeuticClassRepo.save(tclass);
		}
	}
	

}
