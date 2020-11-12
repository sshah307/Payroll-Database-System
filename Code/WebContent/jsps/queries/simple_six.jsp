<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
 
<html>


   <body>
      <h1>Complex Query 3</h1>
      <h3>Description</h3>
      <p> Getting name and id of all the hourly employees whose pay rate is above $25.00. </p>
      <br>
      
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/pay_role"
         user = "root"  password = "5824"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
		SELECT employee.employee_id, name 
		FROM employee
		JOIN hourly_employee ON employee.employee_id = hourly_employee.employee_id
		WHERE rate > 25.00
		ORDER BY employee_id ASC;
      </sql:query>
 
      <table border = "1" width = "100%">
         <tr>
            <th>employee_id</th>
			<th>name</th>
         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><c:out value = "${row.employee_id}"/></td>
               <td><c:out value = "${row.name}"/></td>
              
            </tr>
         </c:forEach>
      </table>
 
   </body>
</html>