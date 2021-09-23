package com.userManagementJavaee.Dao;

import java.util.List;

import com.userManagementJavaee.beans.User;

public interface UserDao {
	
	List<User> findAll();
	User findById(long id);
	void deleteById(long id);
	void update(User u);
	void save(User u);

}
