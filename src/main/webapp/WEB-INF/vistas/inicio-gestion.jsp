<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
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
	
	h1, p {
		margin: 15px;
	}
	
	table, td, th {
	  	border: 2px solid #00ACFF;
	  	margin: 15px;
	}
	
	.opcion {
		display: flex;
		align-items: center;
		justify-content: center;
		border: solid #00ACFF;
		width: 218px;
		margin: 15px;
		height: 30px;
	}
</style>
</head>
<body>

	<h1>Gestión de Control</h1>

	<p>Bienvenid@, ${empleado.getNombre() }</p>
	
	<table class="tabla">
		<tr>
			<th>Id</th>
			<th>Descripción</th>
			<th>Fecha de inicio</th>
			<th>Cliente</th>
			<th>Jefe proyecto</th>
			<th>Coste previsto</th>
			<th>Fecha prevista de fin</th>
			<th>Venta prevista</th>
			<th>Estado</th>
			<th>Coste real</th>
			<th>Fecha real de fin</th>
			<th>Finalizar</th>			
		</tr>
		<c:forEach var="ele" items="${listaProyectos }">
			<tr>
				<td>${ele.getIdProyecto() }</td>
				<td>${ele.getDescripcion() }</td>
				<td>
					<fmt:formatDate pattern="dd-MM-yyyy" value="${ele.getFechaInicio() }" />
				</td>
				<td>${ele.getCliente().getNombre() }</td>
				<td>${ele.getJefeProyecto().getNombre() }</td>
				<td>${ele.getCostesPrevisto() }</td>
				<td>
					<fmt:formatDate pattern="dd-MM-yyyy" value="${ele.getFechaFinPrevisto() }" />
				</td>
				<td>${ele.getVentaPrevisto() }</td>
				<td>${ele.getEstado() }</td>
				<td>${ele.getCosteReal() }</td>
				<td>
					<fmt:formatDate pattern="dd-MM-yyyy" value="${ele.getFechaFinReal() }" />
				</td>
				<td>
					<c:if test="${!ele.getEstado().equals('Finalizado') }">
						<a href="/gestion/terminarProyecto/${ele.getIdProyecto() }">Finalizar</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<div class="opcion"><a href="/gestion/altaProyecto">Alta Proyecto</a></div>
</body>
</html>