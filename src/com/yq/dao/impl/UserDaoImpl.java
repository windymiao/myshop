package com.yq.dao.impl;

import java.sql.ResultSet;

import com.yq.bean.User;
import com.yq.dao.BaseDao;
import com.yq.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public boolean addUser(User user) {
		String sql = "insert into user values(null,?,?,?)";
		boolean flage = executUpdate(sql, user.getName(),user.getPassword(),user.getPhone());
		return flage;
	}

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getEntity(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

}
