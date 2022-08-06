<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
		<head>
			<title>Espaço LOJA</title>
		</head>
		<body>
			<h2>Espaço Loja ${sessionScope.usuarioLogado.nome}</h2>
			<%
				String contextPath = request.getContextPath().replace("/", "");
			%>
			<a href="/<%=contextPath%>/loja/cadastroVeiculo">Cadastrar veículo</a><br/>
			<a href="/<%=contextPath%>/loja/listaVeiculosLoja">Lista de Veículos</a><br/>
			<a href="/<%=contextPath%>/index.jsp">HOME</a><br/>
			<a href="/<%=contextPath%>/logout/logout">Sair</a>
		</body>
</html>