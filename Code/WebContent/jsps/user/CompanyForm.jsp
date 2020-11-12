<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Payroll Database Application</title>
</head>
<body>
    <center>
        <h1>Payroll Database</h1>
        <h2>
            <a href="CompanyList.jsp?action=/new">Add New Company</a>
            &nbsp;&nbsp;&nbsp;
            <a href="CompanyList.jsp?action=/list">List All Company</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${company != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${company == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${company != null}">
                        Edit Company
                    </c:if>
                    <c:if test="${company == null}">
                        Add New Company
                    </c:if>
                </h2>
            </caption>                <c:if test="${company != null}">
                    <input type="hidden" name="compny_id" value="<c:out value='${company.compny_id}' />" />
                </c:if>           
            <tr>
                <th>compny_name: </th>
                <td>
                    <input type="text" name="compny_name" size="45"
                            value="<c:out value='${company.compny_name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>compny_address: </th>
                <td>
                    <input type="text" name="compny_address" size="45"
                            value="<c:out value='${company.compny_address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>contact_no: </th>
                <td>
                    <input type="text" name="contact_no" size="45"
                            value="<c:out value='${company.contact_no}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>employee_size: </th>
                <td>
                    <input type="text" name="employee_size" size="5"
                            value="<c:out value='${company.employee_size}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>

    </div>   
</body>
</html>