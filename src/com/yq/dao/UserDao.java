package com.yq.dao;

import com.yq.bean.User;

public interface UserDao {
	
	public boolean addUser(User user);
	
	public boolean login(User user);
}
