package com.honey.barberShop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestComponent;

import com.honey.Barber.Beans.Customer;

@TestComponent
class CustomerTest {

	@Test
	void test() {
		Customer cust = new Customer();
		cust.setName("shir ");
		cust.setPhoneNumber("123456");
		System.out.println("customer name: " + cust.getName() + "cust number: " +cust.getPhoneNumber());
	}

}
