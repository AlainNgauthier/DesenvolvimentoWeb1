<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
	
		<head>
			<title>Lista de Usuários</title>
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
							<li><a href="${pageContext.request.contextPath}/admin">Área Admin</a></li>
							<li><a href="${pageContext.request.contextPath}/logout">Sair</a></li>
						</ul>
					</div>
				</div>
			</nav>
			
			<div class="container">
				<div class="row">
					<div class="row">
			         	<div class="jumbotron">
		        			<h3>Lista de Usuários</h3>
		        			<p>
		        				Nesta página estão listados todos os usuários [Admins/Clientes].
		        			</p>
		        		</div>
			         </div>
					<div class="row">
						<div>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>id</th>
										<th>Email</th>
										<th>Senha</th>
										<th>CPF</th>
										<th>Nome</th>
										<th>Telefone</th>
				                        <th>Sexo</th>
										<th>Nascimento</th>
										<th>Papel</th>
										<th>Ações</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="cliente" items="${requestScope.listaClientes}">
										<tr>
											<td>${cliente.id}</td>
											<td>${cliente.email}</td>
				                            <td>${cliente.senha}</td>
				                            <td>${cliente.CPF}</td>
				                            <td>${cliente.nome}</td>
				                            <td>${cliente.telefone}</td>
				                            <td>${cliente.sexo}</td>
				                            <td>${cliente.nascimento}</td>
				                            <td>${cliente.papel}</td>
											<td>
												<a href="/<%= contextPath%>/admin/edicaoCliente?id=${cliente.id}">Editar</a>
												&nbsp;&nbsp;&nbsp;&nbsp; 
												<a href="/<%= contextPath%>/admin/remocaoCliente?id=${cliente.id}" onclick="return confirm('Remover o cliente?');">Remover</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div class="row col-sm-4">
						<div class="container">
							<a href="/<%=contextPath%>/admin/cadastroCliente">Cadastrar novo cliente</a>
						</div>
					</div>
				</div>
			</div>										
		</body>	
</html>