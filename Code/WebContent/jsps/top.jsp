<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		background: #4682B4; 
	}
	a {
		text-transform:none;
		text-decoration:none;
	} 
	a:hover {
		text-decoration:underline;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;">CS 480</h1>
<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a>	|&nbsp;
			<a href="<c:url value='/jsps/user/initialize.jsp'/>" target="_parent">Initialize Database</a> |&nbsp;
		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };
			<a href="<c:url value='/jsps/item.jsp'/>" target="body">Query Result</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/company/companyPage.jsp'/>" target="body">Company Entity</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/employee/employeePage.jsp'/>" target="body">Employee Entity</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/hourly_employee/hourly_employeePage.jsp'/>" target="body">Hourly Employee Entity</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/queries/query_display.jsp'/>" target="body">Queries</a>
		</c:otherwise>
	</c:choose>

</div>
  </body>
</html>
