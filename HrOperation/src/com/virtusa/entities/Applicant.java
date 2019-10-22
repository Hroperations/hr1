package com.virtusa.entities;

import java.io.Reader;

public class Applicant extends User {
  
public Applicant() {
		
	}
	private String applicationStatus;
	private String resultUpdate;
	private String file_name;
	private String file_data;
	private int fileId;
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_data() {
		return file_data;
	}
	public void setFile_data(String string) {
		this.file_data = string;
	}
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public String getResultUpdate() {
		return resultUpdate;
	}
	public void setResultUpdate(String resultUpdate) {
		this.resultUpdate = resultUpdate;
	}
	private Resume resume;
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	private Job job;
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	private int applicantId;
	public int getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}
	@Override
	public String toString() {
		return "Applicant [applicationStatus=" + applicationStatus + ", resultUpdate=" + resultUpdate + ", file_name="
				+ file_name + ", file_data=" + file_data + ", fileId=" + fileId + ", resume=" + resume + ", job=" + job
				+ ", applicantId=" + applicantId + "]";
	}
	
	
}
