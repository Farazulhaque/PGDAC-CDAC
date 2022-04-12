package com.medibox.admin.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.medibox.admin.FileUploadUtils;
import com.medibox.admin.model.ChemicalClass;
import com.medibox.admin.model.ManufactureMaster;
import com.medibox.admin.model.MedicineMaster;
import com.medibox.admin.model.TherapeuticClass;
import com.medibox.admin.reprository.TherapeuticClassReprository;
import com.medibox.admin.service.implement.ChemicalClassImplemention;
import com.medibox.admin.service.implement.ManufactureMasterImplemention;
import com.medibox.admin.service.implement.MedicineMasterImplementation;
import com.medibox.admin.service.implement.TherapeuticClassServiceImplemention;

@Controller
public class MedicineMasterController {
	
	
	@Autowired
	private TherapeuticClassServiceImplemention therapeuticClassImp;
	@Autowired
	private ManufactureMasterImplemention manufactureMasterImp;
	@Autowired
	private ChemicalClassImplemention   chemicalClassImp;
	@Autowired
	private MedicineMasterImplementation   medicineMasterImp;
	
	
	
	
	@ModelAttribute
	public void commonDataSendforModal(Model m) {
		m.addAttribute("tclasslist",therapeuticClassImp.listOfTherapeuticClass() );
		m.addAttribute("manuflist", manufactureMasterImp.listOfManufactureMaster() );
		m.addAttribute("chemlist", chemicalClassImp.listOfChemicalClass());
		m.addAttribute("medlist", medicineMasterImp.listOfMedicineMaster());
		
	}
	
	

	
	@RequestMapping("/medicinemaster")
	public String medicinemaster(Model m) {
		System.out.println(" medicineMaster is executed");
		return "admin/medicineMaster";
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////
	
	//addtherapeuticclass in db
	@PostMapping("/addtherapeuticclass")
	public String addTherapeuticClass(TherapeuticClass therapeuticClass) {
		System.out.println(" addtherapeuticclass is executed");
		therapeuticClassImp.addTherapeuticClass(therapeuticClass);
		return "admin/medicineMaster";
	}
	
	// finding thepuritic by  id
	@GetMapping("/edittherapeuticClass")
	public String findTherapeuticClass(@RequestParam("therapeuticClassId")Integer therapeuticClassId,Model m) {
		System.out.println(" finding thepuritic by  id");
		m.addAttribute("editTherapeuticClass", therapeuticClassImp.findByTherapeuticClassId(therapeuticClassId));
		m.addAttribute("update",true);
		return "admin/medicineMaster";
	}
	
	//update theroputic class 
	@PostMapping("/edittherapeutic")
	public String editTherapeuticClass(TherapeuticClass therapeuticClass,Model m) {
		System.out.println(" finding thepuritic by  id");
		if (therapeuticClass != null) {
			therapeuticClassImp.editTherapeuticClass(therapeuticClass);
			m.addAttribute("edit",true);
		}
			m.addAttribute("noedit",true);
		return "admin/medicineMaster";
	}
	
	
	//delete  thepuritic name
	@GetMapping("/deletetherapeuticClass")
	public String deleteTherapeuticClass(@RequestParam("therapeuticClassId")Integer therapeuticClassId,Model m) {
		System.out.println(" delete chemicalName");
		therapeuticClassImp.deleteTherapeuticClass(therapeuticClassImp.findByTherapeuticClassId(therapeuticClassId));
		m.addAttribute("deleteMsg", "Deleted Therapeutic Class Name successfully!!!");
		return "medicineMaster";
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	//adding manufacture class in db
	@PostMapping("/addmanufacture")
	public String addManufacture(ManufactureMaster manufactureMaster) {
		System.out.println(" addmanufacture is executed");
		manufactureMasterImp.addManufactureMaster(manufactureMaster);
		return "medicineMaster";
	}
	
	
	// finding manufacture by  id
		@GetMapping("/editmanufacture")
		public String findManufacture(@RequestParam("manufactureId")Integer manufactureId,Model m) {
			System.out.println(" finding manufacture by  id");
			m.addAttribute("editmanufactureList", manufactureMasterImp.findByManufactureId(manufactureId));
			m.addAttribute("update",true);
			return "medicineMaster";
		}
		
		@PostMapping("/updatemanufacture")
		public String updateManufacture(ManufactureMaster manufactureMaster,Model m) {
			System.out.println(" update updatemanufacture");
			if (manufactureMaster != null) {
				manufactureMasterImp.editManufacture(manufactureMaster);
				m.addAttribute("edit",true);
			}
				m.addAttribute("noedit",true);
			return "admin/medicineMaster";
		}
		
		//delete  manufacture name
		@GetMapping("/deletemanufacture")
		public String deleteManufacture(@RequestParam("manufactureId")Integer manufactureId,Model m) {
			System.out.println(" delete manufacture");
			manufactureMasterImp.deleteManufacture(manufactureMasterImp.findByManufactureId(manufactureId));
			m.addAttribute("deleteMsg", "Deleted Manufacture Name successfully!!!");
			return "admin/medicineMaster";
		}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	//adding chemical class in db
	@PostMapping("/addchemicalclass")
	public String addChemicalClass(ChemicalClass chemicalClass) {
		System.out.println(" addmanufacture is executed");
		chemicalClassImp.addChemicalClass(chemicalClass);
		return "admin/medicineMaster";
	}
	
	// finding Chemical class by  id
	@GetMapping("/editchemicalName")
	public String findChemicalClass(@RequestParam("chemicalId")Integer chemicalId,Model m) {
		System.out.println(" editchemicalName");
		m.addAttribute("editChemicalname", chemicalClassImp.findByChemicalClassId(chemicalId));
		m.addAttribute("update",true);
		return "admin/medicineMaster";
	}
	
	//update Chemical class
	@PostMapping("/updateChemicalClass")
	public String updateChemicalClass(ChemicalClass chemicalClass,Model m) {
		System.out.println(" update Chemical Class");
		if (chemicalClass != null) {
			chemicalClassImp.editChemicalClass(chemicalClass);
			m.addAttribute("edit",true);
		}
			m.addAttribute("noedit",true);
		return "admin/medicineMaster";
	}
	
	//delete  Chemicalclass name
	@GetMapping("/deletechemicalName")
	public String deleteChemicalClass(@RequestParam("chemicalId")Integer chemicalId,Model m) {
		System.out.println(" delete chemicalName");
		chemicalClassImp.deleteChemicalClass(chemicalClassImp.findByChemicalClassId(chemicalId));
		m.addAttribute("deleteMsg", "Deleted chemical Name successfully!!!");
		return "admin/medicineMaster";
	}

	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	//medicine add form opening
	@RequestMapping("/collapseADDMedicineData")
	public String addMedicineform(Model m) {
		System.out.println(" add medicine form is executed");
		m.addAttribute("manuf", manufactureMasterImp.listOfManufactureMaster());
		m.addAttribute("chemlist2", chemicalClassImp.listOfChemicalClass());
		m.addAttribute("therclass", therapeuticClassImp.listOfTherapeuticClass());
		return "admin/medicineMaster";
	}
	
	//adding medicine data in db
	@PostMapping("/addmedicine")
	public String addMedicine(MedicineMaster medi,@RequestParam("image1")MultipartFile multipartFile1,@RequestParam("image1")MultipartFile multipartFile2) throws IOException {
		System.out.println(" add Medicine is executed");
		
		
		if (medi!=null) {
			
			String filename1=StringUtils.cleanPath(multipartFile1.getOriginalFilename());
			String filename2=StringUtils.cleanPath(multipartFile2.getOriginalFilename());
			
			
			//String uploadDir1="src/main/resources/static/documents/seller";
			//String uploadDir2="src/main/resources/static/Dbmedicineimage";
			String uploadDir1="src/main/webapp/uplodedDocImg/DbmediceneImage";
			String uploadDir2="src/main/webapp/uplodedDocImg/DbmediceneImage2";
			
			FileUploadUtils.saveFile(uploadDir1, filename1, multipartFile1);
			FileUploadUtils.saveFile(uploadDir2, filename2, multipartFile2);
			medi.setMedicineUrl1("/uplodedDocImg/DbmediceneImage/"+filename1);
			medi.setMedicineUrl2("/uplodedDocImg/DbmediceneImage2/"+filename2);
			
			medicineMasterImp.saveMedicine(medi);
		}
			return "admin/medicineMaster";
	}
	
	    // finding manufacture by  id
		@GetMapping("/editmedicine")
		public String findMedicine(@RequestParam("medicineId")Integer medicineId,Model m) {
			System.out.println(" finding medicine by  id");
			m.addAttribute("editmedicine", medicineMasterImp.findByMedicineId(medicineId));
			m.addAttribute("editform", true);
			m.addAttribute("update",true);
			return "admin/medicineMaster";
		}
			
		//update Medicine  
		@PostMapping("/updatemedicine")
		public String updateMedicine(MedicineMaster medi,Model m) {
			System.out.println(" edit Medicine");
			if (medi != null) {
				medicineMasterImp.editMedicine(medi);
				m.addAttribute("edit",true);
			}
				m.addAttribute("noedit",true);
			return "admin/medicineMaster";
		}
		
	//delete Medicine  name
		@GetMapping("/deletemedicine")
		public String deleteMedicine(@RequestParam("medicineId")Integer medicineId,Model m) {
			System.out.println(" delete manufacture");
			medicineMasterImp.deleteMedicine(medicineMasterImp.findByMedicineId(medicineId));
			m.addAttribute("deleteMsg", "Deleted Medicine  successfully!!!");
			return "admin/medicineMaster";
		}
		
}
