<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Compra/Venda de Veículos</title>
</head>

<body>
	<div align="center">
		<h1>Gerenciamento de Clientes</h1>
	</div>
	<div align="center">
		<c:choose>
			<c:when test="${cliente != null}">
				<form action="updateCliente" method="post">
					<%@include file="camposCliente.jsp"%>
				</form>
			</c:when>
			<c:otherwise>
				<form action="insercaoCliente" method="post">
					<%@include file="camposCliente.jsp"%>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
	<c:if test="${!empty requestScope.mensagens}">
		<ul class="erro">
			<c:forEach items="${requestScope.mensagens}" var="mensagem">
				<li>${mensagem}</li>
			</c:forEach>
		</ul>
	</c:if>
</body>

</html>