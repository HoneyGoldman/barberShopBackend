package com.honey.Barber.API;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.honey.Barber.Beans.Customer;
import com.honey.Barber.DAO.Customer.CustomerRepoIMP;
import com.honey.Barber.DAO.Customer.CustomerRepoJPA;

@RestControllerAdvice
@RequestMapping("Customer")
public class CustomerController {
	@Autowired
	CustomerRepoJPA customerRepo;
	
	@Autowired
	CustomerRepoIMP customerRepoIMP;
	
	@GetMapping("test")
	public String test() {
		return "i'm Alive!";
	}
	
	@GetMapping("getAll")
	public Collection<Customer> getAllCustomer(@RequestParam String siteId) {
		try {
			return customerRepoIMP.getAllCustomers(siteId);
		} catch (Exception e) {
			if (e instanceof NullPointerException) {
				System.out.println("No customers in DB");
			}
			else
			{
				e.printStackTrace();
			}
		}
		return null;
	}	
	
	@RequestMapping(value="saveCustomer",method= {RequestMethod.PUT})
	public void saveCustomer(@RequestBody Customer customer) {
		try {
			customerRepo.save(customer);
		} catch (Exception e) {

				e.printStackTrace();
			}
	}
	
	@RequestMapping(value="update",method= {RequestMethod.POST})
	public void updateCustomer(@RequestBody Customer customer) {
		try {
			customerRepo.save(customer);
		} catch (Exception e) {

				e.printStackTrace();
			}
	}
	
	@RequestMapping(value="delete",method= {RequestMethod.DELETE})
	public void deleteArtist(@RequestBody Customer customer) {
		try {
			customerRepo.delete(customer);
		} catch (Exception e) {

				e.printStackTrace();
			}
		}
}

