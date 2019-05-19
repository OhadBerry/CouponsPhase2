package com.Ohad.Phase2.idao;

import java.util.ArrayList;

import com.Ohad.Phase2.beans.Coupon;


public interface ICouponsDao {
	
	public void createCoupon (Coupon coupon) throws Exception;
	public void updateCoupon (Coupon coupon) throws Exception;
	public void deleteCouponById (long couponId) throws Exception;
	public Coupon getCouponbyId(long couponId) throws Exception;
	public ArrayList<Coupon> getAllCoupons() throws Exception;
	void deleteExpiredCoupons() throws Exception;

}
