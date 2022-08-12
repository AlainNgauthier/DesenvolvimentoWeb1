<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
	
		<head>
			<title>Área Cliente</title>		
		</head>
		
		<body>
			<div align="center">
				<h1>Gestão Clientes</h1>
			</div>
			<div align="center">
				<c:choose>
					<c:when test="${cliente != null}">
						<form action="atualizacaoCliente" method="post">
							<%@include file="camposCliente.jsp"%>
						</form>
					</c:when>
					<c:otherwise>
						<form action="insercaoCliente" method="post">
							<%@include file="camposCliente.jsp"%>
						</form>
					</c:otherwise>
				</c:choose>
			</div>
			<c:if test="${mensagens.existeErros}">
				<div id="erro">
					<ul>
					<c:forEach items="${mensagens.erros}" var="erro">
						<li>${erro}</li>
					</c:forEach>
					</ul>
				</div>
			</c:if>
		</body>
	
</html>