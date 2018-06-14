<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    <form action="register" method="post">
    	<h3>注 册</h3>
    	用户名：<input type="text" name="userName"><br>
    	密码：<input type="password" name="pwd"><br>
    	确认密码：<input type="password" name="pwd1"><br>
    	手机号码：<input type="text" name="phone"><br>
    	<input type="submit" value="注 册"><input type="reset" value="重 置">
    </form>
  </body>
</html>
