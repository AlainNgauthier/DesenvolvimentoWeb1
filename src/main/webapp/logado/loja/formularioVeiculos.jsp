<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
	
		<head>
			<title><fmt:message key="vehicle.welcome"/></title>
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
			<!-- Optional theme -->
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">	
			<!-- Latest compiled and minified JavaScript -->
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>			
		</head>
		<body>
			<div class="container">
					<div class="row">
		         		<div class="jumbotron">
	        				<h3>Editar/Cadastrar Loja</h3>
		        			<p>
		        				Formulário de edição e de cadastro de veículos.
		        			</p>
	        			</div>
		         	</div>
		         	<div class="row">
						<c:choose>
							<c:when test="${veiculo != null}">
								<form action="atualizacao" method="post">
									<%@include file="camposVeiculo.jsp"%>
								</form>
							</c:when>
							<c:otherwise>
								<form action="insercao" method="post">
									<%@include file="camposVeiculo.jsp"%>
								</form>
							</c:otherwise>
						</c:choose>
		         	</div>
					<c:if test="${!empty requestScope.mensagens}">
						<ul class="erro">
							<c:forEach items="${requestScope.mensagens}" var="mensagem">
								<li>${mensagem}</li>
							</c:forEach>
						</ul>
					</c:if>
			</div>
		</body>
</html>