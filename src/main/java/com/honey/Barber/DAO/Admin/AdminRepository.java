package com.honey.Barber.DAO.Admin;

import com.honey.Barber.Beans.Admin;

public interface AdminRepository {

	Admin login(String email,String password);
	Admin getAdminUser(String email,String password);
	
}
