package com.virtusa.entities;

public class Job {
	private int JobId;
	private String jobTitle;
	private String eligibilityCriteria;
	private int opportunityId;
	public int getOpportunityId() {
		return opportunityId;
	}
	public void setOpportunityId(int opportunityId) {
		this.opportunityId = opportunityId;
	}
	private String mailId;
	public int getJobId() {
		return JobId;
	}
	public void setJobId(int jobId) {
		JobId = jobId;
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
		return "Job [JobId=" + JobId + ", jobTitle=" + jobTitle + ", eligibilityCriteria=" + eligibilityCriteria
				+ ", opportunityId=" + opportunityId + ", mailId=" + mailId + "]";
	}
	
	
}
