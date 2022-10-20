package com.honey.Barber.API;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.honey.Barber.Beans.Appointment;
import com.honey.Barber.Beans.Customer;
import com.honey.Barber.Beans.Day;
import com.honey.Barber.Beans.Month;
import com.honey.Barber.DAO.Calendar.CalendarRepoIMP;
import com.honey.Barber.DAO.Calendar.DayRepoJPA;
import com.honey.Barber.DAO.Calendar.MonthRepoJPA;
import com.honey.Barber.DAO.Customer.CustomerRepoJPA;
import com.honey.Barber.DAO.SiteProperty.SitePropertyIMP;

@RestControllerAdvice
@RequestMapping("Calendar")
public class CalendarController {
	
	@Autowired
	MonthRepoJPA monthRepoJPA;
	@Autowired
	DayRepoJPA dayRepoJPA;
	@Autowired
	CustomerRepoJPA customerRepoJPA;
	@Autowired
	CalendarRepoIMP calendarRepo;
	
	
	@GetMapping("test")
	public String test() {
		Customer customer=new Customer(0, "test customer", "0556172323", "General");
		customerRepoJPA.save(customer);
		LocalDate date=LocalDate.now();
		LocalTime time=LocalTime.of(10, 10, 10);
		this.setAppointmen("General", new Appointment(Long.valueOf("0"),"General",date,time,
				customer));
		ArrayList<Customer> cust=new ArrayList<Customer>();
		cust.add(customer);
		Day test=new Day(cust, LocalDate.now(), "General", LocalTime.of(10, 10,10));
		dayRepoJPA.save(test);
		return "I'm Alive!";
	}

	
	@GetMapping("getCurrentMonth")
	public List<Appointment> getCurrentMonth(@RequestParam String siteId) {
		return calendarRepo.getCurrentMonth(siteId);
	}

	@GetMapping("getMonth")
	public List<Appointment> getCurrentMonth(@RequestParam String siteId,@RequestParam int month,@RequestParam int year) {
		return calendarRepo.getMonthsAppointments(siteId,month,year);
		
	}
	
	@GetMapping("getFullAppointmenForDay")
	public List<Appointment> getFullAppointmenForDay(@RequestParam String siteId,@RequestParam int day,@RequestParam int month,@RequestParam int year) {
		LocalDate reqDate=LocalDate.of(year,month,day);
		return calendarRepo.getFullAppointmenForDay(siteId, reqDate);
	}
	
	@GetMapping("getDay")
	public List<Appointment> getDay(@RequestParam String siteId,@RequestParam int day,@RequestParam int month,@RequestParam int year) {
		LocalDate reqDate=LocalDate.of(year,month,day);
		return calendarRepo.getDayAppointments(siteId, reqDate);
	}
	
	@RequestMapping(value="setAppointmen",method= {RequestMethod.PUT})
	public Boolean setAppointmen(@RequestParam String siteId,@RequestBody Appointment appointment) {
		return calendarRepo.setAppointment(siteId, appointment);
	}
	
	@RequestMapping(value="updateAppointmen",method= {RequestMethod.POST})
	public Boolean updateAppointmen(@RequestParam String siteId,@RequestParam Appointment appointment) {
		return calendarRepo.setAppointment(siteId, appointment);
	}

