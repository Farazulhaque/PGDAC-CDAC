package com.medibox.admin.controller.userend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medibox.admin.model.MedicineMaster;
import com.medibox.admin.model.OrderDetails;
import com.medibox.admin.model.OrderMaster;
import com.medibox.admin.model.OrderStatus;
import com.medibox.admin.model.SellerMedicneManager;
import com.medibox.admin.model.User;
import com.medibox.admin.reprository.OrderStatusRepository;
import com.medibox.admin.service.MedicineMasterService;
import com.medibox.admin.service.OrderDetailsService;
import com.medibox.admin.service.OrderMasterService;
import com.medibox.admin.service.OrderStatusService;
import com.medibox.admin.service.SellerMedicneManagerService;
import com.medibox.admin.service.SellerService;
import com.medibox.admin.service.UserAddressService;

@Controller
public class OrderPlacingController {

	@Autowired
	SellerMedicneManagerService sellerMedicneManagerService;

	@Autowired
	MedicineMasterService medicineMasterService;

	@Autowired
	UserAddressService userAddressService;

	@Autowired
	SellerService sellerService;

	@Autowired
	OrderMasterService orderMasterService;

	@Autowired
	OrderStatusService orderStatusService;

	@Autowired
	OrderDetailsService orderDetailsService;

	@GetMapping("placeOrder")
	public String placeOrder(@RequestParam("uAId") Integer uAId, @RequestParam("sId") Integer sId,
			@RequestParam("mId") String mIds, @RequestParam("mQty") String mQtys,
			@RequestParam("mDiscount") String mDiscounts, Model model, HttpServletRequest request) {
		// System.out.println(uAId);
		// System.out.println(sId);
		mIds = mIds.substring(0, mIds.length() - 1);
		mQtys = mQtys.substring(0, mQtys.length() - 1);
		mDiscounts = mDiscounts.substring(0, mDiscounts.length() - 1);
		String[] midStrings = mIds.split("-");
		String[] mQtyStrings = mQtys.split("-");
		String[] mDiscountStrings = mDiscounts.split("-");
		// for (int i = 0; i < midStrings.length; i++) {
		// System.out.println("mid " + midStrings[i]);
		// }
		// for (int i = 0; i < mQtyStrings.length; i++) {
		// System.out.println("mQty " + mQtyStrings[i]);
		// }
		// for (int i = 0; i < mDiscountStrings.length; i++) {
		// System.out.println("mdiscount " + mDiscountStrings[i]);
		// }
		float orderAmount = 0;
		float discount = 0;
		float netAmount;
		for (int i = 0; i < midStrings.length; i++) {
			orderAmount += medicineMasterService.getMedicineMrp(Integer.parseInt(midStrings[i]));
			discount += Float.parseFloat(mDiscountStrings[i]);
		}

		netAmount = orderAmount - discount;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("logedInUser");

		if (user != null) {

			OrderMaster orderMaster = new OrderMaster();

			Date date = new Date();
			orderMaster.setOrderDate(date.toLocaleString());

			date.setDate(date.getDate() + 1);
			orderMaster.setShipingDate(date.toLocaleString());

			orderMaster.setPaytmentType("Cash on delivery");

			orderMaster.setOrderAmount(orderAmount);
			orderMaster.setDiscount(discount);
			orderMaster.setNetAmount(netAmount);

			orderMaster.setUser(user);

			orderMaster.setUserAddress(userAddressService.findByUserAddressId(uAId));
			orderMaster.setSeller(sellerService.findBySellerId(sId));
			orderMaster.setStatus(orderStatusService.addOrderStatus(new OrderStatus()));

			ArrayList<OrderDetails> arrOrderDetails = new ArrayList<OrderDetails>();
			for (int i = 0; i < mDiscountStrings.length; i++) {
				OrderDetails orderdetails = new OrderDetails();
				orderdetails.setMedicineDiscount(Float.parseFloat(mDiscountStrings[i]));
				orderdetails.setMedicineQuantity(Integer.parseInt(mQtyStrings[i]));
				orderdetails.setMedicnePrice(medicineMasterService.getMedicineMrp(Integer.parseInt(midStrings[i])));
				orderdetails.setMedicineMaster(medicineMasterService.findByMedicineId(Integer.parseInt(midStrings[i])));
				orderdetails.setOrderMaster(orderMaster);
				arrOrderDetails.add(orderdetails);
				SellerMedicneManager smmm = sellerMedicneManagerService
						.findManagerByMedicineIdAndSellerIdForQuantityUpdate(Integer.parseInt(midStrings[i]), sId);
				System.out.println(Integer.parseInt(mQtyStrings[i]));
				smmm.getQunatity();
				smmm.setQunatity(smmm.getQunatity() - Integer.parseInt(mQtyStrings[i]));
				
				sellerMedicneManagerService.addSellerMedicneManager(smmm);
			}
			orderMaster.setOrderDetails(arrOrderDetails);

			orderMasterService.addOrderMaster(orderMaster);
			model.addAttribute("ordermaster", orderMaster);
			return "redirect:/userOrderPage";
		}
		return "redirect:/userloginpage";
	}
}
