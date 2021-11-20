<%@page import="com.ashutosh.bean.Menu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="UTF-8">
<title>RESTAURANT-MENU</title>
</head>
<body>

	<table border="">
		<thead>
			<tr><td>Item Name</td> <td>Item Price</td></tr>
		</thead>
		<core:forEach items="${RESTAURANTS}" var="rest" >
			<tr>
				<td>${rest.itemName}</td>
				<td>${rest.itemPrice}</td>
			</tr>
		</core:forEach>
	</table>
</body>
</html>