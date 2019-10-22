package com.virtusa.repository;

import java.util.ArrayList;
import java.util.List;

import com.virtusa.entities.Applicant;

public class ApplicantRepository {
	private static List<Applicant> jobs=new ArrayList<Applicant>();
	
	public static List<Applicant> get(){
	return jobs;
}

}
