package com.medibox.admin.controller.seller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medibox.admin.model.OrderMaster;
import com.medibox.admin.model.OrderStatus;
import com.medibox.admin.model.Seller;
import com.medibox.admin.service.OrderMasterService;
import com.medibox.admin.service.OrderStatusService;

@Controller
public class SellerOrderController {

	@Autowired
	private OrderMasterService orderMasterService;

	@Autowired
	private OrderStatusService orderStatusService;

	@RequestMapping("/sellerOrderPage")
	public String Orderspage(Model m, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Seller seller = (Seller) session.getAttribute("logedinSeller");
		if (seller != null) {
			m.addAttribute("totalOrders", orderMasterService.findOrderBySellerId(seller.getSellerId()));
			return "seller/Order";
		}
		return "redirect:/sellerlogin";
	}

	@GetMapping("/sellerOrderDetails")
	public String UserDetails(@RequestParam("orderId") Integer orderId, Model m, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Seller seller = (Seller) session.getAttribute("logedinSeller");
		OrderMaster orderdetails = orderMasterService.findByOrderMasterId(orderId);
		// Handling null value
		if (orderdetails != null) {
			// matching seller id with user id and checking login user
			if ((seller != null) && ((orderdetails.getSeller().getSellerId()) == (seller.getSellerId()))) {
				m.addAttribute("OrdersDetails", orderdetails);
				return "seller/OrderDetails";
			}
			return "redirect:/sellerlogin";
		}
		return "redirect:/sellerlogin";
	}

	// updating orderstatus
	@PostMapping("/sellerOrderUpdateStatus")
	public String orderStatusUpdate(OrderStatus orderStatus, @RequestParam("orderId") Integer orderId, Model m,
			HttpServletRequest request) {

		HttpSession session = request.getSession();
		Seller seller = (Seller) session.getAttribute("logedinSeller");
		OrderMaster orderdetails = orderMasterService.findByOrderMasterId(orderId);
		// Handling null value
		if (orderdetails != null) {
			// matching seller id with user id and checking login user
			if ((seller != null) && ((orderdetails.getSeller().getSellerId()) == (seller.getSellerId()))) {
				orderStatusService.editOrderStatus(orderStatus);
				m.addAttribute("OrdersDetails", orderMasterService.findByOrderMasterId(orderId));
				return "seller/OrderDetails";
			}
			return "redirect:/sellerlogin";
		}
		return "redirect:/sellerlogin";
	}

	// canceling order

	@PostMapping("/sellerorderCancel")
	public String cancelOrder(OrderStatus orderStatus, @RequestParam("orderId") Integer orderId, Model m,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		Seller seller = (Seller) session.getAttribute("logedinSeller");
		OrderMaster orderdetails = orderMasterService.findByOrderMasterId(orderId);
		// Handling null value
		if (orderdetails != null) {
			// matching seller id with user id and checking login user
			if ((seller != null) && ((orderdetails.getSeller().getSellerId()) == (seller.getSellerId()))) {
				orderStatus.setStatusDescription("Cancelled by seller");
				orderStatusService.editOrderStatus(orderStatus);
				m.addAttribute("OrdersDetails", orderMasterService.findByOrderMasterId(orderId));
				return "seller/OrderDetails";
			}
			return "redirect:/sellerlogin";
		}
		return "redirect:/sellerlogin";
	}

	@RequestMapping("/sellerpendingOrderDetails")
	public String cancelOrder(Model m, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Seller seller = (Seller) session.getAttribute("logedinSeller");
		if (seller != null) {
			m.addAttribute("totalOrders", orderMasterService.findOrderBySellerPendingOrder(seller.getSellerId()));
			return "seller/Order";
		}
		return "redirect:/sellerlogin";
	}

}
