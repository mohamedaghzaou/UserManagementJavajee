package com.userManagementJavaee.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


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
		Connection c = DriverManager.getConnection(url, username, password);
		c.setAutoCommit(false);
		return  c;
	}
	public UserDaoImp getUserDaoImp() throws SQLException {
		return  new UserDaoImp();
	}

}
