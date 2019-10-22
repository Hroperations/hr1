package com.virtusa.service;

import java.sql.SQLException;
import java.util.List;
import com.virtusa.model.ApplicantModel;

public interface ApplicantService {
	public List<ApplicantModel> retrieveJobService() throws ClassNotFoundException, SQLException;
	public String postResume(ApplicantModel applicantModel);
	public List<ApplicantModel> retrieveApplicationStatus() throws ClassNotFoundException, SQLException;
	List<ApplicantModel> retreiveResultUpdate() throws ClassNotFoundException, SQLException;
	List<ApplicantModel> retreiveOfferLetter() throws ClassNotFoundException, SQLException;
}
