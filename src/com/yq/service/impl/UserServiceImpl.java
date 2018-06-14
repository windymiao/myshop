package com.yq.service.impl;

import com.yq.bean.User;
import com.yq.dao.UserDao;
import com.yq.dao.impl.UserDaoImpl;
import com.yq.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao ud = new UserDaoImpl();
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return ud.addUser(user);
	}

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		return ud.login(user);
	}

}
