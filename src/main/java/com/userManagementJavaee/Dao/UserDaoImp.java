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
	
	public UserDaoImp() {
		daoFactory = DaoFactory.getInstance();
	}
	

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> users = null;
		ResultSet resultset = null;
		
		try
		(
				Connection connection =  daoFactory.getConnection();
				Statement statement = connection.createStatement();
		)
		{
			users = new ArrayList<>();
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
				if(!resultset.isClosed()) {
					resultset.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return users;
		
	}

	@Override
	public User findById(long id) {
		User user = null;
		ResultSet resultset = null;
		try(
				Connection connection =  daoFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from userInfos where id = ?");
				
			) {
			
			statement.setLong(1, id);
			resultset = statement.executeQuery();
			
			if(resultset.next()) {
				user = new User(
						resultset.getInt(1),
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
				if(resultset!=null) {
					resultset.close();
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return user;		
	}

	@Override
	public boolean deleteById(long id) {
		boolean isDeleted = false;
		try(
				Connection connection =  daoFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement("delete from userInfos  where id = ?");
		) 
		{
			statement.setLong(1, id);
			isDeleted =statement.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDeleted;
	}

	@Override
	public boolean update(User u) {
		daoFactory = DaoFactory.getInstance();
		boolean isUpdated = false;
		try
		(
				Connection connection =  daoFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement("update userInfos set  firstName =? , lastName = ? , Address=?, Email = ? , phoneNUmber=? , sex=? "
						+ "where id =?");
		)
		{
			statement.setInt(7, u.getId());
			statement.setString(1, u.getFirstName());
			statement.setString(2, u.getLastName());
			statement.setString(3, u.getAddress());
			statement.setString(4, u.getEmail());
			statement.setString(5, u.getPhoneNumber());
			statement.setString(6, u.getSex());
			isUpdated= statement.executeUpdate()==1;
		}catch(Exception e) {
			e.printStackTrace();
			
		}	
		return isUpdated;
	}

	@Override
	public void save(User u) {
		
		
		
		try
		(
				Connection connection =  daoFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement("insert into userInfos (firstName,lastName,Address,Email,phoneNUmber,sex)"
						+ "  values(?,? ,?,?,?,?)");
		)
		{
			statement.setString(1, u.getFirstName());
			statement.setString(2, u.getLastName());
			statement.setString(3, u.getAddress());
			statement.setString(4, u.getEmail());
			statement.setString(5, u.getPhoneNumber());
			statement.setString(6, u.getSex());
			 statement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	@Override
		public boolean login(String username , String password) {
			ResultSet r = null;
		try
		(
				Connection connection =  daoFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from Employee where username = ? and password = ?");
		)
		{
			statement.setString(1,username );
			statement.setString(2,password);

			r =  statement.executeQuery();
			if(r.next()) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

}
