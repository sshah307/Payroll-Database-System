<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Company</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">

  </head>
  
  <body>
  <h1>Add New Company</h1>

<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/UserServletCompany'/>" method="post">

	<input type="hidden" name="method" value="registCompany"/>
	Company ID   :<input type="text" name="compny_id" value="${form.compny_id }"/>
	<br/>
	Company Name	:<input type="text" name="compny_name" value="${form.compny_name }"/>
	<br/>
	Company Address ：<input type="text" name="compny_address" value="${form.compny_address }"/>
	<br/>
	Company Contact ：<input type="text" name="contact_no" value="${form.contact_no }"/>
	<br/>
	Company Size  ：<input type="text" name="employee_size" value="${form.employee_size }"/>
	<br/>
	
	<input type="submit" value="Add"/>
</form>
  </body>
</html>