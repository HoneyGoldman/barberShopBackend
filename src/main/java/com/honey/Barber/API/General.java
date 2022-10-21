package com.honey.Barber.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.honey.Barber.Beans.Admin;
import com.honey.Barber.Beans.Location;
import com.honey.Barber.DAO.Admin.AdminRepoIMP;
import com.honey.Barber.DAO.Location.LocationRepoJPA;


@RestControllerAdvice
@RequestMapping("General")
public class General {

	@Autowired
	AdminRepoIMP adminRepo;
	
	@Autowired
	LocationRepoJPA LocationRepo;
	
	@GetMapping("test")
	public String test() {
		return "i'm Alive!";
	}
	
	@GetMapping("login")
	public Admin getAllShows(String email,String password) {
		try {
			return adminRepo.login(email, password);
		} catch (Exception e) {
			if (e instanceof NullPointerException) {
				System.out.println("No Admin in DB");
			}
			else
			{
				e.printStackTrace();
			}
		}
		return null;
	}	
	
	@GetMapping("Locations")
	public List<Location> getAllLocations() {
		try {
			return LocationRepo.findAll();
		} catch (Exception e) {
			if (e instanceof NullPointerException) {
				System.out.println("No Locations in DB");
			}
			else
			{
				e.printStackTrace();
			}
		}
		return null;
	}	
	
	
//	@RequestMapping(value="saveCustomer",method= {RequestMethod.PUT})
//	public void saveCustomer(@RequestBody Customer customer) {
//		try {
//			customerRepo.save(customer);
//		} catch (Exception e) {
//
//				e.printStackTrace();
//			}
//	}
	
//	@RequestMapping(value="update",method= {RequestMethod.POST})
//	public void updateCustomer(@RequestBody Customer customer) {
//		try {
//			customerRepo.save(customer);
//		} catch (Exception e) {
//
//				e.printStackTrace();
//			}
//	}
//	
//	@RequestMapping(value="delete",method= {RequestMethod.DELETE})
//	public void deleteArtist(@RequestBody Customer customer) {
//		try {
//			customerRepo.delete(customer);;
//		} catch (Exception e) {
//
//				e.printStackTrace();
//			}
//		}
}
