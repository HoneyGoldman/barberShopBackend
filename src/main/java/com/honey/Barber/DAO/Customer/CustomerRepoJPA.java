package com.honey.Barber.DAO.Customer;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honey.Barber.Beans.Customer;

@Transactional
public interface CustomerRepoJPA extends JpaRepository<Customer, Long>{

}
