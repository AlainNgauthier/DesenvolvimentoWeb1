<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	    <head>
	        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	        <title>Compra</title>
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
				                 <a href="${pageContext.request.contextPath}/clientes">Área Cliente</a>
			                </li>
			                <li>
			                	<a href="../proposta/listarPropostasCliente">Minha lista de Propostas</a>
			                </li>
				            <li>
				                 <a href="../logout">Sair</a>
				            </li>
						</ul>
		        	</div>
		        </div>
	        </nav> 
	        
	        <div class="container" role="main">
	        	<div class="row">
		         	<div class="jumbotron">
	        			<h3>Proposta de compra</h3>
	        			<p>
	        				Nesta página, você realiza uma proposta de compra.
	        			</p>
	        		</div>
		         </div>
		        <div class="row">
		            <div class="row">
		                <c:set var="veiculo" value='${requestScope.veiculo}' />
		                <ul class="list-group">
		                    <li class="list-group-item">${veiculo.modelo} (${veiculo.ano}) - ${veiculo.quilometragem}km</li>
		                    <li class="list-group-item">${veiculo.loja.nome}</li>
		                    <li class="list-group-item">Placa: ${veiculo.placa}</li>
		                    <li class="list-group-item">Chassi: ${veiculo.chassi}</li>
		                    <li class="list-group-item">R$${veiculo.valor}</li>
		                </ul>
		                <c:forEach var="proposta" items="${requestScope.listaPropostas}">            
		                    	<c:if test ="${proposta.estado == 'ABERTO' && proposta.veiculo.id == veiculo.id}">
		                    		<c:set var = "block_proposta" scope = "page" value = "True"/>
		                    		<c:set var = "proposta_aberta" scope = "page" value = "${proposta}"/>
		                        </c:if>   
						</c:forEach>
						<c:choose>
		               			<c:when test="${pageScope.block_proposta == null}">
			                        <form id="form_proposta" action="../proposta/insereProposta?id_veiculo=${veiculo.id}&id_loja=${veiculo.loja.id}" method="post">
			                            <input id="pvalor" type="number" name="valor" placeholder="Proposta" required>
		                                <input id="pparcelas" type="number" name="parcelamento" placeholder="Quantas parcelas" required>
			                            <input id="proposta" type="submit" name="Proposta" value="Faz sua proposta">
		                        	</form>
		                        </c:when>
		                        <c:otherwise>
		                        	<div class="row">
										<h1>Propostas em aberto</h1>
									</div>
		                       		<table class="propostas class="table table-striped"">
										<thead>
											<tr>
		                                        <th>Data</th>
												<th>Valor</th>
		                        				
											</tr>
										</thead>
		                                <tbody>
		                                    <tr>
		                                        <td>${pageScope.proposta_aberta.data}</td>
		                                        <td>R$ ${pageScope.proposta_aberta.valor} ${pageScope.proposta_aberta.parcelamento}x</td>
		                                    </tr>
		                                </tbody>
									</table>
		                       </c:otherwise> 	
		                </c:choose>
		              </div>
		        </div>
	        </div>
	        <script src="../js/carrossel.js"></script>
	    </body>
</html>