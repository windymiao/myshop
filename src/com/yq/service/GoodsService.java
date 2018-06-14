package com.yq.service;

import java.util.List;

import com.yq.bean.Goods;
import com.yq.bean.PageBean;

public interface GoodsService {
	
	public Goods findById(int id);
	
	public List<Goods> findAll();
	
	public PageBean findPage(int pageNow);
}
