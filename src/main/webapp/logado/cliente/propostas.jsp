<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	    <head>
	        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	        <title>Minhas Propostas</title>
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
			                	<a href="listarPropostasCliente">Minha lista de Propostas</a>
			                </li>
				            <li>
				                 <a href="logout">Sair</a>
				            </li>
						</ul>
		        	</div>
		        </div>
	        </nav> 
	        <br/><br/><br/><br/>
	        <div align="center" class="row">
				<h1>Lista de Propostas</h1>
			</div>
	        <div align="center">
		        <section>
		            <table class="table table-striped">
						<thead>
							<tr>
	                            <th>Data</th>
		                        <th>Veículo</th>
		                        <th>Valor</th>
	                            <th>Parcelas</th>
		                        <th>Loja</th>
								<th>Proposta</th>
		                        <th>Status</th>
	                            <th>Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="proposta" items="${requestScope.listaPropostas}">
								<tr>
	                                <td>${proposta.data}</td>
		                            <td>${proposta.veiculo.modelo}</td>
		                            <td>R$${proposta.veiculo.valor}</td>
	                                <td>${proposta.parcelamento}</td>
		                            <td>${proposta.loja.nome}</td>
									<td>R$${proposta.valor}</td>
		                            <td>
		                            	<c:choose>
		                            		<c:when test="${proposta.estado == 'ACEITO'}">
		                            			ACEITO
		                            		</c:when>
		                            		<c:when test="${proposta.estado == 'RECUSADO'}">
		                            			RECUSADO
		                            		</c:when>
		                            		<c:otherwise>
		                            			ABERTO
		                            		</c:otherwise>
		                            	</c:choose>
		                            </td>
	                                <td>
	                                    <c:if test="${proposta.estado == 'ABERTO' }">
	                                	    <a id="negar" href="../proposta/removerProposta?id=${proposta.id}">Cancelar</a>
	                                    </c:if>
	                                </td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
		        </section>
	        </div>
	        <script src="../js/cor.js"></script>
	    </body>
</html>