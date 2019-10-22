package com.virtusa.service;


import java.sql.SQLException;

import com.virtusa.dao.AdminDAO;
import com.virtusa.entities.Job;
import com.virtusa.factory.FactoryAdminDAO;
import com.virtusa.model.AdminModel;

public class AdminServiceImpl implements AdminService {

	
		private AdminDAO adminDAO=null;
		public AdminServiceImpl(){
			this.adminDAO=FactoryAdminDAO.createStudentDAO();
			
		}
		
		
		@Override
		public boolean storeJobService(AdminModel adminmodel) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			
			Job job=new Job();
			
			
			job.setJobId(adminmodel.getJobId());
			job.setJobTitle(adminmodel.getJobTitle());
			job.setEligibilityCriteria(adminmodel.getEligibilityCriteria());
			job.setOpportunityId(adminmodel.getOpportunityId());
			
			
			return adminDAO.persistJob(job);
			
			
	}

}
