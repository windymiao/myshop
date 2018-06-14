<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <table>
    	<tr>
    		<td>编号</td>
    		<td>商品名称</td>
    		<td>类型</td>
    		<td>价格</td>
    		<td>数量</td>
    		<td>操作</td>
    	</tr>
    	<c:forEach items="${pb.list }" var="goods">
    		<tr>
    			<td>${goods.gid }</td>
    			<td>${goods.gname }</td>
    			<td>${goods.gtype }</td>
    			<td>${goods.gprice }</td>
    			<td>${goods.gnum }</td>
    			<td><a style="text-decoration: none" href="GoodsServlet?gid=${goods.gid }">删除</a></td>
    		</tr>
    	</c:forEach>
    	<tr>
    		<td colspan="6">
    			当前${pb.pageNow }页/共${pb.pageCount }页，每页${pb.pageSize }条，共${pb.rowCount }条记录，
    			<c:choose>
    				<c:when test="${ pb.pageNow > 1}">
    					<a href="GoodsServlet?pageNow=1">首页</a>
    					<a href="GoodsServlet?pageNow= ${pb.pageNow-1 }">上一页</a>
    				</c:when>
    				<c:otherwise>
    					首页&nbsp;&nbsp;上一页
    				</c:otherwise>
    			</c:choose>
    			<c:choose>
    				<c:when test="${ pb.pageNow < pb.pageCount}">    					
    					<a href="GoodsServlet?pageNow=${pb.pageNow+1 }">下一页</a>
    					<a href="GoodsServlet?pageNow=${pb.pageCount }">末页</a>
    				</c:when>
    				<c:otherwise>
    					下一页&nbsp;&nbsp;末页
    				</c:otherwise>
    			</c:choose>
    		</td>
    	</tr>
    </table>
    
  </body>
</html>
