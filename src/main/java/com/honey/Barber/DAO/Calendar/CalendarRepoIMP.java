package com.honey.Barber.DAO.Calendar;

import java.sql.ResultSet;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.honey.Barber.API.SitePropertyController;
import com.honey.Barber.Beans.Appointment;
import com.honey.Barber.Beans.Customer;
import com.honey.Barber.Beans.Day;
import com.honey.Barber.Beans.Month;
import com.honey.Barber.Beans.SiteProperty;
import com.honey.Barber.DAO.SiteProperty.SitePropertyIMP;

@Component
public class CalendarRepoIMP implements CalendarRepository{


	@Autowired
	EntityManager entityManager;
	
	@Autowired
	AppointmentJPA appointmentJPA;


	public List<Appointment> getCurrentMonth(String siteId) {
		LocalDate firstOfMonth = LocalDate.now().withDayOfMonth( 1 );
		return entityManager.createQuery("select i from Appointment i where i.siteId=:siteId and ( i.date between :startDate and :endDate) ORDER BY i.date ASC", Appointment.class)
		  .setParameter("startDate", firstOfMonth).setParameter("siteId", siteId)
		  .setParameter("endDate", firstOfMonth.plusMonths( 1 )).getResultList();
//		Date date = new Date();
//		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//		int month = localDate.getMonthValue();
//		int year = localDate.getYear();
//		 Query jpqlQuery = entityManager.createQuery("SELECT u FROM Appointment u WHERE u.date>=:month and u.year=:year and u.siteId=:siteId");
//		 jpqlQuery.setParameter("month", month);
//		 jpqlQuery.setParameter("siteId", siteId);
//		 jpqlQuery.setParameter("year", year);
//		 return ( List<Appointment>) jpqlQuery.getResultList();
		
	}
	
//	public List<Appointment> getMonthsAppointments(String siteId,int monthNumber) {
//		Date date = new Date();
//		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//		int lastMonth=monthNumber-1;
//		int nextMonth=monthNumber+1;
//		 Query jpqlQuery = entityManager.createQuery(
//				 "SELECT u FROM Appointment u WHERE u.siteId=:siteId and u.monthNumber=:month or u.monthNumber=:lastMonth or u.monthNumber=:nextMonth ORDER BY u.date ASC"
//		 				);
//		 jpqlQuery.setParameter("month", monthNumber);
//		 jpqlQuery.setParameter("lastMonth", lastMonth);
//		 jpqlQuery.setParameter("nextMonth", nextMonth);
//		 jpqlQuery.setParameter("siteId", siteId);
//
//		 return (List<Appointment>) jpqlQuery.getResultList();
//	}

	public Boolean setAppointment(String siteId, Appointment appointment) {
		try {
				if(appointment.getSiteId().equals(appointment.getSiteId())){
				this.appointmentJPA.save(appointment);
				return true;
				}
				else {
					System.err.println("CalendarRepoIMP.SteAppointment error! different site id!");
					return false;
				}
				
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	public void deleteAppointment(String siteId, Appointment appointment) {
		this.appointmentJPA.delete(appointment);;
		
	}

	public List<Appointment> getDayAppointments(String siteId, LocalDate reqDate) {
		 Query jpqlQuery = entityManager.createQuery("SELECT u FROM Appointment u WHERE (u.date=:date"
			 		+ " ) and u.siteId=:siteId ORDER BY u.startTime ASC");
			 jpqlQuery.setParameter("date", reqDate);
			 jpqlQuery.setParameter("siteId", siteId);
			 List<Appointment> results=(List<Appointment>) jpqlQuery.getResultList();
//			 results.stream().map(Appointment ::getStartTime).collect(Collectors.toList());
			 return results;
	}
	
	public List<Appointment> getFullAppointmenForDay(String siteId, LocalDate reqDate) {
		List<Appointment> realAppointments=this.getDayAppointments(siteId, reqDate);
		LocalTime startTime=LocalTime.parse(SitePropertyIMP.getSitePropertyByName("startTime", siteId).getValue());
		LocalTime endTime=LocalTime.parse(SitePropertyIMP.getSitePropertyByName("endTime", siteId).getValue());
		LocalTime timePerCustomer=LocalTime.parse(SitePropertyIMP.getSitePropertyByName("timePerCustomer", siteId).getValue());
		Long timePerDay=(startTime.until(endTime, ChronoUnit.MINUTES));
		Long timePerCustomerLong=(long) (timePerCustomer.getHour()*60+timePerCustomer.getMinute());

		int iterations= (int) (timePerDay/(timePerCustomerLong));
		List<Appointment> results=new ArrayList<Appointment>();
		Customer dummyCustomer=new Customer(0, "dummy", "dummy", siteId, "no source", "no mail");
		
		for (int i = 0; i < iterations; i++) {
			Appointment freeAppointment=new Appointment(0, siteId, reqDate,
					startTime.plusHours(timePerCustomer.getHour()*i).plusMinutes(timePerCustomer.getMinute()*i)
					, dummyCustomer);
			results.add(freeAppointment);
			}

		results.addAll(realAppointments);
		results=results.stream().sorted(Comparator.comparing(Appointment::getStartTime)).collect(Collectors.toList());
		for(int i=0;i<results.size()-1;i++){
			if(results.get(i).getCustomer().getName().equals("dummy") && !results.get(i+1).getCustomer().getName().equals("dummy")
					&& results.get(i).getStartTime().plusMinutes(timePerCustomerLong)
					.compareTo(results.get(i+1).getStartTime())>0){
				results.remove(i);
				i++;
			}
		}
		return results;
	}
	
	
	
	
	
	
	
	
	
	
//	public Day getDay(String siteId, LocalDate date) {
//		 Query jpqlQuery = entityManager.createQuery("SELECT u FROM Day u WHERE u.Date=:date and u.siteId=:siteId");
//		 jpqlQuery.setParameter("date", date);
//		 jpqlQuery.setParameter("siteId", siteId);
//		 return (Day) jpqlQuery.getSingleResult();
//	}
//	
//	public List<Day> getAllDays(String siteId) {
//		 return dayRepo.findAll();
//	}
//	
//	public void deleteDay(Day day) {
//		this.dayRepo.delete(day);
//	}
	
//	public Month getMonth(String siteId,int monthNumber) {
//	Date date = new Date();
//	LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//	int year = localDate.getYear();
//	 Query jpqlQuery = entityManager.createQuery("SELECT u FROM Month u WHERE u.monthNumber=:month and u.siteId=:siteId");
//	 jpqlQuery.setParameter("month", monthNumber);
//	 jpqlQuery.setParameter("siteId", siteId);
//	 Month result=(Month) jpqlQuery.getSingleResult();
//	 if(result==null) {
//		 Month monthObj=new Month(0, null, siteId, monthNumber,year);
//		 monthRepo.save(monthObj);
//		 return monthObj;
//	 }
//	 return result;
//}
//	@Autowired
//	DayRepoJPA dayRepo;
//	
//	@Autowired
//	MonthRepoJPA monthRepo;
	
}
