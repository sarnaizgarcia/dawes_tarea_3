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
		<h1>Finalizar Proyecto ${proyectoAFinalizar.getIdProyecto() }</h1>
		
		${proyectoAFinalizar }

		<p>Bienvenid@, ${empleado.getNombre() }</p>
	</div>
		
	<form action="/gestion/terminarProyecto/${proyectoAFinalizar.getIdProyecto() }" method="post">
	
		<p>
			<p>Coste real</p>
			<input type="text" name="costeReal" >
		</p>
<!-- 		<p> -->
<!-- 			<p>Fecha de fin</p> -->
<!-- 			<input type="date" name="fechaFinReal"> -->
<!-- 		</p> -->
		<p><input type="submit" value="Finalizar" id="boton"></p>
	</form>		
	
	
	<div class="opcion">
		<div>
			Volver al <a href="/gestion">inicio</a>
		</div>
	</div>
</body>
</html>