package com.yq.service.impl;

import java.util.List;

import com.yq.bean.Goods;
import com.yq.bean.PageBean;
import com.yq.dao.GoodsDao;
import com.yq.dao.impl.GoodsDaoImpl;
import com.yq.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {

	GoodsDao gd = new GoodsDaoImpl();
	@Override
	public Goods findById(int id) {
		// TODO Auto-generated method stub
		return gd.findById(id);
	}

	@Override
	public List<Goods> findAll() {
		// TODO Auto-generated method stub
		return gd.findAll();
	}

	@Override
	public PageBean findPage(int pageNow) {
		// TODO Auto-generated method stub
		return gd.findPage(pageNow);
	}

}
