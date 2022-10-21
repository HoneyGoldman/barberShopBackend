package com.honey.Barber.API;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.honey.Barber.Beans.Admin;
import com.honey.Barber.Beans.Location;
import com.honey.Barber.DAO.Admin.AdminRepoJPA;
import com.honey.Barber.DAO.Location.LocationRepoJPA;

import nonapi.io.github.classgraph.json.JSONSerializer;

@RestControllerAdvice
@RequestMapping("Admin")
public class AdminController {
	@Autowired
	AdminRepoJPA adminRepo;
	
	@Autowired
	LocationRepoJPA locationRepo;
	
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
	
	@RequestMapping(value="updateWithLocationsList",method= {RequestMethod.POST})
	public void updateAdmin(@RequestBody Map<String,Object> data) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonString =  objectMapper.writeValueAsString(data.get("admin"));
			Admin admin =objectMapper.readValue(jsonString,Admin.class);
			List<Location> allLocations=locationRepo.findAll();
			List<String> locations=(List<String>)data.get("locations");
			List<Location> results=new ArrayList<Location>();
			locations.forEach(outerLocation->{
				allLocations.forEach(location->{
					if(location!=null && location.getLocation().equals(outerLocation)) {
						results.add(location);
					}
				});
			});
			admin.setLocations((List<Location>)results);
			adminRepo.save(admin);
		} catch (Exception e) {

				e.printStackTrace();
			}
	}
	
	
	@RequestMapping(value="barberSearch",method= {RequestMethod.GET})
	public Set<Admin> barberSearch(@RequestParam List<String> locations) {
		try {
			Set<Admin> results=new HashSet<Admin>();
			adminRepo.findAll().forEach(admin->{                 
				ArrayList<String> list=(ArrayList<String>)admin.getLocations().stream().map(Location::getLocation).collect(Collectors.toList());
				locations.forEach(location->{
					if(list.contains(location)) {
						results.add(admin);
					}
				});
			});
			return results;
		} catch (Exception e) {

				e.printStackTrace();
			}
		return null;
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
