<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!--  Página listando os veículos -->
<!-- Possui links para: filtro de carro por modelo, para login e para página principal de cada categoria -->

<html>
	<%-- <fmt:bundle basename="message"> --%>
		<head>
			<title>Compra/Venda de Veículo</title>
		</head>
		<body>
			<%
				String contextPath = request.getContextPath().replace("/", "");
			%>
			<a href="/<%=contextPath%>/index.jsp">Home</a><br/>
			<c:choose>
				<c:when test="${sessionScope.usuarioLogado != null && sessionScope.usuarioLogado.categoria == 'LOJA'}">
					<a href="/<%=contextPath%>/loja">Espaço LOJA</a><br/>
					<a href="/<%=contextPath%>/logout/logout">Sair</a>
				</c:when>
				<c:when test="${sessionScope.usuarioLogado != null && sessionScope.usuarioLogado.categoria == 'CLIENTE'}">
					<a href="/<%=contextPath%>/cliente">Espaço CLIENTE</a><br/>
					<a href="/<%=contextPath%>/logout/logout">Sair</a>
				</c:when>
				<c:when test="${sessionScope.usuarioLogado != null && sessionScope.usuarioLogado.categoria == 'ADMIN'}">
					<a href="/<%=contextPath%>/admin">Espaço ADMIN</a><br/>
					<a href="/<%=contextPath%>/logout/logout">Sair</a>
				</c:when>
				<c:otherwise>
					<a href="/<%=contextPath%>/login.jsp">LOGIN</a><br/>
				</c:otherwise>
			</c:choose>
			<div align="center">
				<h1>Lista Veículos</h1>
			</div>
			<div align="center">
				<table border="1">
					<tr>
						<th>id</th>
						
						<th>Loja</th>
						
						<th>Modelo</th>
						
						<th>Ano</th>
						
						<th>Kilometragem</th>
						
						<th>Preço</th>
					</tr>
					
					<c:forEach var="veiculo" items="${requestScope.listaVeiculos}">
						<tr>
							<td><c:out value="${veiculo.id}" /></td>
							
							<td><c:out value="${veiculo.loja.nome}" /></td>
							
							<td><c:out value="${veiculo.modelo}" /></td>
							
							<td><c:out value="${veiculo.ano}" /></td>
							
							<td><c:out value="${veiculo.kilometragem}" /></td>
							
							<td><c:out value="${veiculo.valor}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<h3>Filtrar Veículo por: Modelo</h3><br/>
			<c:forEach var="modelo" items="${requestScope.listaModelos}">
				&emsp;<a href="/<%=contextPath%>/listaVeiculos?modelo=${modelo}">
						<c:out value="${modelo}"/></a><br/>
			</c:forEach>
		</body>
	<%-- </fmt:bundle> --%>
</html>