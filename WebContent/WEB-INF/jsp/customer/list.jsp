<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表</title>
<style>
	body *{ margin:0px; padding:0px; }
	
	#header{ width:100%; height:40px; }
	
	#title{ margin-left:45%; font-size:40px; font-weight:bold; text-shadow:5px 1px 5px blue; }
	
	#welcome{ float:right; font-weight:bold; color:blue; }
	
	#exit{ float:left; font-weight:bold; color:blue; }
	
	table{ width: 50%; margin: 0 auto;  margin-top:10px; }
</style>
</head>
<body>
<div id="header">
	<span id="title">客户列表</span>
	<span id="welcome">欢迎:${ sessionScope.admin.name } | <a href="admin.htm?action=logout">退出</a></span>
</div>
<hr>
<table border="1">
	<tr>
		<td>编号</td>
		<td>姓名</td>
		<td>年龄</td>
		<td>性别</td>
	</tr>
	<c:forEach items="${data}"  var="customer" varStatus="st">
		<tr <c:if test="${st.index%2==0}">style="background-color:blue;"</c:if>>
			<td>${customer.id}</td>
			<td>${customer.name}</td>
			<td>${customer.age}</td>
			<td>${customer.sex}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>