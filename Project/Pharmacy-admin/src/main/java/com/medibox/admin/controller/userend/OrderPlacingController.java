package com.medibox.admin.controller.userend;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medibox.admin.model.OrderMaster;
import com.medibox.admin.model.User;

@Controller
public class OrderPlacingController {

	@GetMapping("placeOrder")
	public String placeOrder(@RequestParam("uAId") Integer uAId, @RequestParam("sId") Integer sId,
			@RequestParam("mId") String mIds, @RequestParam("mQty") String mQtys,
			@RequestParam("mDiscount") String mDiscounts, Model model, HttpServletRequest request) {
		System.out.println(uAId);
		System.out.println(sId);
		mIds = mIds.substring(0, mIds.length() - 1);
		mQtys = mQtys.substring(0, mQtys.length() - 1);
		mDiscounts = mDiscounts.substring(0, mDiscounts.length() - 1);
		String[] midStrings = mIds.split("-");
		String[] mQtyStrings = mQtys.split("-");
		String[] mDiscountStrings = mDiscounts.split("-");
		for (int i = 0; i < midStrings.length; i++) {
			System.out.println("mid " + midStrings[i]);
		}
		for (int i = 0; i < mQtyStrings.length; i++) {
			System.out.println("mQty " + mQtyStrings[i]);
		}
		for (int i = 0; i < mDiscountStrings.length; i++) {
			System.out.println("mdiscount " + mDiscountStrings[i]);
		}
		OrderMaster orderMaster = new OrderMaster();

		Date date = new Date();
		orderMaster.setOrderDate(date.toLocaleString());

		date.setDate(date.getDate() + 1);
		orderMaster.setShipingDate(date.toLocaleString());

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("logedInUser");
		if (user != null) {

			return "users/Checkout";
		}
		return "redirect:/userloginpage";
	}
}
