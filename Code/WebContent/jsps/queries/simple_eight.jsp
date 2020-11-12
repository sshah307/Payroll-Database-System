<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
 
<html>


   <body>
   	  <h1>Complex Query 5</h1>
   	  <h3>Description</h3>
      <p> Getting id, pay rate and state tax of hourly employees whose pay rate is more than $20.00 and paying state tax more then the average employees. </p>
      <br>
      
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/pay_role"
         user = "root"  password = "5824"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
		SELECT employee_id, rate, state
		FROM hourly_employee
		JOIN hourly_tax ON hourly_employee.hourly_ssn = hourly_tax.hourly_ssn
		WHERE state > (SELECT AVG(state) from hourly_tax
		JOIN hourly_employee ON hourly_employee.hourly_ssn = hourly_tax.hourly_ssn
		HAVING rate > 20.00 )
      </sql:query>
 
      <table border = "1" width = "100%">
         <tr>
            <th>employee_id</th>
			<th>rate</th>
			<th>state</th>
         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><c:out value = "${row.employee_id}"/></td>
               <td><c:out value = "${row.rate}"/></td>
               <td><c:out value = "${row.state}"/></td>
              
            </tr>
         </c:forEach>
      </table>
 
   </body>
</html>