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
	
	h1, h3, p {
		margin: 15px;
	}
	
	table, td, td {
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
<!-- En esta vista se mostrarán en tres tablas los detalles del proyecto -->
	<h1>Detalle del Proyecto ${proyectoAVer.getIdProyecto() }</h1>

	<p>Bienvenid@, ${empleado.getNombre() }</p>
		
	<h3>Datos generales</h3>
	
	<table class="tabla">
		<tr>
			<td>Id</td>
			<td>${proyectoAVer.getIdProyecto() }</td>
		</tr>
		<tr>
			<td>Cliente</td>
			<td>${proyectoAVer.getCliente().getNombre() }</td>
		</tr>
		<tr>
			<td>Jefe proyecto</td>
			<td>${proyectoAVer.getJefeProyecto().getNombre() }</td>
		</tr>
		<tr>
			<td>Coste previsto</td>
			<td>${proyectoAVer.getCostesPrevisto() }</td>
		</tr>
		<tr>
			<td>Fecha prevista de fin</td>
			<td>
				<fmt:formatDate pattern="dd-MM-yyyy" value="${proyectoAVer.getFechaFinPrevisto() }" />
			</td>
		</tr>
		<tr>
			<td>Venta prevista</td>
			<td>${proyectoAVer.getVentaPrevisto() }</td>
		</tr>
		<tr>
			<td>Estado</td>
			<td>${proyectoAVer.getEstado() }</td>
		</tr>
	</table>
		
	<h3>Empleados asignados</h3>
			
	<table>
		<tr>
			<td>Nombre empleado</td>
			<td>Perfil empleado</td>
		</tr>
		<c:forEach var="ele" items="${empleadosProyecto }">
			<tr>
				<td>${ele.getEmpleado().getNombre() }</td>
				<td>${ele.getEmpleado().getPerfile().getNombre() }</td>
			</tr>
		</c:forEach>		
		<tr>
			<td>${empleado.getNombre() }</td>
			<td>Jefe de Proyecto</td>
		</tr>
	
	</table>
	
	<h3>Productos asignados</h3>
	
	<table>
		<tr>
			<td>Nombre producto</td>
			<td>Cantidad</td>
			<td>Precio</td>
		</tr>
		<c:forEach var="ele" items="${productosProyecto }">
			<tr>
				<td>${ele.getProducto().getDescripcionBreve() }</td>
				<td>${ele.getCantidad() }</td>
				<td>${ele.getPrecioAsignado() }</td>
				
			</tr>
		</c:forEach>		
	</table>
		
	<div class="opcion">
		<div>
			Volver al <a href="/jefe">inicio</a>
		</div>
	</div>
	
</body>
</html>