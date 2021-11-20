<%@page import="com.ashutosh.bean.Menu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MENU-ITEM</title>
</head>
<body>
	<select>
	<option>ItemName | ItemPrice</option>
		<core:forEach items="${RESTAURANTS}" var="rest">

			<option value="${rest.itemName} | ${rest.itemPrice}"> ${rest.itemName} | ₹${rest.itemPrice}</option>
		</core:forEach>
	</select>
	<input type="submit" value="Add-IN-Cart" />
    <input type="submit" value="View-Cart" />
    <div align="right">
		<a href="./dashboard"><b>Home</b></a>
	</div>
</body>
</html>