<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
	
		<head>
			<title>Lista de Clientes</title>
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
							<li><a href="/<%=contextPath%>/admin">Área Admin</a></li>
							<li><a href="/<%=contextPath%>/logout/logout">Sair</a></li>
						</ul>
					</div>
				</div>
			</nav>															
			<div class="container" role="main">
				<div class="jumbotron">
	        		<h3>Lista de Clientes</h3>
	        		<p>
	        			Nesta página estão listados todos os clientes.
	        		</p>
	      		</div>
				<div class="row">
					<div>
						<table class="table table-striped">
							<tr>
								<th>id</th>
								<th>Nome</th>
								<th>Email</th>
								<th>Senha</th>
								<th>CPF</th>
								<th>Telefone</th>
								<th>Sexo</th>
								<th>Data de Nascimento</th>
								<th>Opções</th>
							</tr>
							<c:forEach var="cliente" items="${requestScope.listaClientes}">
								<tr>
									<td><c:out value="${cliente.id}" /></td>
									<td><c:out value="${cliente.nome}" /></td>
									<td><c:out value="${cliente.email}" /></td>
									<td><c:out value="${cliente.senha}" /></td>
									<td><c:out value="${cliente.cpf}" /></td>
									<td><c:out value="${cliente.telefone}" /></td>
									<td><c:out value="${cliente.sexo}" /></td>
									<td><c:out value="${cliente.nascimento}" /></td>
									<td>
										<a href="/<%= contextPath %>/admin/atualizaCliente?id=<c:out value='${cliente.id}'/>">Editar</a> 
			                        	&nbsp;&nbsp;&nbsp;&nbsp;
			                            <a href="/<%= contextPath %>/admin/removeCliente?id=<c:out value='${cliente.id}'/>"
												onclick="return confirm('Quer remover esse cliente?');">Remover</a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</body>
	
</html>