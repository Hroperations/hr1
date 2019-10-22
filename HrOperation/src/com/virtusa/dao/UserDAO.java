package com.virtusa.dao;

import java.sql.SQLException;

public interface UserDAO {
  
	public boolean userAuth(String userName,String password) throws ClassNotFoundException, SQLException;
	public String retrieveUserType(String userName) throws ClassNotFoundException, SQLException;
	
}
