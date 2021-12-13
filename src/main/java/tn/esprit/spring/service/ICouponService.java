package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Coupon;

public interface ICouponService {
	List<Coupon> retrieveAllCoupon();

	Coupon addCoupon(Coupon c) throws ParseException;

	void deleteCoupon(Long id);

	Coupon updateCoupon(Coupon c);

	Coupon retrieveCoupon(Long id);
	
	public void generateCoupon();

}
