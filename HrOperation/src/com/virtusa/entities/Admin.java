package com.virtusa.entities;

public class Admin extends User {

public Admin() {
		
	}
	private Job job;
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	private String adminId;
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	@Override
	public String toString() {
		return "Admin [job=" + job + ", adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber + ", userType=" + userType
				+ ", getJob()=" + getJob() + ", getAdminId()=" + getAdminId() + ", getUserName()=" + getUserName()
				+ ", getPassword()=" + getPassword() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getEmailAddress()=" + getEmailAddress() + ", getPhoneNumber()=" + getPhoneNumber()
				+ ", getUserType()=" + getUserType() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
}
