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
	
	form {
		margin: 15px;
	}
	
	.titulo {
		margin: 15px;
	}
	
	#boton {
		margin-top: 15px;
		margin-bottom: 15px;
		border-radius: 5px;
		border: 2px solid #00ACFF 
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

	<div class="titulo">
		<h1>Alta Proyecto</h1>

		<p>Bienvenid@, ${empleado.getNombre() }</p>
	</div>
		
	<form action="/gestion/altaProyecto" method="post">
		<p>
			<p>Id del Proyecto</p>
			<input type="text" name="idProyecto" required>
		</p>
		<p>
			<p>Descripción</p>
			<input type="text" name="descripcion" required>
		</p>
		<p>
			<p>Cliente</p>			
			<select name="cliente.getCif()">
				<c:forEach var="ele" items="${listaClientes }">
					<option value="${ele }">${ele.getNombre() }</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<p>Estado</p>
			<select name="estado">
				<option value="activo">Activo</option>
				<option value="finalizado">Finalizado</option>
			</select>
		</p>
		<p>
			<p>Jefe de proyecto</p>
			<select name="jefeProyecto.getIdEmpl()">
				<c:forEach var="ele" items="${listaEmpleados }">
					<c:if test="${ele.getPerfile().getNombre().equals('Jefe de Proyecto') }">
						<option value="${ele }">${ele.getNombre() }</option>
					</c:if>
				</c:forEach>
			</select>
		</p>
		<p><input type="submit" value="Crear proyecto" id="boton"></p>
	</form>		

	<div class="opcion">
		<div>
			Volver al <a href="/gestion">inicio</a>
		</div>
	</div>
</body>
</html>