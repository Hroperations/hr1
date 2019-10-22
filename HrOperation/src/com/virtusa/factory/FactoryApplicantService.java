package com.virtusa.factory;

import com.virtusa.service.ApplicantService;
import com.virtusa.service.ApplicantServiceImpl;

public class FactoryApplicantService {
public static ApplicantService createApplicantService(){
		
	ApplicantService applicantService=new ApplicantServiceImpl();
		return applicantService;
	}

}
