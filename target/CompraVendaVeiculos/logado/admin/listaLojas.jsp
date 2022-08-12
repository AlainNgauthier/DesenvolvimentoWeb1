<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
	<head>	
		<title>Lista de lojas</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
			<!-- Optional theme -->
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">	
			<!-- Latest compiled and minified JavaScript -->
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	</head>
	
	<body>
		
		<%String contextPath = request.getContextPath().replace("/", ""); %>
		<div class="row">
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
		</div>
       
		<div class="row">
			<div class="container">
			<div class="row">
		         	<div class="jumbotron">
	        			<h3>Lista de Lojas</h3>
	        			<p>
	        				Nesta página estão listados todos as lojas.
	        			</p>
	        		</div>
		         </div>
				<div class="row">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>id</th>
								<th>Nome</th>
								<th>E-mail</th>
								<th>Senha</th>
								<th>CNPJ</th>
								<th>Descrição</th>
								<th>Opções</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="loja" items="${requestScope.listaLojas}">
								<tr>
									<td>${loja.id}</td>
									<td>${loja.nome}</td>
									<td>${loja.email}</td>
									<td>${loja.senha}</td>
									<td>${loja.CNPJ}</td>
									<td>${loja.descricao}</td>
									<td>
										<a href="/<%= contextPath%>/admin/edicaoLoja?id=${loja.id}">Editar</a>
											&nbsp;&nbsp;&nbsp;&nbsp; <a
											href="/<%= contextPath%>/admin/remocaoLoja?id=${loja.id}"
											onclick="return confirm('Remover essa loja?');">Remover
										</a>
									</td>
								</tr>
							</c:forEach> 
						</tbody>
					</table>
				</div>
			</div>
			<div class="row">
				<div class="container">
						<a href="/<%=contextPath%>/admin/cadastroLoja">Cadastrar nova loja</a>
				</div>
			</div>
		</div>
	</body>
</html>