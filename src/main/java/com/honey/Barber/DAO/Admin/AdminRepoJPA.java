package com.honey.Barber.DAO.Admin;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honey.Barber.Beans.Admin;

@Transactional
public interface AdminRepoJPA extends JpaRepository<Admin, Long>{

}
