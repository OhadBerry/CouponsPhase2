package com.Ohad.Phase2.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.Ohad.Phase2.beans.Purchase;
import com.Ohad.Phase2.dao.PurchasesDao;
import com.Ohad.Phase2.exceptions.ApplicationException;

@Controller

public class PurchasesController {

	@Autowired
	private PurchasesDao purchasesDao;

	public PurchasesController() {
		super();
	}

	public long createPurchase(Purchase purchase) throws Exception {
		return purchasesDao.createCouponPurchase(purchase);
	}

	public Purchase getPurchaseByPurchaseID(long purchaseID) throws ApplicationException {
		return purchasesDao.getPurchaseByPurchaseID(purchaseID);
	}

	public void deletePurchasesByCompanyID(long companyID) throws ApplicationException {
		purchasesDao.deletePurchasesByCompanyID(companyID);
	}

	public void deletePurchasesByPurchaseID(long purchaseID) throws ApplicationException {
		purchasesDao.deletePurchasesByPurchaseID(purchaseID);
	}

	public void deletePurchasesByCouponID(long couponID) throws ApplicationException {
		purchasesDao.deleteCouponPurchaseByCouponID(couponID);

	}

	public void deletePurchasesByCustomerID(long customerID) throws ApplicationException {
		purchasesDao.deletePurchasesByCustomerID(customerID);
	}

}
