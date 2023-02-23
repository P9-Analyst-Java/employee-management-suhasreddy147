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
	
	p{
		padding:10px;
		border:1px solid black;
		width:200px;
		text-align: center;
		background-color:#d4e6f1;
		color: red;
		font-size: 25px; 
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
	<h1 align="center">Employee History Screen</h1>
	<hr color="black"><br>
		<p>${name.firstName} ${name.lastName} (#${name.empId})</p>

	<table>
	<tr>
		<th bgcolor=#A9DFBF>ORGANIZATION</th>
		<th bgcolor=#A9DFBF>PERIOD</th>
		<th bgcolor=#A9DFBF>LOCATION</th>
		<th bgcolor=#A9DFBF>POST</th>
		<!-- <th>EMPLOYEE PHOTO</th> -->
	</tr>
	<c:forEach var="employmentList" items="${employmentList}">
		<tr>
		<td>${employmentList.organizationName}</td>
		<td>${employmentList.fromDate}  ~   ${employmentList.untilDate}</td>
		<td>${employmentList.location}</td>
		<td>${employmentList.post}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>