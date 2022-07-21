package com.honey.Barber.DAO.Calendar;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honey.Barber.Beans.Appointment;

@Transactional
public interface AppointmentJPA extends JpaRepository<Appointment, Long>{

}
