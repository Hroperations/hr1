package com.virtusa.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.virtusa.entities.Applicant;
import com.virtusa.entities.Job;
import com.virtusa.integrate.ConnectionManager;
import com.virtusa.model.ApplicantModel;

public class ApplicantDAOImpl implements ApplicantDAO {

	ApplicantModel applicantModel=new ApplicantModel();
	
	@Override
	public List<Job> viewJobs() throws SQLException, ClassNotFoundException {
		Connection connection =
				ConnectionManager.openConnection();
		PreparedStatement statement=
		connection.prepareStatement(" select j.jobId ,j.jobTitle ,j.eligibilityCriteria ,"
				+ "u.email from users u INNER join employee e on u.userId=e.userId "
				+ "INNER join department d on e.deptId=d.deptId INNER join "
				+ " job j on j.opportunityId=d.deptId and e.designation='HR'");
		ResultSet resultSet=
				statement.executeQuery();
		List<Job> jobList=new ArrayList<Job>();
		while(resultSet.next()) {
			Job job=new Job();
			job.setJobId(resultSet.getInt("jobId"));
			job.setJobTitle(resultSet.getString("jobTitle"));
			job.setEligibilityCriteria(resultSet.getString("eligibilityCriteria"));
			job.setMailId(resultSet.getString("email"));
			jobList.add(job);
		}
		return jobList ;
	}
	@Override
	public boolean postResume(ApplicantModel applicantModel) throws ClassNotFoundException, SQLException, IOException  {
		// TODO Auto-generated method stub
		File pdfFile = new File(applicantModel.getResume());
		byte[] pdfData = new byte[(int) pdfFile.length()];
		Connection connection =
				ConnectionManager.openConnection();
		PreparedStatement statement = 
				connection.prepareStatement("insert into resume values(?,?)");
		statement.setInt(1, 1);
		statement.setBytes(2,pdfData );
		
		int rows=statement.executeUpdate();
		System.out.println(rows);
		ConnectionManager.closeConnection();
		if(rows>0)
			return true;
		else
	
			return false;

		    }
	
	public boolean approveOfferLetterStatus() throws ClassNotFoundException, SQLException {
		Connection connection =
				ConnectionManager.openConnection();
		PreparedStatement statement = 
				connection.prepareStatement("insert into applicant values('Approve')");
		int rows=statement.executeUpdate();
		if(rows>0)
			return true;
		else
	
			return false;

	}
	public boolean rejectOfferLetterStatus() throws ClassNotFoundException, SQLException {
		Connection connection =
				ConnectionManager.openConnection();
		PreparedStatement statement = 
				connection.prepareStatement("insert into applicant values('Reject')");
		int rows=statement.executeUpdate();
		if(rows>0)
			return true;
		else
	
			return false;

	}
	@Override
	public List<Applicant> viewApplicationStatus() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=null;
			connection = ConnectionManager.openConnection();
			PreparedStatement statement=
					connection.prepareStatement("select applicationstatus from applicant");
			ResultSet resultSet=
					statement.executeQuery();
			List<Applicant>	applicationStatusList=new ArrayList<Applicant>();
			while(resultSet.next()) {
				Applicant applicant=new Applicant();
				applicant.setApplicationStatus(resultSet.getString(1));
				applicationStatusList.add(applicant);
			}
		return applicationStatusList;
	}
	@Override
	public List<Applicant> viewResultStatus() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=null;
		connection = ConnectionManager.openConnection();
		PreparedStatement statement=
				connection.prepareStatement("select resultUpdate from applicant");
		ResultSet resultSet=
				statement.executeQuery();
		List<Applicant>	resultUpdateList=new ArrayList<Applicant>();
		while(resultSet.next()) {
			Applicant applicant=new Applicant();
			applicant.setResultUpdate(resultSet.getString(1));
			resultUpdateList.add(applicant);
		}
	return resultUpdateList;
	}
	@Override
	public List<Applicant> viewOfferLetter() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
				Applicant applicant =new Applicant();
				Connection connection=null;
				connection = ConnectionManager.openConnection();
				PreparedStatement statement=
						connection.prepareStatement("select fileName,fileData from filetable where fileId=?");
				statement.setInt(1,1);
				ResultSet resultSet=
						statement.executeQuery();
				List<Applicant>	offerLetterList=new ArrayList<Applicant>();
				while(resultSet.next()) {
					//fileName=resultSet.getString("fileName");
					//reader=resultSet.getCharacterStream("fileData");
					applicant.setFile_name(resultSet.getString("fileName"));
					applicant.setFile_data(resultSet.getString("fileData"));
					
					offerLetterList.add(applicant);
				 
				}
				System.out.println(offerLetterList);return offerLetterList;
				
	}	
}

