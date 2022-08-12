<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
	
	    <head>
	        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	        <title>Compra/Venda de Veículos</title>
	        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
			<!-- Optional theme -->
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">	
			<!-- Latest compiled and minified JavaScript -->
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	    </head>
	    <body>
	        <%String contextPath = request.getContextPath().replace("/", ""); %>
	         <nav class="navbar navbar-inverse navbar-fixed-top">
		        <div class="container">
		        	<div id="navbar" class="navbar-collapse collapse"">
						<ul class="nav navbar-nav">
							<li>
				                  <a href="${pageContext.request.contextPath}/lojas">
			                         <span id="titulo">Área Loja</span>
			                      </a>
			                </li>
				            <li>
				                 <a href="logout">Sair</a>
				            </li>
				            <li>
	                    		<a href="proposta/listarPropostasLoja">Lista de Propostas</a>
	                		</li>
	                		<li>
	                    		<a href="lojas/cadastro">Cadastrar Veículo</a>
	                		</li>
						</ul>
		        	</div>
		        </div>
	        </nav> 
	        
	        <div class="row">
	        	<div class="container">
	        	<div class="row">
		         	<div class="jumbotron">
	        			<h3>Lista de Veículos</h3>
	        			<p>Listagem dos veículos da sua loja</p>
	        		</div>
		         </div>
			     <div class="row">
				            <div class="col-sm-6">
					            <c:forEach var="veiculo" items="${requestScope.catalogo}">
					                <div class="box">
					                    <div class="card">
					                        <ul class="list-group">
					                            <li class="modelo list-group-item">${veiculo.modelo}</li>
					                            <a href="lojas/edicao?id=${veiculo.id}">Editar</a>
												<a href="lojas/remocao?id=${veiculo.id}" onclick="return confirm('Remover Veículo?');">Remover</a>
					                        </ul>
					                    </div>
					                </div>
					            </c:forEach>        
				            </div>
			      </div>
			      <div id="divFiltro" class="row">
			         <input type="text" name="Filtro" placeholder="Filtrar por modelo" id="filtro">
			      </div>
	        	</div>  
	        </div>
	        <script src="js/filtro.js"></script>
	    </body>
   
</html>