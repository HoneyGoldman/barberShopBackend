package com.honey.Barber.DAO.Location;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honey.Barber.Beans.Location;

@Transactional
public interface LocationRepoJPA extends JpaRepository<Location, Long>{

}
