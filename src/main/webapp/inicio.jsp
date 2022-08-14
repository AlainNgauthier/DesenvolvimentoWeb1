<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!--  Página listando os veículos -->
<!-- Possui links para: filtro de carro por modelo, para login e para página principal de cada categoria -->

<html>
		<head>
			<title>Compra E Venda de Veículo</title>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
			<!-- Optional theme -->
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">	
			<!-- Latest compiled and minified JavaScript -->
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		</head>						
		<body>
	        <%String contextPath = request.getContextPath().replace("/", ""); %>
	        <!--  Fixed NavBar -->
	        <nav class="navbar navbar-inverse navbar-fixed-top">
		        <div class="container">
		        	<div id="navbar" class="navbar-collapse collapse"">
						<ul class="nav navbar-nav">
							<li>
				                 <a href="#">Home</a>
			                </li>
				            <li>
				                 <a href="login.jsp">Login</a>
				            </li>
						</ul>
		        	</div>
		        </div>
	        </nav> 
	         <div class="container" role="main">
		         <div class="row">
		         	<div class="jumbotron">
	        			<h3>Lista Veículos</h3>
	        			<p>
	        				Nesta página estão listados todos os veículos. <br/> 
	        				Use o filtro para listar pelo modelo.
	        			</p>
	        		</div>
		         </div>
		        <div class="row">
		            
		            <br/><br/>
		            <div id="legendaN" class="row">
		            	<h4>Veiculos</h4>
		            </div>
					<div class="row">
							<div class="col-sm-6">
					            <c:forEach var="veiculo" items="${requestScope.catalogo}">
						            <div onclick="location.href='login.jsp'" class="box">
						            	<!--  class="box" -->
						            	<ul class="list-group">
								            <li class="modelo list-group-item">${veiculo.modelo}</li>
								            <li class="list-group-item">Loja ${veiculo.loja.nome}</li>
								            <li class="list-group-item">${veiculo.quilometragem} km</li>
								            <li class="list-group-item">R$ ${veiculo.valor}</li>
						            	</ul>
						            </div>				               
					            </c:forEach>	            	
							</div>
					<div class="row">
		                <input type="text" name="Filtro" placeholder="Busque por modelo" id="filtro">
		            </div>
					</div>
		        </div>   
	         </div>
	        <script src="js/filtro.js"></script>
	    </body>
		
</html>