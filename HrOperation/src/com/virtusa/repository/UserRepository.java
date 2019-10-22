package com.virtusa.repository;

import java.util.ArrayList;
import java.util.List;

import com.virtusa.entities.Admin;
import com.virtusa.entities.Applicant;
import com.virtusa.entities.Hr;
import com.virtusa.entities.Interviewer;
import com.virtusa.entities.Manager;
import com.virtusa.entities.User;
import com.virtusa.utilities.UserTypes;

public class UserRepository {
    
	private static List<User> userRepository=
			new ArrayList<User>();
	static{
		
		Applicant applicant=new Applicant();
		applicant.setUserName("applicant");
		applicant.setPassword("applicant@123");
		applicant.setFirstName("steve");
		applicant.setLastName("smith");
		applicant.setEmailAddress("stevesmith@gmail.com");
		applicant.setPhoneNumber("900123412");
		applicant.setApplicantId(1);
		applicant.setUserType(UserTypes.APPLICANT);
		userRepository.add(applicant);
		
		Admin admin=new Admin();
		admin.setUserName("admin");
		admin.setPassword("admin@123");
		admin.setFirstName("dinesh");
		admin.setLastName("karthik");
		admin.setEmailAddress("admin@virtusa.com");
		admin.setPhoneNumber("9898512123");
		admin.setAdminId("AD001");
		admin.setUserType(UserTypes.ADMIN);
		userRepository.add(admin);
		
		Hr hr=new Hr();
		hr.setUserName("humanresource");
		hr.setPassword("hr@123");
		hr.setFirstName("virat");
		hr.setLastName("kohli");
		hr.setEmailAddress("kohli@virtusa.com");
		hr.setPhoneNumber("8787655412");
		hr.setHrId("H001");
		hr.setUserType(UserTypes.HR);
		userRepository.add(hr);
		
		Manager manager=new Manager();
		manager.setUserName("manager");
		manager.setPassword("manager@123");
		manager.setFirstName("rohith");
		manager.setLastName("sharma");
		manager.setEmailAddress("rohith@gmail.com");
		manager.setPhoneNumber("9090121345");
		manager.setManagerId("M001");
		manager.setUserType(UserTypes.MANAGER);
		userRepository.add(manager);
		
		Interviewer interviewer=new Interviewer();
		interviewer.setUserName("interviewer");
		interviewer.setPassword("interviewer@123");
		interviewer.setFirstName("rajesh");
		interviewer.setLastName("khanna");
		interviewer.setEmailAddress("rajesh@hotmail.com");
		interviewer.setPhoneNumber("8989454512");
		interviewer.setInterviewerId("I001");
		interviewer.setUserType(UserTypes.INTERVIEWER);
		userRepository.add(interviewer);
	}
	public static List<User> getUserRepository() {
		return userRepository;
	}
	
}
