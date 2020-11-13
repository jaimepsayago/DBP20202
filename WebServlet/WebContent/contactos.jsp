<%@page import="pucese.web.jsp.Contactos"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% ArrayList<Contactos> contactos; 
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Libreta de Contactos</title>
</head>
<%
contactos=(ArrayList<Contactos>)session.getAttribute("contactos");

if(contactos==null){
	contactos = new ArrayList<Contactos>();
	session.setAttribute("contactos", contactos);
	}

String metodo = request.getMethod();
if("POST".equals(metodo)){
	
	String nombre = request.getParameter("nombre");
	String apellido = request.getParameter("apellido");
	String telefono = request.getParameter("telefono");
	String eliminar = request.getParameter("eliminar");
	Contactos contacto = new Contactos();
	
	contacto.setNombre(nombre);
	contacto.setApellido(apellido);
	contacto.setTelefono(telefono);
		
	contactos.add(contacto);
}
%>

<body>

	<h1>Libreta de Direcciones</h1>
	<form method="post">
	<label>Nombre</label>
	<input type="text" name="nombre"/>
	<label>Apellido</label>
	<input type="text" name="apellido"/>
	<label>Telefono</label>
	<input type="text" name="telefono"/>
	
	<button type="submit">Agregar</button>
		
	</form>

	<h1>Contactos Registrados</h1>
	<table>
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Telefono</th>
		</tr>
	</thead>
	<tbody>
		<% for(Contactos c:contactos){
		%>
		<tr>
			<th><%=c.getNombre()%></th>
			<th><%=c.getApellido()%></th>
			<th><%=c.getTelefono()%></th>
			
		</tr>
	<%
	}
	%>
</body>
</html>