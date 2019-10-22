package com.virtusa.dao;

import java.sql.SQLException;
import com.virtusa.entities.Job;


public interface AdminDAO {
	public boolean persistJob(Job job) throws ClassNotFoundException, SQLException;

}
