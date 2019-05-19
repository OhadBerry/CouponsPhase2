package com.Ohad.Phase2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ohad.Phase2.beans.Company;
import com.Ohad.Phase2.logic.CompaniesController;

@RestController
@RequestMapping ("/company")
public class CompanyApi {
	
	@Autowired
	private CompaniesController companyController;
	
	@PostMapping
	public void createCompany(@RequestBody Company company) throws Exception {
		System.out.println(company);
		this.companyController.createCompany(company);
	}

}
