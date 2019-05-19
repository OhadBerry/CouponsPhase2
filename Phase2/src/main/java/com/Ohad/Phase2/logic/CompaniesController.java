package com.Ohad.Phase2.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.Ohad.Phase2.beans.Company;
import com.Ohad.Phase2.dao.CompaniesDao;
import com.Ohad.Phase2.enums.ErrorType;
import com.Ohad.Phase2.exceptions.ApplicationException;
import com.Ohad.Phase2.utils.ValidationUtils;

@Controller
public class CompaniesController {
	
	@Autowired
	private CompaniesDao companiesDao;
	@Autowired
	private CouponsController couponsController;
	@Autowired
	private PurchasesController purchasesController;
	
	public CompaniesController() {
		super();
	}
	
	public void createCompany(Company company) throws Exception {
		if (isValidCompany(company)) {
			companiesDao.createCompany(company);
		}
	}
	
	public void updateCompany(Company company) throws Exception {
		if (isValidCompany(company)) {
			companiesDao.updateCompany(company);
		}	
	}
	
	public void deleteCompany(long companyID) throws ApplicationException {
		couponsController.deleteCouponsByCompanyID(companyID);
		purchasesController.deletePurchasesByCompanyID(companyID);
	}
	
	public Company getCompanyByCompanyID(long companyID) throws Exception {
		return companiesDao.getCompanyById(companyID);
	}

	private boolean isValidCompany(Company company) throws Exception {

		//Validating Integrity of Company Name
		if (ValidationUtils.isValidString(company.getName())) {
			if (companiesDao.isCompanyExistsByName(company.getName())) {
				throw new ApplicationException(ErrorType.NAME_ALREADY_EXISTS, "Failed to create Company, Company Name Already Exists");
			}
		}
		return true;
	}

}
