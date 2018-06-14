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
		//��������ı����ʽ
		request.setCharacterEncoding("utf-8");
		//��ȡ������
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
				//��ȡsession  session��ʾһ�λỰ����������Ĵ򿪵�������Ľ���
				HttpSession session = request.getSession();
				//��user�������sessionn��
				session.setAttribute("user", user);
				//��ת��Ϊ���֣�  ת�����ض���
				request.getRequestDispatcher("GoodsServlet").forward(request, response);
			}else{
				System.out.println("�Բ���ע��ʧ�ܣ�");
			}
		}else{
			System.out.println("�����������벻һ�£�");
		}
		
	}

}
