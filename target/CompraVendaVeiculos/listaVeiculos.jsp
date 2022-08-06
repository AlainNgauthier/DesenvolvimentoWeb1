<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!--  Página listando os veículos -->
<!-- Possui links para: filtro de carro por modelo, para login e para página principal de cada categoria -->

<html>
		<head>
			<title>Compra/Venda de Veículo</title>
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
			<!--  Fixed NavBar -->
			<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="container">
					<div id="navbar" class="navbar-collapse collapse"">
						<ul class="nav navbar-nav">
							<li><a href="/<%=contextPath%>/index.jsp">Home</a></li>
							<c:choose>
								<c:when test="${sessionScope.usuarioLogado != null && sessionScope.usuarioLogado.categoria == 'LOJA'}">
									<li><a href="/<%=contextPath%>/loja">Espaço LOJA</a></li>
									<li><a href="/<%=contextPath%>/logout/logout">Sair</a></li>								
								</c:when>
								<c:when test="${sessionScope.usuarioLogado != null && sessionScope.usuarioLogado.categoria == 'CLIENTE'}">
									<li><a href="/<%=contextPath%>/cliente">Espaço CLIENTE</a></li>
									<li><a href="/<%=contextPath%>/logout/logout">Sair</a></li>	
								</c:when>
								<c:when test="${sessionScope.usuarioLogado != null && sessionScope.usuarioLogado.categoria == 'ADMIN'}">
									<li><a href="/<%=contextPath%>/admin">Espaço ADMIN</a></li>
									<li><a href="/<%=contextPath%>/logout/logout">Sair</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="/<%=contextPath%>/login.jsp">LOGIN</a></li>
								</c:otherwise>
							</c:choose>									
						</ul>				
					</div>
				</div>
			</nav>
			<div class="container" role="main">
				<div class="jumbotron">
        			<h1>Lista Veículos</h1>
      			</div>
				<!-- <div class="page-header">
	        		<h1>Lista Veículos</h1>
	      		</div> -->
				<div class="row">
					<div>
						<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>Loja</th>
								<th>Modelo</th>
								<th>Ano</th>
								<th>Kilometragem</th>
								<th>Preço</th>
							</tr>					
						</thead>
						<tbody>
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
						</tbody>
						</table>
					</div>
				</div>
				<div class="row">
					<span>Filtrar Veículo por: Modelo</span>
				</div>
				<div class="row">
				<ul>
					<c:forEach var="modelo" items="${requestScope.listaModelos}">
						<li><a href="/<%=contextPath%>/listaVeiculos?modelo=${modelo}"><c:out value="${modelo}"/></a></li>
					</c:forEach>			
				</ul>
				</div>
			</div>
		</body>
</html>