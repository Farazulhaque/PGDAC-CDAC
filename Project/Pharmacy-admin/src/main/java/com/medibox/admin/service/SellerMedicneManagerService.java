package com.medibox.admin.service;

import java.util.List;
import com.medibox.admin.model.SellerMedicneManager;

public interface SellerMedicneManagerService {

	SellerMedicneManager addSellerMedicneManager(SellerMedicneManager sellerMedicneManager);

	List<SellerMedicneManager> listOfSellerMedicneManager();
	
	SellerMedicneManager findBySellerMedicneManagerId(Integer SellerMediManagerId);
	
	void deleteSellerMedicneManager(SellerMedicneManager sellerMedicneManager);

	void editSellerMedicneManager(SellerMedicneManager sellerMedicneManager);
	
	List<SellerMedicneManager> findBySellerId(Integer sellerId);
	
	List<SellerMedicneManager> findByMedicneId(Integer sellerId);
	
	SellerMedicneManager findMediMgrIDWithSellerId(Integer mMid,Integer sId );
	
	SellerMedicneManager getSellerMedicineData(int sid, int mid);

	SellerMedicneManager findManagerByMedicineIdAndSellerIdForQuantityUpdate(int parseInt, Integer sId);
}
