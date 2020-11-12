<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Edit Hourly Employess Data</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">

  </head>
  
  <body>
  <h1>Edit Hourly Employee</h1>

<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='updateHourly_employee'/>" method="post">

	<input type="hidden" name="method" value="updateHourly_employee"/>
	Employee SSN   :<input type="text" name="hourly_ssn" value = "${hourlyemployeeInfo.hourly_ssn }" />
	<br/>
	Employee ID		:<input type="text" name="employee_id" value="${hourlyemployeeInfo.employee_id }"/>
	<br/>
	Hours Worked   ：<input type="text" name="hrs_worked" value="${hourlyemployeeInfo.hrs_worked }"/>
	<br/>
	Rate  ：<input type="text" name="rate" value="${hourlyemployeeInfo.rate }"/>
	<br/>
	Starting Pay Date  ：<input type="text" name="pay_start_date" value="${hourlyemployeeInfo.getDateStart()}"/>
	<br/>
	Ending Pay Date ：<input type="text" name="pay_end_date" value="${hourlyemployeeInfo.getEnd() }"/>
	<br/>

	<input type="submit" value="Edit"/>
	
</form>
  </body>
</html>