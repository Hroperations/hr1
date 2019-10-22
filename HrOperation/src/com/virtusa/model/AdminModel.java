package com.virtusa.model;

public class AdminModel {
	private int jobId;
	private String jobTitle;
	private String eligibilityCriteria;
	private int opportunityId;
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
	public int getOpportunityId() {
		return opportunityId;
	}
	public void setOpportunityId(int opportunityId) {
		this.opportunityId = opportunityId;
	}
	@Override
	public String toString() {
		return "AdminModel [jobId=" + jobId + ", jobTitle=" + jobTitle + ", eligibilityCriteria=" + eligibilityCriteria
				+ ", opportunityId=" + opportunityId + "]";
	}
	

}
