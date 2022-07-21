package com.honey.Barber.API;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.honey.Barber.Beans.Admin;
import com.honey.Barber.DAO.Admin.AdminRepoJPA;

@RestControllerAdvice
@RequestMapping("Admin")
public class AdminController {
	@Autowired
	AdminRepoJPA adminRepo;
	
	@GetMapping("test")
	public String test() {
		return "i'm Alive!";
	}
	
	@GetMapping("getAll")
	public Collection<Admin> getAllAdmins() {
		try {
			return adminRepo.findAll();
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
	
	@RequestMapping(value="saveAdmin",method= {RequestMethod.PUT})
	public void saveAdmin(@RequestBody Admin admin) {
		try {
			adminRepo.save(admin);
		} catch (Exception e) {

				e.printStackTrace();
			}
	}
	
	@RequestMapping(value="update",method= {RequestMethod.POST})
	public void updateAdmin(@RequestBody Admin admin) {
		try {
			adminRepo.save(admin);
		} catch (Exception e) {

				e.printStackTrace();
			}
	}
	
	@RequestMapping(value="delete",method= {RequestMethod.DELETE})
	public void deleteAdmin(@RequestBody Admin admin) {
		try {
			adminRepo.delete(admin);
		} catch (Exception e) {

				e.printStackTrace();
			}
		}
}
