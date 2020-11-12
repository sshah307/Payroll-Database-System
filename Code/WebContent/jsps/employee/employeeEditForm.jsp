<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Edit Employess Data</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">

  </head>
  
  <body>
  <h1>Edit Employee</h1>

<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='updateEmployee'/>" method="post">

	<input type="hidden" name="method" value="updateEmployee"/>
	Employee ID  :<input type="text" name="employee_id" value="<c:out value='${employeeInfo.employee_id }'/>" readonly = "readonly" />
	<br/>
	Company Id   ：<input type="text" name="compny_id" value="${employeeInfo.compny_id }"/>
	<br/>
	User   ：<input type="text" name="user" value="${employeeInfo.user }"/>
	<br/>
	Employee Name   :<input type="text" name="name" value = "${employeeInfo.name }" />
	<br/>
	Date of Hiring  ：<input type="text" name="date_of_hiring" value="${employeeInfo.date_of_hiring }"/>
	<br/>
	Gender  ：<input type="text" name="gender" value="${employeeInfo.gender}"/>
	<br/>
	Date of Birth  ：<input type="text" name="date_of_birth" value="${employeeInfo.date_of_birth }"/>
	<br/>
	
	<input type="submit" value="Edit"/>
</form>
  </body>
</html>