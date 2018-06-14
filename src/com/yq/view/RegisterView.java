package com.yq.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterView extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.print("<html><head><title>注册</title></head>");
		out.print("<body><form action=register  method=post>"
				+ "<h3>注册</h3>用户名：<input type=text name=userName /><br/>"
				+ "密码：<input type=password name=pwd /><br/>"
				+ "确认密码：<input type=password name=pwd1 /><br/>"
				+ "手机号码：<input type=text name=phone /><br/>"
				+ "<input type=submit value=注册 ><input type=reset value=重置 > "
				+ "</form></body></html>");
		out.close();
	}
}
