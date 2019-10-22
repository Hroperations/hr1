package com.virtusa.entities;

public class Interviewer extends User{
	
public Interviewer() {
		
	}
	private String interviewerId;
	public String getInterviewerId() {
		return interviewerId;
	}
	public void setInterviewerId(String interviewerId) {
		this.interviewerId = interviewerId;
	}
	@Override
	public String toString() {
		return "Interviewer [interviewerId=" + interviewerId + "]";
	}
	

}
