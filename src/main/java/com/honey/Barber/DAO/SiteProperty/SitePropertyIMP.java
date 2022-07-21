package com.honey.Barber.DAO.SiteProperty;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.honey.Barber.Beans.SiteProperty;

@Component
public class SitePropertyIMP implements SitePropertyRepository{
	@Autowired
	SitePropertyRepoJPA sitePropertyRepo;

	 
	static EntityManager entityManager;
	
	@Autowired
    public SitePropertyIMP(EntityManager entityManager) {
		SitePropertyIMP.entityManager = entityManager;
    }
	
	public static SiteProperty getSitePropertyByName(String name,String siteId) {
		Query jpqlQuery = entityManager.createQuery("SELECT u FROM SiteProperty u WHERE u.name=:name"
				+ " and u.siteId=:siteId");
	    jpqlQuery.setParameter("name", name);
	    jpqlQuery.setParameter("siteId", siteId);
	    return (SiteProperty) jpqlQuery.getSingleResult();
	}
	

}
