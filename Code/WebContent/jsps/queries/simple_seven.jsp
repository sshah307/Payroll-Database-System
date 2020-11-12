<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
 
<html>


   <body>
      <h1>Complex Query 4</h1>
      <h3>Description</h3>
      <p> Showing data of all the company who has more then 900 employees. </p>
      <br>
      
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/pay_role"
         user = "root"  password = "5824"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
		SELECT company.compny_id, employee_size
		FROM employee
		JOIN company ON employee.compny_id = company.compny_id
		GROUP BY compny_id
		HAVING employee_size > 900;
      </sql:query>
 
      <table border = "1" width = "100%">
         <tr>
            <th>compny_id</th>
			<th>employee_size</th>
         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><c:out value = "${row.compny_id}"/></td>
               <td><c:out value = "${row.employee_size}"/></td>
              
            </tr>
         </c:forEach>
      </table>
 
   </body>
</html>