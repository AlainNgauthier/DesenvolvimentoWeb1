<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
		<head>
			<title>Espaço ADMIN</title>
		</head>
		<body>
			<h2>Espaço ADMIN</h2>
			<%
				String contextPath = request.getContextPath().replace("/", "");
			%>
			<a href="/<%=contextPath%>/admin/cadastroCliente">Cadastrar Cliente</a><br/>
			<a href="/<%=contextPath%>/admin/cadastroLoja">Cadastrar Loja</a><br/>
			<a href="/<%=contextPath%>/admin/listaClientes">Lista Clientes</a><br/>
			<a href="/<%=contextPath%>/admin/listaLojas">Lista Lojas</a><br/>
			<a href="/<%=contextPath%>/index.jsp">HOME</a><br/>
			<a href="/<%=contextPath%>/logout/logout">Sair</a>
		</body>
</html>