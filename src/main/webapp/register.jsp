<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sj:head  jqueryui="true" jquerytheme="blitzer" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
	<s:form action="registrarUsuario">
			<table align="center" border="1" width="50%">
			
				<tr>
					<td>Nombre:</td>
					<td><s:textfield name="nombre"/> </td>
				</tr>
				
				<tr>
					<td>Usuario:</td>
					<td><s:textfield name="usuario"/> </td>
				</tr>
				
				<tr>
					<td>Clave:</td>
					<td><s:textfield name="clave"/> </td>
				</tr>
				
				
				<tr>
					<td>Rol:</td>
					<td> 
					<s:url var="codigo" action="cargarCombo"/>
						<sj:select
							name="rol" 
							href="%{codigo}"
							list="lstRol"
							listKey="idRol"
							listValue="descripcion"
							headerKey="-1"
							headerValue="[---seleccione---]"/>
					</td>
					
				</tr>	
				
				<tr>
					<td colspan="2" align="center">
						<sj:submit value="Registrar"/>
						<sj:submit value="Listar" src="report.jsp"/>
					</td>
				</tr>
			</table>
			<div id="divMensaje">
			
			</div>
	</s:form>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>