package com.userManagementJavaee.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.userManagementJavaee.beans.User;

public class UserDaoImp implements UserDao {
	
	private DaoFactory daoFactory= null;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		daoFactory = DaoFactory.getInstance();
		try {
			
			connection =  daoFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select * from userInfos");
			
			while(resultset.next()) {
				User u = new User(resultset.getInt(1),
						resultset.getString(2),
						resultset.getString(3),
						resultset.getString(4),
						resultset.getString(5),
						resultset.getString(6),
						resultset.getString(7));
				users.add(u);
			}
			
		}catch(Exception e) {
			
		}
		connection = null;
		statement = null;
		resultset = null;
		return users;
		
	}

	@Override
	public User findById(long id) {
		User user = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		daoFactory = DaoFactory.getInstance();
		try {
			
			connection =  daoFactory.getConnection();
			statement = connection.prepareStatement("select * from userInfos where id = ?");
			statement.setLong(1, id);
			resultset = statement.executeQuery();
			
			while(resultset.next()) {
				user = new User(resultset.getInt(1),
						resultset.getString(2),
						resultset.getString(3),
						resultset.getString(4),
						resultset.getString(5),
						resultset.getString(6),
						resultset.getString(7));
				
			}
			
		}catch(Exception e) {
			
		}
		connection = null;
		statement = null;
		resultset = null;
		return user;		
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		
	}

}
