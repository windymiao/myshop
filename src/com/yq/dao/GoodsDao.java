package com.yq.dao;

import java.util.List;

import com.yq.bean.Goods;
import com.yq.bean.PageBean;

public interface GoodsDao {

	public Goods findById(int id);
	
	public List<Goods> findAll();
	
	public PageBean findPage(int pageNow);
	
	
}
