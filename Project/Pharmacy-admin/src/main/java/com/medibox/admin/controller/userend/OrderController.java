package com.medibox.admin.controller.userend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medibox.admin.model.OrderStatus;
import com.medibox.admin.model.User;
import com.medibox.admin.service.OrderMasterService;
import com.medibox.admin.service.OrderStatusService;

@Controller
public class OrderController {

	@Autowired
	private OrderMasterService orderMasterService;

	@Autowired
	private OrderStatusService orderStatusService;

	@RequestMapping("/userOrderPage")
	public String Order(Model m, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("logedInUser");
		if (user != null) {
			m.addAttribute("orderlist", orderMasterService.findOrderByUserId(user.getUserId()));
			return "users/orders";
		}
		return "redirect:/userloginpage";
	}

	@PostMapping("/userorderCancel")
	public String cancelOrder(OrderStatus orderStatus, @RequestParam("orderId") Integer orderId, Model m,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("logedInUser");
		if (user != null) {
			orderStatus.setStatusDescription("Cancelled by user");
			orderStatusService.editOrderStatus(orderStatus);
			m.addAttribute("orderlist", orderMasterService.findOrderByUserId(user.getUserId()));
			return "users/orders";
		}
		return "redirect:/userloginpage";
	}

}
