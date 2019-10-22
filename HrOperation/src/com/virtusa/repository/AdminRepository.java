package com.virtusa.repository;

import java.util.ArrayList;
import java.util.List;

import com.virtusa.entities.Admin;

public class AdminRepository {
private static List<Admin> jobs=new ArrayList<Admin>();
	
	public static boolean add(Admin admin){
		return jobs.add(admin);
	}
	

}
