<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Todolist</title>
</head>
<body>
 	<c:forEach items="${tasks}" var="task">
	 	<form action="/todolist-presentation/validate" method="post">
 			<input type="hidden" name="id" value="${task.id}" />
		    <input type="submit" value="Finir" />
		</form>
     	<div>${task.name} - ${task.status.name}</div>
     	Date de début : <fmt:formatDate value="${task.beginDate}" pattern="dd-MM-yyyy HH:mm:ss" /><br>
     	Date de fin : <fmt:formatDate value="${task.closedDate}" pattern="dd-MM-yyyy HH:mm:ss" /><hr>
	 </c:forEach>
</body>
</html>