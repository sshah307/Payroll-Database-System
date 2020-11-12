<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
 
<html>


   <body>
      <h1>Simple Query 1</h1>
      <h3>Description</h3>
      <p> Getting the average employee size for a particular company from all the different locations. </p>
      <br>
      
      
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/pay_role"
         user = "root"  password = "5824"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
         SELECT AVG(employee_size) AS CompanySize
		 FROM company
		 WHERE compny_name = 'Skiptube';
      </sql:query>
 
      <table border = "1" width = "100%">
         <tr>
            <th>CompanySize</th>

         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><c:out value = "${row.CompanySize}"/></td>
            </tr>
         </c:forEach>
      </table>
 
   </body>
</html>