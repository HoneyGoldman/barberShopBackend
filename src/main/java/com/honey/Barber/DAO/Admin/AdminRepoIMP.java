package com.honey.Barber.DAO.Admin;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.honey.Barber.Beans.Admin;

@Component
public class AdminRepoIMP implements AdminRepository{
	
	@Autowired
    private AdminRepoJPA adminRepo;
	
	@Autowired 
	private  EntityManager entityManager;

	@Override
	public Admin login(String email, String password) {
	    Query jpqlQuery = entityManager.createQuery("SELECT u FROM Admin u WHERE u.email=:email and u.password=:password");
	    jpqlQuery.setParameter("email", email);
	    jpqlQuery.setParameter("password", password);
	    return (Admin) jpqlQuery.getSingleResult();
	}

	@Override
	public Admin getAdminUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
