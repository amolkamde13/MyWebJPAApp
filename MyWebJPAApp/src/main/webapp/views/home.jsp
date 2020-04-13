<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form action="/emp" method="POST">
			<input type="text" name="empId">
			<input type="text" name="empName">
			<input type="submit" value="Add">
		</form>
		
		<form action="updateEmp" method="PUT">
			<input type="text" name="empId">
			<input type="text" name="empName">
			<input type="submit" value="Update">
		</form>
		
		<form action="/emp" method="DELETE">
			<input type="text" name="empId">
			<input type="submit" value="Delete">
		</form>
		
		<form action="emp" method="GET">
			<input type="text" name="empId">
			<input type="submit" value="Search">
		</form>
		
		<form action="search" method="POST">
			<input type="text" placeholder="Enter Employee Name" name="empName">
			<input type="text" placeholder="Enter Company Name" name="companyName">
			<input type="text" placeholder="Enter Address" name="address">
			<input type="text" placeholder="Enter City" name="city">
			<input type="text" placeholder="Enter Country" name="country">
			<input type="submit" value="Search">
		</form>
</body>
</html>