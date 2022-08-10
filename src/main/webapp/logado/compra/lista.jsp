<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
	<fmt:bundle basename="message">
		<head>
			<title>Minhas compras</title>
		</head>
		<body>
			<%
				String contextPath = request.getContextPath().replace("/", "");
			%>
			<a href="/<%=contextPath%>/index.jsp">Home</a><br/>
			<a href="/<%=contextPath%>/cliente">Área Cliente</a><br/>
			<a href="/<%=contextPath%>/logout/logout">Sair</a>
			<div align="center">
				<h1>Minhas compras</h1>
				<h2>
					<a href="/<%=contextPath%>/compras/cadastro">Comprar veículo</a> 
				</h2>
				<br />
				<h3>Minhas compras</h3>
				<br />
			</div>
			<div align="center">
				<table border="1">
					<caption></caption>
					<tr>
						<th>id</th>
						<th>Data</th>
						<th>Valor</th>
						<th>Modelo</th>
						<th>Loja</th>
					</tr>
					<c:forEach var="compra" items="${requestScope.listaCompras}">
						<tr>
							<td>${compra.id}</td>
							<td>${compra.data}</td>
							<td>${compra.valor}</td>
							<td>${compra.veiculo.modelo}</td>
							<td>${compra.veiculo.loja.nome}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</body>
	</fmt:bundle>
</html>
