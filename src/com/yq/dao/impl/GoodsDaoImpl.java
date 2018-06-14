package com.yq.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yq.bean.Goods;
import com.yq.bean.PageBean;
import com.yq.dao.BaseDao;
import com.yq.dao.GoodsDao;

public class GoodsDaoImpl extends BaseDao<Goods> implements GoodsDao {

	@Override
	public Goods findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> findAll() {
		String sql  = "select * from goods";
		List<Goods> list = executQuery(sql);
		return list;
	}

	@Override
	public Goods getEntity(ResultSet rs) {
		Goods goods = new Goods();
		try {
			goods.setGid(rs.getInt(1));
			goods.setGname(rs.getString(2));
			goods.setGtype(rs.getString(3));
			goods.setGprice(rs.getDouble(4));
			goods.setGnum(rs.getInt(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goods;
	}

	@Override
	public PageBean findPage(int pageNow) {
		PageBean pb = new PageBean();
		String sql = "select count(gid) from goods";
		pb.setPageNow(pageNow);
		pb.setPageSize(3);
		pb.setRowCount(Query(sql));
		sql = "select * from goods limit ?,?";
		List<Goods> list = executQuery(sql, (pageNow-1)*pb.getPageSize(),pb.getPageSize());
		pb.setList(list);
		return pb;
	}

}
