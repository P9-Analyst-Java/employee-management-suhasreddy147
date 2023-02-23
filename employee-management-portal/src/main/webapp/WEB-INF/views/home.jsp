<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	<div style="text-align:center">
	table{
		width:600px
	}
	
	form{
		padding:5px;
		text-align: left;
	}
	
	input{
		border:1px solid black;
		padding:10px;
		background-color:#d4e6f1
	}
	
	button{
		background-color: #4CAF50; /* Green */
		padding:10px;
		color: white;
		border: none;
	}
	
	td{
		border:1px solid black;
		padding:5px;
		border-collapse: collapse;
		text-align: center;
		background-color:#d4e6f1
	}
	th{
		width:1000px;
		border:1px solid black;
		background-color:#5499c7
	}
	span{
		color:green;
		font-weight: bold;
		font-family: sans-serif;
		font-size: large;
	}
	a.button {
		background-color: #4CAF50; /* Green */
		border: none;
		color: white;
		padding: 16px 32px;
		text-align: center;
		text-decoration: none;
		display: inline-block;
		font-size: 16px;
		margin: 4px 2px;
		transition-duration: 0.4s;
		cursor: pointer;
	}
 
	<hr style="height:2px;border-width:0;color:gray;background-color:gray">
</style>


</head>
<body bgcolor="E3EBEE">
	<h1 align="center">Employee Search List Screen</h1>
	<hr color="black"><br>
	<form action="/search" method="post">
	Emp ID: <input type="number" id="empId" name="empId" value="0"/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	Emp Name: <input type="text" id="firstName" name="firstName" value="enter name"/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	Emp Gender: <input type="text" id="gender" name="gender" value="enter gender"/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	<button type="submit" value="submit">Search</button>
	</form>
	<br>
	<a href="${contextRoot}/employee" class="button">Add an employee</a>
	<a href="${contextRoot}/export" class="button">Download</a>
	<table>
	<tr>
		<th bgcolor=#A9DFBF>EMPLOYEE</th>
		<th bgcolor=#A9DFBF>CONTACT</th>
		<th bgcolor=#A9DFBF>LEVEL AND POST</th>
		<th bgcolor=#A9DFBF>ACTION</th>
		<!-- <th>EMPLOYEE PHOTO</th> -->
	</tr>
	<c:forEach var="employeeList" items="${employeeList}">
		<tr>
		<td><h4>${employeeList.firstName} ${employeeList.lastName}</h4><br>#${employeeList.empId}</td>
		<td><p>${employeeList.mobileNum}<br>${employeeList.emailId}</p></td>
		<td>${employeeList.empLevel}<br>${employeeList.postName}</td>
		<td><a href="${contextRoot}/employee/${employeeList.empId}">Edit/</a>
		<a href="${contextRoot}/${employeeList.empId}">Delete/</a>
		<a href="${contextRoot}/employments/${employeeList.empId}">Employments</a></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>