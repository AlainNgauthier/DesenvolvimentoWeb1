<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
		<head>
			<title>Minhas compras</title>
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
			<!-- Optional theme -->
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">	
			<!-- Latest compiled and minified JavaScript -->
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		</head>
		<body>
			<%
				String contextPath = request.getContextPath().replace("/", "");
			%>
			<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="container">
					<div id="navbar" class="navbar-collapse collapse"">
						<ul class="nav navbar-nav">
							<li><a href="/<%=contextPath%>/index.jsp">Home</a></li>
							<li><a href="/<%=contextPath%>/cliente">Área Cliente</a></li>
							<li><a href="/<%=contextPath%>/logout/logout">Sair</a></li>
						</ul>
					</div>
				</div>
			</nav>
			<br />
			<div class="container" role="main">
				<div class="jumbotron">
	        		<h3>Meus veículos comprados</h3>
	      		</div>
		      	<div class="row">
			      		<div>
							<table class="table table-striped">
								<tr>
									<th>id</th>
									<th>Data</th>
									<th>Valor</th>
									<th>Modelo</th>
									<th>Loja</th>
								</tr>
								<c:forEach var="compra" items="${requestScope.listaCompras}">
									<tr>
										<td><c:out value="${compra.id}"/></td>
										<td><c:out value="${compra.data}"/></td>
										<td><c:out value="${compra.valor}"/></td>
										<td><c:out value="${compra.veiculo.modelo}"/></td>
										<td><c:out value="${compra.veiculo.loja.nome}"/></td>
									</tr>
								</c:forEach>
							</table>
						</div>
				</div>
				<div class="row">
					<h4>
						<a href="/<%=contextPath%>/compras/cadastro">Comprar veículo</a> 
					</h4>
			</div>
	      	</div>
			<%-- <div class="row">
		      	<div>
					<div align="center">
						<table border="1">
							<tr>
								<th>id</th>
								<th>Data</th>
								<th>Valor</th>
								<th>Modelo</th>
								<th>Loja</th>
							</tr>
							<c:forEach var="compra" items="${requestScope.listaCompras}">
								<tr>
									<td><c:out value="${compra.id}"/></td>
									<td><c:out value="${compra.data}"/></td>
									<td><c:out value="${compra.valor}"/></td>
									<td><c:out value="${compra.veiculo.modelo}"/></td>
									<td><c:out value="${compra.veiculo.loja.nome}"/></td>
								</tr>
							</c:forEach>
						</table>
					</div>
		      	</div>
		    </div> --%>		
		</body>
</html>
