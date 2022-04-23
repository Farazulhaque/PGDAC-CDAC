package com.medibox.admin.reprository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medibox.admin.model.SellerMedicneManager;

public interface SellerMedicneManagerReporository extends JpaRepository<SellerMedicneManager, Integer> {

	
	@Query("select u from SellerMedicneManager u where u.sellerMediManagerId=?1")
	SellerMedicneManager findBySellerMedicneManager(Integer sellerMediManagerId);

	
	@Query("select u from SellerMedicneManager u where u.seller.sellerId=?1")
	List<SellerMedicneManager> findBySellerId(Integer sellerId);


	@Query("select u from SellerMedicneManager u where u.medicineMaster.medicineId=?1")
	List<SellerMedicneManager> findByMedicneId(Integer medicneId);

	
	@Query("select u from SellerMedicneManager u where u.medicineMaster.medicineId=?1 and u.seller.sellerId=?2")
	SellerMedicneManager findMedicineIdWithSellerId(int mediId, int sellerId);

	@Query("select u from SellerMedicneManager u where u.sellerMediManagerId=?1 and u.seller.sellerId=?2")
	SellerMedicneManager findMediMgrIDWithSellerId(Integer mMid, Integer sId);

	@Query("select s from SellerMedicneManager s where s.seller.sellerId=?1")
	List<SellerMedicneManager> findSellerByPincode(Integer pincode);
	
	
	@Query("select sm from SellerMedicneManager sm where sm.seller.sellerId=?1 and sm.medicineMaster.medicineId=?2")
	SellerMedicneManager getSellerMedicineData(int sid, int mid);
		
	

}
