package com.virtusa.entities;

import java.io.File;

public class Resume {

	public Resume(){
		
	}
	private int resumeId;
	private String resume;
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	@Override
	public String toString() {
		return "Resume [resumeId=" + resumeId + ", resume=" + resume + "]";
	}
	
	
	
}
