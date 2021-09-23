package com.userManagementJavaee.Dao;

public class DaoFactory {
	
	
	private String url;
	private String username;
	private String password;
	public DaoFactory(String url, String username, String password) {
		super();
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
		
		doa = new DaoFactory("","root", "password");
		
		return doa;
	}

}
