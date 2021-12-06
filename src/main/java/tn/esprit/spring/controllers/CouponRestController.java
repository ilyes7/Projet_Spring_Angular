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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.Service.ICouponService;
import tn.esprit.spring.entity.Coupon;

@RestController
@Api(tags = "Coupon management")
@RequestMapping("/coupon")
public class CouponRestController {
	@Autowired
	ICouponService couponService;
	
	
	// http://localhost:8089/SpringMVC/coupon/retrieve-all-coupons
		@ApiOperation(value = "Récupérer la liste des coupons")
		@GetMapping("/retrieve-all-coupons")
		@ResponseBody
			public List<Coupon> getCoupons() {
				List<Coupon> listCoupons = couponService.retrieveAllCoupon();
				return listCoupons;
			}

		//http://localhost:8089/SpringMVC/coupon/retrieve-coupon/14
		@ApiOperation(value = "afficher un coupon")
		@GetMapping("/retrieve-coupon/{coupon-id}")
		@ResponseBody
		public Coupon retrieveCoupon(@PathVariable("coupon-id") Long couponId) {
		return couponService.retrieveCoupon(couponId);
		}
		//http://localhost:8089/SpringMVC/coupon/add-coupon
		@ApiOperation(value = "ajouter un coupon")
		@PostMapping("/add-coupon")
		@ResponseBody
		public Coupon addCoupon(@RequestBody Coupon c) throws ParseException
		{
			Coupon coupon = couponService.addCoupon(c);
			return coupon;
		}

		//http://localhost:8089/SpringMVC/coupon/remove-coupon/{coupon-id}
		@ApiOperation(value = "supprimer un coupon")
		@DeleteMapping("remove-coupon/{coupon-id}")
		@ResponseBody
		public void removeCoupon(@PathVariable("coupon-id") Long couponId) {
			couponService.deleteCoupon(couponId);
		}

		//http://localhost:8089/SpringMVC/coupon/modify-coupon
		@ApiOperation(value = "modifier un coupon")
		@PutMapping("/modify-coupon")
		@ResponseBody
		public Coupon modifyCoupon(@RequestBody Coupon coupon) {
		return couponService.updateCoupon(coupon);
		}

}
