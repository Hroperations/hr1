package com.virtusa.service;

import java.sql.SQLException;

import com.virtusa.dao.UserDAO;
import com.virtusa.factory.UserFactory;
import com.virtusa.model.UserModel;

public class UserServiceImpl implements UserService{
  
private UserDAO userDAO=null;
	
	public UserServiceImpl() {
		this.userDAO=UserFactory.createUserDAO();
	}
	
	public String userAuthenticationService(UserModel userModel) {
		// TODO Auto-generated method stub
		boolean userValid=false;
		try {
			userValid = userDAO.userAuth(userModel.getUserName(), userModel.getPassword());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String userType=null;
		try{
		if(userValid) {
			userType=userDAO.retrieveUserType(userModel.getUserName());	
		}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userType;
	}
	
}
