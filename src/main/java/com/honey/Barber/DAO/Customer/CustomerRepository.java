package com.honey.Barber.DAO.Customer;

import java.util.List;

import com.honey.Barber.Beans.Customer;

public interface CustomerRepository {
List<Customer> getAllCustomers(String siteId);
}
