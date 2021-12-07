package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Coupon;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.repository.CouponRepository;
@Slf4j
@Service
public class CouponServiceImpl implements ICouponService{
	@Autowired CouponRepository couponRepo;

	@Override
	public List<Coupon> retrieveAllCoupon() {
		List<Coupon> coupons =(List<Coupon>)couponRepo.findAll();
		for( Coupon coupon : coupons)
		{
			log.info("facture:"+ coupon);
		}
		return coupons ;
	}

	@Override
	public Coupon addCoupon(Coupon c) throws ParseException {
		c=couponRepo.save(c);
		return c;
	}

	@Override
	public void deleteCoupon(Long id) {
		couponRepo.deleteById(id);
		
	}

	@Override
	public Coupon updateCoupon(Coupon c) {
		c=couponRepo.save(c);
		return c;
	}

	@Override
	public Coupon retrieveCoupon(Long id) {
		return couponRepo.findById(id).orElse(null);
	}

}
