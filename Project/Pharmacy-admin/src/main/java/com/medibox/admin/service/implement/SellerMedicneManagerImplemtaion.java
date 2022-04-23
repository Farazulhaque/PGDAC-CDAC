package com.medibox.admin.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medibox.admin.model.SellerMedicneManager;
import com.medibox.admin.reprository.SellerMedicneManagerReporository;
import com.medibox.admin.service.SellerMedicneManagerService;
@Service
public class SellerMedicneManagerImplemtaion implements SellerMedicneManagerService {

	@Autowired
	private SellerMedicneManagerReporository sellerMedicneManagerReporository;
	private SellerMedicneManager medicineAndSellerfound;
	
	@Override
	public SellerMedicneManager addSellerMedicneManager(SellerMedicneManager sellerMedicneManager) {
		medicineAndSellerfound = findMedicineWithSeller(sellerMedicneManager);
		
		if(medicineAndSellerfound!=null) {
			medicineAndSellerfound.setQunatity(sellerMedicneManager.getQunatity());
			medicineAndSellerfound.setSellerDiscount(sellerMedicneManager.getSellerDiscount());
			return sellerMedicneManagerReporository.save(medicineAndSellerfound);
		}
		return sellerMedicneManagerReporository.save(sellerMedicneManager);
	}

	
	@Override
	public List<SellerMedicneManager> listOfSellerMedicneManager() {
		return sellerMedicneManagerReporository.findAll();
	}

	@Override
	public SellerMedicneManager findBySellerMedicneManagerId(Integer SellerMediManagerId) {
		
		return sellerMedicneManagerReporository.findBySellerMedicneManager(SellerMediManagerId);
	}

	
	
	
	@Override
	public void deleteSellerMedicneManager(SellerMedicneManager sellerMedicneManager) {
		sellerMedicneManagerReporository.delete(sellerMedicneManager);
	}

	
	
	
	
	
	@Override
	public void editSellerMedicneManager(SellerMedicneManager sellerMedicneManager) {
		
		sellerMedicneManagerReporository.save(sellerMedicneManager);
		
	}

	@Override
	public List<SellerMedicneManager> findBySellerId(Integer sellerId) {
		
		return sellerMedicneManagerReporository.findBySellerId(sellerId);
	}

	
	@Override
	public List<SellerMedicneManager> findByMedicneId(Integer MedicneId) {
		// TODO Auto-generated method stub
		return sellerMedicneManagerReporository.findByMedicneId(MedicneId);
	}

	
	
	
	
	//finding detalis of a single medicine where sellerId and medicineId matched
	public SellerMedicneManager findMedicineWithSeller(SellerMedicneManager sellerMedicneManager) {
		int mediId=sellerMedicneManager.getMedicineMaster().getMedicineId();
		int	sellerId=sellerMedicneManager.getSeller().getSellerId();
		
		return sellerMedicneManagerReporository.findMedicineIdWithSellerId(mediId, sellerId);
	}
	
	
	@Override
	public SellerMedicneManager findMediMgrIDWithSellerId(Integer mMid,Integer sId ) {
		return sellerMedicneManagerReporository.findMediMgrIDWithSellerId(mMid, sId);
	}


	@Override
	public SellerMedicneManager getSellerMedicineData(int sid, int mid) {
		// TODO Auto-generated method stub
		return sellerMedicneManagerReporository.getSellerMedicineData(sid, mid);
	}


	@Override
	public SellerMedicneManager findManagerByMedicineIdAndSellerIdForQuantityUpdate(int mediId, Integer sId) {
		
		return sellerMedicneManagerReporository.findMedicineIdWithSellerId(mediId,sId);
	}


}
