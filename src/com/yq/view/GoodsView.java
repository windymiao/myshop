package com.yq.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yq.bean.Goods;
import com.yq.bean.User;

public class GoodsView extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���������е����ݻ�ȡ����ʹ��getAttribute
		List<Goods> list = (List<Goods>) request.getAttribute("list");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>��ҳ</TITLE></HEAD>");
		out.println("  <BODY>"
				+ "<div>��ӭ"+user.getName()+"���������̳�</div>");
		out.print("    <table><tr>"
				+ "<td>��Ʒ���</td>"
				+ "<td>��Ʒ����</td>"
				+ "<td>��Ʒ����</td>"
				+ "<td>��Ʒ�۸�</td>"
				+ "<td>��Ʒ����</td>"
				+ "</tr>");
		for(Goods goods : list){
			out.print("<tr>"
					+ "<td>"+goods.getGid()+"</td>"
					+ "<td>"+goods.getGname()+"</td>"
					+ "<td>"+goods.getGtype()+"</td>"
					+ "<td>"+goods.getGprice()+"</td>"
					+ "<td>"+goods.getGnum()+"</td>"
					+ "</tr>");
		}		
		out.print("</table>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
