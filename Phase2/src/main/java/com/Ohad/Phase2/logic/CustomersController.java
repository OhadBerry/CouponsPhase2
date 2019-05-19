package com.Ohad.Phase2.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.Ohad.Phase2.beans.Customer;
import com.Ohad.Phase2.dao.CustomersDao;
import com.Ohad.Phase2.enums.ErrorType;
import com.Ohad.Phase2.exceptions.ApplicationException;

@Controller
public class CustomersController {
	
	@Autowired
	private CustomersDao customersDao;
	@Autowired
	private UsersController usersController;
	@Autowired
	private PurchasesController purchasesController;
	
	public CustomersController() {
		super();
	}
	
	public long createCustomer(Customer customer) throws Exception  {
		//Creating a new User	
		long id = this.usersController.createUser(customer.getUser());
		
		//Setting customer ID which is actually customer.user.id
		customer.setId(id);
				
		//Creating new customer with newly updated id in beans
		return customersDao.createCustomer(customer);
		
	}
	
	public void updateCustomer (Customer toBeUpdatedCustomer) throws Exception {
		//Updating User
		usersController.updateUser(toBeUpdatedCustomer.getUser());
		
		//Updating Customer
		customersDao.updateCustomer(toBeUpdatedCustomer);
	}
	
	public void deleteCustomerByID (long customerID) throws Exception {
		if (!this.customersDao.isCustomerExistsById(customerID)) {
			throw new ApplicationException(ErrorType.ID_DONT_EXIST,"Could not delete customer by ID, this ID does not exist in the DB");
		}
		
		//Delete the purchases made by the Customer in the DB
		purchasesController.deletePurchasesByCustomerID(customerID);

		//Delete the Customer Details in the DB
		customersDao.deleteCustomer(customerID);
		
		//Delete the User Details in the DB
		usersController.deleteUserbyID(customerID);
	}
	
	public Customer getCustomerByID (long customerID) throws Exception {
		return customersDao.getCustomerById(customerID);
	}
	
	

}
