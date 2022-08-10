<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>	
		<head>
			<title>Cadastro de Loja/Clientes</title>
		</head>
		<body>
			<%
				String contextPath = request.getContextPath().replace("/", "");
			%>
			<a href="/<%=contextPath%>/index.jsp">Home</a><br/>
			<a href="/<%=contextPath%>/admin">Área Admin</a><br/>
			<a href="/<%=contextPath%>/logout/logout">Sair</a>
			<div align="center">
				<c:choose>
					<c:when test="${!empty cliente && cliente == null || usuario.equals('cliente')}">
						<form action="inserirCliente" method="post">
							<%@include file="camposCliente.jsp"%>
						</form>
					</c:when>
					<c:when test="${!empty cliente && cliente != null || usuario.equals('cliente')}">
						<form action="atualizarCliente" method="post">
							<%@include file="camposCliente.jsp"%>
						</form>
					</c:when>
					<c:when test="${empty cliente && loja == null}">
						<form action="inserirLoja" method="post">
							<%@include file="camposLoja.jsp"%>
						</form>
					</c:when>
					<c:otherwise>
						<form action="atualizarLoja" method="post">
							<%@include file="camposLoja.jsp"%>
						</form>
					</c:otherwise>
				</c:choose>
			</div>
			<h6>Campos obrigatórios</h6>
			<c:if test="${!empty requestScope.mensagens}">
				<ul class="erro">
					<c:forEach items="${requestScope.mensagens}" var="mensagem">
						<li>${mensagem}</li>
					</c:forEach>
				</ul>
			</c:if>
		</body>
</html>