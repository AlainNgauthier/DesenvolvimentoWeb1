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
		<p><i>Administrador</i></p>
		<h2>
			<a href="/<%=contextPath%>">Menu Principal</a> &nbsp;&nbsp;&nbsp; <a
				href="/<%=contextPath%>/veiculos/cadastrarCliente">Cadastrar Cliente</a> &nbsp;&nbsp;&nbsp; <a
            	href="">Cadastrar Loja</a>
		</h2>
		<h3>
		    <a href="/<%=contextPath%>/veiculos/listarClientes">Listar Clientes</a>  &nbsp;&nbsp;&nbsp; <a
               href="/<%=contextPath%>/veiculos/listarLojas">Listar Lojas</a>
		</h3>
	</div>

	<div align="center">
		<table border="1">
			<caption>Lista de Clientes</caption>
			<tr>
			    <th>ID</th>
				<th>Email</th>
				<th>Senha</th>
				<th>Nome</th>
				<th>Nascimento</th>
				<th>Sexo</th>
				<th>CPF</th>
				<th>Categoria</th>
				<th>Telefone</th>
				<th>Ações</th>
			</tr>
			<c:forEach var="cliente" items="${requestScope.listaCliente}">
				<tr>
				    <td>${cliente.id}</td>
					<td>${cliente.email}</td>
					<td>${cliente.senha}</td>
					<td>${cliente.nome}</td>
					<td>${cliente.nascimento}</td>
					<td>${cliente.sexo}</td>
					<td>${cliente.cpf}</td>
					<td>${cliente.categoria}</td>
					<td>${cliente.telefone}</td>
					<td><a href="/<%= contextPath%>/veiculos/edicaoCliente?id=${cliente.id}">Edição</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/<%= contextPath%>/veiculos/removeUsuario?id=${cliente.id}"
						onclick="return confirm('Tem certeza de que deseja excluir este item?');">
							Remoção </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>