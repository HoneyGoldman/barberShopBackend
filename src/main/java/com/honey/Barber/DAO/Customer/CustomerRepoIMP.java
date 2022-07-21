package com.honey.Barber.DAO.Customer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.honey.Barber.Beans.Customer;
import com.honey.Barber.DAO.Admin.AdminRepoJPA;

@Component
public class CustomerRepoIMP implements CustomerRepository{

	@Autowired
    private AdminRepoJPA adminRepo;
	
	@Autowired 
	private  EntityManager entityManager;
	
	@Override
	public List<Customer> getAllCustomers(String siteId) {
		TypedQuery<Customer> query = entityManager.createQuery("SELECT u FROM Customer u WHERE u.siteId=:siteParam", Customer.class);
		query.setParameter("siteParam", siteId);
	    return query.getResultList();
	}

}
