<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
	
		<head>
			<title>Lista de Lojas</title>
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
	        		<h3>Lista de Lojas</h3>
	        		<p>
	        			Nesta página estão listados todos as lojas.
	        		</p>
	      		</div>
	      		<div class="row">
		      		<div>
						<table class="table table-striped">
							<tr>
								<th>id</th>
								<th>Nome</th>
								<th>Email</th>						
								<th>CNPJ</th>
								<th>Descrição</th>
								<th>Opções</th>
							</tr>
							<c:forEach var="loja" items="${requestScope.listaLojas}">
								<tr>
									<td><c:out value="${loja.id}" /></td>
									<td><c:out value="${loja.nome}" /></td>
									<td><c:out value="${loja.email}" /></td>							
									<td><c:out value="${loja.cnpj}" /></td>
									<td><c:out value="${loja.descricao}" /></td>
									<td><a href="/<%= contextPath %>/admin/atualizaLoja?id=<c:out value='${loja.id}' />">Editar</a> 
			                        	&nbsp;&nbsp;&nbsp;&nbsp;
			                            <a href="/<%= contextPath %>/admin/removeLoja?id=<c:out value='${loja.id}' />"
												onclick="return confirm('Quer remover essa loja?');">
												Remover</a>
									</td>
								</tr>
							</c:forEach>
						</table>
		      		</div>
	      		</div>				
			</div>
		</body>
</html>