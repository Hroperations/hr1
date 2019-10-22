package com.virtusa.model;

import java.io.Reader;

public class ApplicantModel {
	private String approve;
	private String reject;
	public String getApprove() {
		return approve;
	}
	public void setApprove(String approve) {
		this.approve = approve;
	}
	public String getReject() {
		return reject;
	}
	public void setReject(String reject) {
		this.reject = reject;
	}
	private String applicationStatus;
	private String resultUpdate;
	private String resume;
	private int jobId;
	private String jobTitle;
	private String eligibilityCriteria;
	private String mailId;
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
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}
	public void setEligibilityCriteria(String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	@Override
	public String toString() {
		return "ApplicantModel [approve=" + approve + ", reject=" + reject + ", applicationStatus=" + applicationStatus
				+ ", resultUpdate=" + resultUpdate + ", resume=" + resume + ", jobId=" + jobId + ", jobTitle="
				+ jobTitle + ", eligibilityCriteria=" + eligibilityCriteria + ", mailId=" + mailId + ", file_name="
				+ file_name + ", file_data=" + file_data + ", fileId=" + fileId + "]";
	}
	
}