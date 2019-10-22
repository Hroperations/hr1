package com.virtusa.entities;

public class Hr extends User {
  
public Hr() {
		
	}
	private String hrId;
	public String getHrId() {
		return hrId;
	}
	public void setHrId(String hrId) {
		this.hrId = hrId;
	}
	@Override
	public String toString() {
		return "Hr [hrId=" + hrId + "]";
	}
	
}
