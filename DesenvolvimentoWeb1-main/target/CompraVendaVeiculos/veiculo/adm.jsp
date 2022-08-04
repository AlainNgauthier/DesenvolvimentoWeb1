<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Compra/Venda de Veículos</title>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1>Compra/Venda de Veículos</h1>
		<p><i>Administrador</i></p>
		<h2>
			<a href="/<%=contextPath%>">Menu Principal</a> &nbsp;&nbsp;&nbsp; <a
				href="/<%=contextPath%>/veiculos/cadastrarCliente">Cadastrar Cliente</a> &nbsp;&nbsp;&nbsp; <a
            	href="">Cadastrar Loja</a>
		</h2>
		<h3>
		    <a href="/<%=contextPath%>/veiculos/listarClientes">Listar Clientes</a>  &nbsp;&nbsp;&nbsp; <a
               href="/<%=contextPath%>/veiculos/listarLojas">Listar Lojas</a>
		</h3>
	</div>

</body>
</html>