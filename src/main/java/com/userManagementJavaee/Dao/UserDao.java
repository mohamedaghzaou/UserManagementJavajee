package com.userManagementJavaee.Dao;

import java.util.List;

import com.userManagementJavaee.beans.User;

public interface UserDao {
	
	List<User> findAll();
	User findById(long id);
	boolean deleteById(long id);
	boolean update(User u);
	void save(User u);
	boolean login(String username , String password);

}
