package com.virtusa.utilities;

public enum UserTypes {
	
	APPLICANT("APPLICANT"),ADMIN("ADMIN"),HR("HR"),MANAGER("MANAGER"),INTERVIEWER("INTERVIEWER");
	private String val;
	private UserTypes(String val) {
		this.val=val;
	}
	public String getVal() {
		return val;	
	}

}
