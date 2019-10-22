package com.virtusa.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.virtusa.entities.Applicant;
import com.virtusa.entities.Job;
import com.virtusa.model.ApplicantModel;



public interface ApplicantDAO {
	public List<Job> viewJobs() throws SQLException, ClassNotFoundException;
	public boolean postResume(ApplicantModel applicantModel) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	public List<Applicant> viewApplicationStatus() throws ClassNotFoundException, SQLException;
	List<Applicant> viewOfferLetter() throws ClassNotFoundException, SQLException;
	List<Applicant> viewResultStatus() throws ClassNotFoundException, SQLException;
	public boolean approveOfferLetterStatus() throws ClassNotFoundException, SQLException;
	public boolean rejectOfferLetterStatus() throws ClassNotFoundException, SQLException;
}
