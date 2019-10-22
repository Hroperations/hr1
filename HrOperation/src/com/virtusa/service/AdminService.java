package com.virtusa.service;

import java.sql.SQLException;

import com.virtusa.model.AdminModel;

public interface AdminService {
	public boolean storeJobService(AdminModel adminmodel) throws ClassNotFoundException, SQLException;
}
