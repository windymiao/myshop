package com.yq.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yq.bean.Goods;
import com.yq.bean.PageBean;
import com.yq.service.GoodsService;
import com.yq.service.impl.GoodsServiceImpl;

public class GoodsServlet extends HttpServlet {
		
	GoodsService gs = new GoodsServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PageBean pb = null;
		if(request.getParameter("pageNow")==null){
			pb = gs.findPage(1);
		}else{
			int pageNow  = Integer.parseInt(request.getParameter("pageNow"));
			pb = gs.findPage(pageNow);
		}
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("goods_list.jsp").forward(request, response);
	}

}
