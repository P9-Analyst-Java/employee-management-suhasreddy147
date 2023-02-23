<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
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
	.error{
		color:red
	}
 
	<hr style="height:2px;border-width:0;color:gray;background-color:gray">
</style>

</head>
<body bgcolor="E3EBEE">
	<h1 align="center">Add/Update Employee</h1>
	<hr color="black"><br>
	<form:form action="${contextRoot}/employeesave" method="post" modelAttribute="employee">
		<label>Employee ID:</label>
		<form:input path="empId" placeholder="Enter id" type="number"/>
		<form:errors path="empId" cssClass="error"/><br><br>
		<label>First Name:</label>
		<form:input path="firstName" placeholder="Enter First name"/>
		<form:errors path="firstName" cssClass="error"/><br><br>
		<label>Last Name:</label>
		<form:input path="lastName" placeholder="Enter Last name"/>
		<form:errors path="lastName" cssClass="error"/><br><br>
		<label>Gender:</label>
		<form:input path="gender" placeholder="Enter gender"/>
		<form:errors path="gender" cssClass="error"/><br><br>
		<label>Date of birth:</label>
		<form:input path="dob" placeholder="Enter date of birth" type="date"/>
		<form:errors path="dob" cssClass="error"/><br><br>
		<label>Pan number:</label>
		<form:input path="panNum" placeholder="Enter PAN number"/>
		<form:errors path="panNum" cssClass="error"/><br><br>
		<label>Aadhar Number:</label>
		<form:input path="aadharNum" placeholder="Enter aadhar number"/>
		<form:errors path="aadharNum" cssClass="error"/><br><br>
		<label>Mobile Number:</label>
		<form:input path="mobileNum" placeholder="Enter mobile number"/>
		<form:errors path="mobileNum" cssClass="error"/><br><br>
		<label>Email ID:</label>
		<form:input path="emailId" placeholder="Enter email Id"/>
		<form:errors path="emailId" cssClass="error"/><br><br>
		<label>Office Mail:</label>
		<form:input path="officeMail" placeholder="Enter office mail"/>
		<form:errors path="officeMail" cssClass="error"/><br><br>
		<label>Permanent Address:</label>
		<form:input path="permanentAddress" placeholder="Enter permanent address"/>
		<form:errors path="permanentAddress" cssClass="error"/><br><br>
		<label>Present Address:</label>
		<form:input path="presentAddress" placeholder="Enter present address"/>
		<form:errors path="presentAddress" cssClass="error"/><br><br>
		<label>Blood Group:</label>
		<form:input path="bloodGroup" placeholder="Enter blood group"/>
		<form:errors path="bloodGroup" cssClass="error"/><br><br>
		<label>Date of Joining:</label>
		<form:input path="doj" placeholder="Enter date of joining" type="date"/>
		<form:errors path="doj" cssClass="error"/><br><br>
		<label>Employee Level:</label>
		<form:input path="empLevel" placeholder="Enter employee level" type="number"/>
		<form:errors path="empLevel" cssClass="error"/><br><br>
		<label>Employee Post:</label>
		<form:input path="postName" placeholder="Enter post name"/>
		<form:errors path="postName" cssClass="error"/><br><br>
		<label>Basic Pay:</label>
		<form:input path="basicPay" placeholder="Enter basic pay" type="number"/>
		<form:errors path="basicPay" cssClass="error"/><br><br>
		<label>House Allowance:</label>
		<form:input path="houseAllowance" placeholder="Enter house allowance" type="number"/>
		<form:errors path="houseAllowance" cssClass="error"/><br><br>
		<button type="submit">Add or Update</button>
	</form:form>
</body>
</html>