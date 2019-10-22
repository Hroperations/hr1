package com.virtusa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.virtusa.entities.Job;
import com.virtusa.integrate.ConnectionManager;

public class AdminDAOImpl implements AdminDAO {
	@Override
	public boolean persistJob(Job job) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection connection=ConnectionManager.openConnection();
		System.out.println("in connection Manager");
		PreparedStatement statement=
				connection.prepareStatement("INSERT INTO JOB values(?,?,?,?)");
		statement.setInt(1, job.getJobId());
		statement.setString(2,job.getJobTitle());
		statement.setString(3,job.getEligibilityCriteria());
		statement.setInt(4, job.getOpportunityId());
		int rows=statement.executeUpdate();
		System.out.println(rows);
		ConnectionManager.closeConnection();
		if(rows>0)
			return true;
		else
	
		return false;
	}

	

}
