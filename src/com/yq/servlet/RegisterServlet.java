package com.yq.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yq.bean.User;
import com.yq.service.UserService;
import com.yq.service.impl.UserServiceImpl;

public class RegisterServlet extends HttpServlet {

	UserService us = new UserServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		//设置请求的编码格式
		request.setCharacterEncoding("utf-8");
		//获取表单数据
		String name = request.getParameter("userName");
		String password = request.getParameter("pwd");
		String pwd1 = request.getParameter("pwd1");
		String phone = request.getParameter("phone");
		user.setName(name);
		user.setPassword(password);
		user.setPhone(phone);
		if(password.equals(pwd1)){
			boolean flage = us.addUser(user);
			if(flage){
				//获取session  session表示一次会话，从浏览器的打开到浏览器的结束
				HttpSession session = request.getSession();
				//将user对象存入sessionn中
				session.setAttribute("user", user);
				//跳转分为两种：  转发和重定向
				request.getRequestDispatcher("GoodsServlet").forward(request, response);
			}else{
				System.out.println("对不起！注册失败！");
			}
		}else{
			System.out.println("两次输入密码不一致！");
		}
		
	}

}
