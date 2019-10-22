package com.virtusa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.virtusa.entities.User;
import com.virtusa.integrate.ConnectionManager;
import com.virtusa.repository.UserRepository;
import com.virtusa.utilities.UserTypes;

public class UserDAOImpl implements UserDAO{
	
	User user=new User();
	private List<User> userList=null;
	
	
	public UserDAOImpl() {
		this.userList=UserRepository.getUserRepository();
	}
	static String usernameDb;
	static String passwordDb;
	public boolean userAuth(String userName, String password)throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		boolean result=false;
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=connection.prepareStatement("select userName,password from hroperations.users");
		ResultSet resultSet=statement.executeQuery();
		
		
		while(resultSet.next()){
			usernameDb=resultSet.getString(1);
			passwordDb=resultSet.getString(2);
			
		if(usernameDb.equals(userName))
		{
			
			if(passwordDb.equals(password))
				result=true;
		}
		}
		return result;
	}

	public String retrieveUserType(String userName) {
		// TODO Auto-generated method stub
		
		String returnUserType=null;
		for(User user:userList) {
			if(user.getUserName().equals(userName)){
			UserTypes userTypes=user.getUserType();

			switch(userTypes) {
			
			case APPLICANT:
				returnUserType="APPLICANT";
				break;
				
			case ADMIN:
				returnUserType="ADMIN";
				break;
			case INTERVIEWER:
				returnUserType="INTERVIEWER";
				break;
			case HR:
				returnUserType="HR";
				break;	
			case MANAGER:
				returnUserType="MANAGER";
				break;	
				
			}
			
		}
		}
		return returnUserType;
	}
	
	
	

}
