package com.honey.Barber.DAO.SiteProperty;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.honey.Barber.Beans.SiteProperty;

@Transactional
public interface SitePropertyRepoJPA extends JpaRepository<SiteProperty, Long>{

}