	@RequestMapping(value="deleteAppointment",method= {RequestMethod.DELETE})
	public Boolean deleteAppointment(@RequestParam String siteId,@RequestParam Long id) {
		return calendarRepo.deleteAppointment(siteId, id);
	}
	
	

//	@GetMapping("test")
//	public String test() {
//		try {
////			customerRepoJPA.findAll().forEach(customer ->{
////				customer.setSource("default");
////				customer.setEmail("no mail");
////				customerRepoJPA.save(customer);
////			});
////			Customer customer1=new Customer(0, "Honey Goldman", "0556671210", "General");
////			Customer customer2=new Customer(0, "Shir Topaz", "0516234556", "General");
////			Customer customer3=new Customer(0, "Honey Goldman", "0556671210", "General");
////			Customer customer4=new Customer(0, "Shir Topaz", "0516234556", "General");
////			
////			customerRepoJPA.save(customer1);
////			customerRepoJPA.save(customer2);
////			customerRepoJPA.save(customer3);
////			customerRepoJPA.save(customer4);
////			
////			List<Customer> customerList=new ArrayList<Customer>();
////			customerList.add(customer1);
////			customerList.add(customer2);
////			LocalDate date=LocalDate.now();
////			Day day=new Day(0, customerList,date, "General" , LocalTime.now());
////			dayRepoJPA.save(day);
////			
////			List<Customer> customerList2=new ArrayList<Customer>();
////			customerList.add(customer3);
////			customerList.add(customer4);
////			LocalDate date2=LocalDate.now();
////			Day day2=new Day(0, customerList2,date2, "General" , LocalTime.now());
////			dayRepoJPA.save(day2);
////			
////			List<Day> daysList=new ArrayList<Day>();
////			daysList.add(day);
////			daysList.add(day2);
////			
////			Month month= new Month(0, daysList, "General", 7);
////			monthRepoJPA.save(month);
////			
//			return "i'm Alive!";
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "failed!";
//		
//	}
	
//	@GetMapping("getAllMonth")
//	public List<Month> getAllMonthDevTestOnly() {
//		return monthRepoJPA.findAll();
//		
//	}
//	@GetMapping("getDay")
//	public Day getDay(@RequestParam String siteId,@RequestParam int day,@RequestParam int month,@RequestParam int year) {
//		LocalDate reqDate=LocalDate.of(year,month,day);
//		return calendarRepo.getDay(siteId, reqDate);
//	}
	
//	@GetMapping("getAllDays")
//	public List<Day> getAllDays(@RequestParam String siteId) {
//		List<Day> days=calendarRepo.getAllDays(siteId);
//		for (Day day : days) {
//			System.out.println("Day is "+day);
//		}
//		List<Customer> customersListDay1=days.get(0).getCustomers();
//		for (Customer customer : customersListDay1) {
//			customerRepoJPA.delete(customer);
//		}
//		days.get(0).getCustomers().stream().map(Customer::getId).forEach(x=>{customerRepoJPA.delete(id)});
//		dayRepoJPA.delete(days.get(0));
//		customerRepoJPA.delete(days.get(0).getCustomers().get(0));
//		return days;
//	}
	
//	@RequestMapping(value="deleteAllDaysDev",method= {RequestMethod.DELETE})
//	public void deleteAllDays(@RequestParam String siteId) {
//		List<Day> days=calendarRepo.getAllDays(siteId);
//		for (Day day : days) {
//			if(day.getSiteId().equals(siteId)) {
//			dayRepoJPA.delete(day);
//			}
//		}
//		
//		}
	
//	@RequestMapping(value="setMonthSlots",method= {RequestMethod.PUT})
//	public void setMonth(@RequestParam String siteId,int month) {
//		Customer dummyCustomer=new Customer();
//		dummyCustomer.setName("dummyCustomer");
//		dummyCustomer.setSiteId(siteId);
////		customerRepoJPA.save(dummyCustomer);
//		LocalTime start=LocalTime.parse(SitePropertyIMP.getSitePropertyByName( "startTime",siteId).getValue());
//		LocalTime end=LocalTime.parse(SitePropertyIMP.getSitePropertyByName("endTime",siteId).getValue());
//		LocalTime timePerCustomer= LocalTime.parse(SitePropertyIMP.getSitePropertyByName("timePerCustomer",siteId).getValue());
//		LocalTime diff= end.minusNanos(start.toNanoOfDay());
//		int customersPerDay=((diff.getHour()*60)+diff.getMinute())/((timePerCustomer.getHour()*60)+timePerCustomer.getMinute());
//		ArrayList<Customer> customerList=new ArrayList<Customer>(Collections.nCopies(customersPerDay,dummyCustomer));
//		Day dummyDay=new Day(customerList, null, siteId, timePerCustomer);
//		
//		Month monthObj=calendarRepo.getMonth(siteId, month);
//		YearMonth yearMonthObject = YearMonth.of(LocalDate.now().getYear(), month);
//		int daysInMonth = yearMonthObject.lengthOfMonth();
//		for (int i = 1; i < daysInMonth+1; i++) {
//			dummyDay.setDate(LocalDate.of(LocalDate.now().getYear(), month,i ));
//			dayRepoJPA.save(dummyDay);
//			monthObj.getDays().add(dummyDay);
//		}
//		monthRepoJPA.save(monthObj);
//		}
	
}

