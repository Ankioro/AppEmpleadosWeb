<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Empleados</title>
</head>
<body>
<h1 style = font-family:arial;>Listado de Empleados</h1><br />
<c:forEach items="${lempleados}" var="empleado">
	<c:out value="${empleado.nombre}"></c:out> <c:out value="${empleado.id}"></c:out><br />
</c:forEach>
</body>
</html>