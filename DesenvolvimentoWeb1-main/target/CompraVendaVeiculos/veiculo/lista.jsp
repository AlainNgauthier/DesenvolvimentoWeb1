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
		<h2>
			<a href="/<%=contextPath%>">Menu Principal</a> &nbsp;&nbsp;&nbsp; <a
				href="/<%=contextPath%>/veiculos/paglogin">Login</a> &nbsp;&nbsp;&nbsp; <a
                href="/<%=contextPath%>/veiculos/listar">Listar Veículos</a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption>Veículos à venda</caption>
			<tr>
				<th>ID</th>
				<th>Loja</th>
				<th>Placa</th>
				<th>Chassi</th>
				<th>Modelo</th>
				<th>Descrição</th>
				<th>Ano</th>
				<th>Kilometragem</th>
				<th>Valor</th>
			</tr>
			<c:forEach var="veiculo" items="${requestScope.listaVeiculos}">
				<tr>
					<td>${veiculo.id}</td>
					<td>${veiculo.loja}</td>
					<td>${veiculo.placa}</td>
					<td>${veiculo.chassi}</td>
					<td>${veiculo.modelo}</td>
					<td>${veiculo.descricao}</td>
					<td>${veiculo.ano}</td>
					<td>${veiculo.kilometragem}</td>
					<td>${veiculo.valor}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>