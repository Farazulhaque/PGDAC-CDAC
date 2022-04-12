package com.medibox.admin.reprository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medibox.admin.model.TherapeuticClass;

public interface TherapeuticClassReprository extends JpaRepository<TherapeuticClass, Integer> {

	@Query("select u from TherapeuticClass u where u.therapeuticClassId=?1")
	TherapeuticClass findTherapeuticClassById(Integer therapeuticClassId);

	
	//void editTherapeuticClass(TherapeuticClass tclass);

	
}
