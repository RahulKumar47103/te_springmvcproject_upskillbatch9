<%@page import="com.te.springmvcproject.beans.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String str=(String)request.getAttribute("msg"); 
    EmployeeBean employeeBean=(EmployeeBean)request.getAttribute("data");
    %>
    
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search data</title>
</head>
<body>

	<% if(str!=null && !str.isEmpty()){%>
	<%=str %>
	<%} %>
	<fieldset>
	<legend>search</legend>
	<form action="" method="get"> 
		<table>
			<tr>
				<td>Enter id to search</td>
				<td>:</td>
				<td> <input type="text" name="id" required="required"> </td>				
			</tr>
			<tr>
				<td><input type="submit" value="search"></td>
			</tr>
		
		</table>
	</form>
	</fieldset>

</body>
</html>