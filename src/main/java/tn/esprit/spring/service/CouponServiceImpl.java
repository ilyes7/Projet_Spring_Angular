package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.List;
import java.util.Random;

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

	@Override
	public void generateCoupon() {
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 5;
	    Random random = new Random();
	    Random randomNumber = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    
	    String generatedNumber = randomNumber.ints(48, 58)
	  	      .limit(2)
	  	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	  	      .toString();

	    System.out.println(generatedString+generatedNumber);
	}
}
