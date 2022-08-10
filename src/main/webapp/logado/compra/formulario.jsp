<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>	
		<head>
			<title>Lista de compras</title>
		</head>
		<body>
			<%
				String contextPath = request.getContextPath().replace("/", "");
			%>
			<a href="/<%=contextPath%>/index.jsp">Home</a><br/>
			<a href="/<%=contextPath%>/cliente">Área Cliente</a><br/>
			<a href="/<%=contextPath%>/logout/logout">Sair</a>
			<div align="center">
				<h1>Comprar Veículo</h1>
				<h2><a href="lista">Minhas compras</a></h2>
			</div>
			<div align="center">
				<form action="insercao" method="post">
					<%@include file="campos.jsp"%>
				</form>
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