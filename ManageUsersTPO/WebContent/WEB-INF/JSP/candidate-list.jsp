 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="showlist.html" method=POST>

<c:forEach items="${userList}" var="user">
				<tr>
					<td><c:out value="${user.username}" /></td>
					<td><c:out value="${user.company_id}" /></td>
				</tr><br>
</c:forEach>
<br><br>
Edit User List:<select name="option">
	<option value="Add" >Add</option>
	<option value="Delete" >Delete</option>
</select>
<input type=submit value=submit />
</form>
</body>
</html>