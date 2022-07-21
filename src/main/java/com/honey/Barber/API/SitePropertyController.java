package com.honey.Barber.API;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.honey.Barber.Beans.SiteProperty;
import com.honey.Barber.DAO.SiteProperty.SitePropertyIMP;
import com.honey.Barber.DAO.SiteProperty.SitePropertyRepoJPA;

@RestControllerAdvice
@RequestMapping("SiteProperty")
public class SitePropertyController {
	@Autowired
	SitePropertyRepoJPA sitePropertyRepo;
	
	@Autowired
	SitePropertyIMP sitePropertyIMP;
	
	
	@GetMapping("test")
	public String test() {
		System.out.println("**** "+SitePropertyIMP.getSitePropertyByName("startTime", "General").getValue());
		System.out.println("**** "+SitePropertyIMP.getSitePropertyByName("timePerCustomer", "General").getValue());
	
		return "i'm Alive!";
		
	}
	
	@GetMapping("getAll")
	public Collection<SiteProperty> getAllSiteProperties() {
		try {
			return sitePropertyRepo.findAll();
			} catch (Exception e) {
			if (e instanceof NullPointerException) {
				System.out.println("No properties in DB");
			}
			else
			{
				e.printStackTrace();
			}
		}
		return null;
	}	
	
	@GetMapping("getSitePropertyByName")
	public SiteProperty getSitePropertyByName(@RequestParam String siteId,@RequestParam String name) {
		try {
			return SitePropertyIMP.getSitePropertyByName(name, siteId);
			} catch (Exception e) {
			if (e instanceof NullPointerException) {
				System.out.println("No properties in DB");
			}
			else
			{
				e.printStackTrace();
			}
		}
		return null;
	}	
	@RequestMapping(value="saveSiteProperty",method= {RequestMethod.PUT})
	public void saveSiteProperty(@RequestBody SiteProperty property) {
		try {
			sitePropertyRepo.save(property);
		} catch (Exception e) {

				e.printStackTrace();
			}
	}
	
	@RequestMapping(value="update",method= {RequestMethod.POST})
	public void updateSiteProperty(@RequestBody SiteProperty property) {
		try {
			sitePropertyRepo.save(property);
		} catch (Exception e) {

				e.printStackTrace();
			}
	}
	
	@RequestMapping(value="delete",method= {RequestMethod.DELETE})
	public void deleteSiteProperty(@RequestBody SiteProperty property) {
		try {
			sitePropertyRepo.delete(property);
		} catch (Exception e) {

				e.printStackTrace();
			}
		}
}
