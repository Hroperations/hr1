package com.virtusa.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.virtusa.dao.ApplicantDAO;
import com.virtusa.entities.Applicant;
import com.virtusa.entities.Job;
import com.virtusa.entities.Resume;
import com.virtusa.factory.FactoryApplicantDAO;
import com.virtusa.model.ApplicantModel;

public class ApplicantServiceImpl implements ApplicantService {
	private ApplicantDAO applicantDAO=null;
	public ApplicantServiceImpl(){
		this.applicantDAO=FactoryApplicantDAO.createApplicantDAO();
		
	}

	@Override
	public List<ApplicantModel> retrieveJobService() throws ClassNotFoundException, SQLException {
		 List<Job> jobList=applicantDAO.viewJobs();
		
		List<ApplicantModel> applicantModelList=new ArrayList<ApplicantModel>();
		
		for(Job job:jobList){
			
			ApplicantModel applicantMdl=new ApplicantModel();
			applicantMdl.setJobId(job.getJobId());
			applicantMdl.setJobTitle(job.getJobTitle());
			applicantMdl.setEligibilityCriteria(job.getEligibilityCriteria());
			applicantMdl.setMailId(job.getMailId());
			
			applicantModelList.add(applicantMdl);
		}
		return applicantModelList;
	}


	@Override
	public String postResume(ApplicantModel applicantModel) {
		Resume resume=new Resume();
		resume.setResume(applicantModel.getResume());
		String result="fail";
		try {
			boolean stored=applicantDAO.postResume(applicantModel);
			if(stored)
				result="success";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	
	}

	@Override
	public List<ApplicantModel> retrieveApplicationStatus() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Applicant> applicationStatusList=applicantDAO.viewApplicationStatus();
		List<ApplicantModel> applicantModelList=new ArrayList<ApplicantModel>();
		for(Applicant applicant:applicationStatusList){
			ApplicantModel applicantMdl=new ApplicantModel();
			applicantMdl.setApplicationStatus(applicant.getApplicationStatus());
			applicantModelList.add(applicantMdl);
		}
		return applicantModelList ;
	}

	@Override
	public List<ApplicantModel> retreiveResultUpdate() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Applicant> resultUpdateList=applicantDAO.viewResultStatus();
		System.out.println(resultUpdateList);
		List<ApplicantModel> applicantModelList=new ArrayList<ApplicantModel>();
		for(Applicant applicant:resultUpdateList){
			ApplicantModel applicantMdl=new ApplicantModel();
			applicantMdl.setResultUpdate(applicant.getResultUpdate());
			applicantModelList.add(applicantMdl);
		}
		return applicantModelList ;
	}
	@Override
	public List<ApplicantModel> retreiveOfferLetter() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Applicant> offerLetterList=applicantDAO.viewOfferLetter();
		List<ApplicantModel> applicantModelList=new ArrayList<ApplicantModel>();
		for(Applicant applicant:offerLetterList){
			ApplicantModel applicantMdl=new ApplicantModel();
			applicantMdl.setFile_name(applicant.getFile_name());
			applicantMdl.setFile_data(applicant.getFile_data());
			applicantModelList.add(applicantMdl);
		}
		return applicantModelList ;
	
	}}
