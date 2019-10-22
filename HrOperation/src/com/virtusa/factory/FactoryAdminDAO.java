package com.virtusa.factory;

import com.virtusa.dao.AdminDAO;
import com.virtusa.dao.AdminDAOImpl;

public class FactoryAdminDAO {
public static AdminDAO createStudentDAO(){
		
	AdminDAO adminDAO=new AdminDAOImpl();
		return adminDAO;
		
	}

}
