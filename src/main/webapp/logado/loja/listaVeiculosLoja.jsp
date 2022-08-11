<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
		<head>
			<title>Lista Veículos</title>
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
							<li><a href="/<%= contextPath %>/loja">Área Loja</a></li>
							<li><a href="/<%=contextPath%>/logout/logout">Sair</a></li>
						</ul>
					</div>
				</div>
			</nav>
			<br/>
			<div class="row">
				<div align="center">
					<a href="/<%=contextPath%>/loja/listaVeiculosLoja">Listar Veículos</a>
					<br/><br/>
				</div>
				<div align="center">
					<table border="1">
						<tr>
							<th>id</th>
							<th>Placa</th>
							<th>Chassi</th>
							<th>Modelo</th>
							<th>Descrição</th>
							<th>Ano</th>
							<th>Kilometragem</th>
							<th>Valor</th>
							<th>Opções</th>
						</tr>
						<c:forEach var="veiculo" items="${requestScope.lista}">
							<tr>
								<td><c:out value="${veiculo.id}" /></td>
								<td><c:out value="${veiculo.placa}" /></td>
								<td><c:out value="${veiculo.chassi}" /></td>
								<td><c:out value="${veiculo.modelo}" /></td>
								<td><c:out value="${veiculo.descricao}" /></td>
								<td><c:out value="${veiculo.ano}" /></td>
								<td><c:out value="${veiculo.kilometragem}" /></td>
								<td><c:out value="${veiculo.valor}" /></td>
								<td>
									<a href="/<%= contextPath %>/loja/atualizaVeiculo?id=<c:out value='${veiculo.id}' />">Editar</a> 
		                        	&nbsp;&nbsp;&nbsp;&nbsp;
		                            <a href="/<%= contextPath %>/loja/removeVeiculo?id=<c:out value='${veiculo.id}' />" onclick="return confirm('Remover esse Veículo?');">Remover</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>		
			</div>
		</body>
	
</html>