package com.userManagementJavaee.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.DriverConnectionFactory;

public class DaoFactory {
	
	
	private String url;
	private String username;
	private String password;
	public DaoFactory(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	
	public static DaoFactory getInstance() {
		 DaoFactory doa = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");			
		}catch(Exception e) {
				
		}
		
		doa =new DaoFactory("jdbc:mysql://localhost:3306/userManagement","root", "password");
		
		return doa;
	}
	
	public Connection getConnection() throws SQLException {
		return  DriverManager.getConnection(url, username, password);
	}
	public UserDaoImp getUserDaoImp() throws SQLException {
		return  new UserDaoImp();
	}

}
