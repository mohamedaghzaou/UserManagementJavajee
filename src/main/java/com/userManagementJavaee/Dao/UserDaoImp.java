package com.userManagementJavaee.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			
			
			
			
		}finally {
			try {
				if(!connection.isClosed()) {
					connection.close();
				}
				if(!statement.isClosed()) {
					statement.close();
				}
				if(!resultset.isClosed()) {
					resultset.close();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
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
			
		}finally {
			try {
				if(!connection.isClosed()) {
					connection.close();
				}
				if(!statement.isClosed()) {
					statement.close();
				}
				if(!resultset.isClosed()) {
					resultset.close();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
		Connection connection = null;
		PreparedStatement statement = null;
		daoFactory = DaoFactory.getInstance();
		try {
			
			connection =  daoFactory.getConnection();
			statement = connection.prepareStatement("insert into userInfos (firstName,lastName,Address,Email,phoneNUmber,sex)"
					+ "  values(?,? ,?,?,?,?)");
			statement.setString(1, u.getFirstName());
			statement.setString(2, u.getLastName());
			statement.setString(3, u.getAddress());
			statement.setString(4, u.getEmail());
			statement.setString(5, u.getPhoneNumber());
			statement.setString(6, u.getSex());
			 statement.executeUpdate();
			 connection.commit();
			 
		}catch(Exception e) {
			e.printStackTrace();
			 try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
		}finally {
			try {
				if(!connection.isClosed()) {
					connection.close();
				}
				if(!statement.isClosed()) {
					statement.close();
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		
	}

}
