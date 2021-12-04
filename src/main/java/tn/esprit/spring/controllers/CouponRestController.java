package tn.esprit.spring.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Service.ICouponService;
import tn.esprit.spring.entity.Coupon;

@RestController
@RequestMapping("/coupon")
public class CouponRestController {
	@Autowired
	ICouponService couponService;
	
	
	// http://localhost:8089/SpringMVC/coupon/retrieve-all-coupons
		@GetMapping("/retrieve-all-coupons")
		@ResponseBody
			public List<Coupon> getCoupons() {
				List<Coupon> listCoupons = couponService.retrieveAllCoupon();
				return listCoupons;
			}

		//http://localhost:8089/SpringMVC/coupon/retrieve-coupon/14
		@GetMapping("/retrieve-coupon/{coupon-id}")
		@ResponseBody
		public Coupon retrieveCoupon(@PathVariable("coupon-id") Long couponId) {
		return couponService.retrieveCoupon(couponId);
		}
		//http://localhost:8089/SpringMVC/coupon/add-coupon
		@PostMapping("/add-coupon")
		@ResponseBody
		public Coupon addCoupon(@RequestBody Coupon c) throws ParseException
		{
			Coupon coupon = couponService.addCoupon(c);
			return coupon;
		}

		//http://localhost:8089/SpringMVC/coupon/remove-coupon/{coupon-id}
		@DeleteMapping("remove-coupon/{coupon-id}")
		@ResponseBody
		public void removeCoupon(@PathVariable("coupon-id") Long couponId) {
			couponService.deleteCoupon(couponId);
		}

		//http://localhost:8089/SpringMVC/coupon/modify-coupon
		@PutMapping("/modify-coupon")
		@ResponseBody
		public Coupon modifyCoupon(@RequestBody Coupon coupon) {
		return couponService.updateCoupon(coupon);
		}

}
