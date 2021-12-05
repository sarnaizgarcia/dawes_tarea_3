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
	
	.cierre {
		display: flex;
		align-items: center;
		justify-content: center;
		border: solid #CB3234;
		width: 218px;
		margin: 15px;
		height: 30px;
	}	
</style>
</head>
<body>

	<h1>Jefe de Proyecto</h1>

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
			<th>Ver detalle</th>
			<th>Asignar empleados</th>			
		</tr>
		<c:forEach var="ele" items="${listaProyectos }">
			<c:if test="${(ele.getJefeProyecto().getIdEmpl() == empleado.getIdEmpl()) &&  !ele.getEstado().equals('Finalizado')}">
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
					<td><a href="/jefe/verDetalle/${ele.getIdProyecto() }">Detalle</a></td>
					<td>No disponible</td>
					
				</tr>
			</c:if>
		</c:forEach>
	</table>
	
	<div class="cierre"><a href="/logout">Cerrar sesión</a></div>
</body>
</html>