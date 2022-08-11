<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
	<fmt:bundle basename="message">
		<head>
			<title>Cadastrar Veículo</title>
		</head>
		<body>
			<%
				String contextPath = request.getContextPath().replace("/", "");
			%>
			<a href="/<%=contextPath%>/index.jsp">Home</a><br>
			<a href="/<%= contextPath %>/loja">Área Loja</a><br/>
			<a href="/<%=contextPath%>/logout/logout">Sair</a>
			<div align="center">
				<c:choose>
					<c:when test="${veiculo == null}">
						<form action="inserirVeiculo" method="post">
							<%@include file="campos.jsp"%>
						</form>
					</c:when>
					<c:otherwise>
						<form action="atualizarVeiculo" method="post">
							<%@include file="campos.jsp"%>
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
	</fmt:bundle>
</html>