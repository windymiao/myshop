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
		
		out.print("<html><head><title>ע��</title></head>");
		out.print("<body><form action=register  method=post>"
				+ "<h3>ע��</h3>�û�����<input type=text name=userName /><br/>"
				+ "���룺<input type=password name=pwd /><br/>"
				+ "ȷ�����룺<input type=password name=pwd1 /><br/>"
				+ "�ֻ����룺<input type=text name=phone /><br/>"
				+ "<input type=submit value=ע�� ><input type=reset value=���� > "
				+ "</form></body></html>");
		out.close();
	}
}
