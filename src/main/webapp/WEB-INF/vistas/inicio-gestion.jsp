<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tarea 3 - DAWES</title>
<style type="text/css">
	body {
		font-family: "sans-serif";
		margin: 15px;
	}
</style>
</head>
<body>
	Bienvenido ${empleado.getNombre() }
	
	<table class="tabla">
		<tr>
			<th>Id</th>
			<th>Coste real</th>
			<th>Coste previsto</th>
			<th>Descripción</th>
			<th>Estado</th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="ele" items="${eventos }">
			<c:if test="${ele.getEstadoEvento().equals('Activo') }">
				<tr>
					<td>${ele.getNombreEvento() }</td>
					<td>${ele.getAforoMaximo() }</td>
					<td><fmt:formatDate pattern="dd-MM-yyyy" value="${ele.getFechaEvento() }" /></td>
					<td><a href="detalle/${ele.getIdEvento() }">Detalle</a></td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	

</body>
</html>