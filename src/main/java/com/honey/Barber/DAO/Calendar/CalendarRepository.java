package com.honey.Barber.DAO.Calendar;

import java.time.LocalDate;
import java.util.List;

import com.honey.Barber.Beans.Appointment;

public interface CalendarRepository {
	List<Appointment> getCurrentMonth(String siteId);
//	List<Appointment> getMonthsAppointments(String siteId,int monthNumber);
	Boolean setAppointment(String siteId,Appointment appointment);
	boolean deleteAppointment(String siteId, Appointment appointment);
	boolean deleteAppointment(String siteId, Long id);
	List<Appointment> getDayAppointments(String siteId, LocalDate reqDate);
//	Day getDay(String siteId,LocalDate date);
//	List<Day> getAllDays(String siteId);
//	void deleteDay(Day day);
//	List<Appointment> getMonth(String siteId, int monthNumber);
	
}
