<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	    <head>
	        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	        <title>Propostas</title>
	    </head>
	    <body>
	        <%String contextPath = request.getContextPath().replace("/", ""); %>
	        <div>
	            <ul id="links">
	                <li>
	                    <a href="${pageContext.request.contextPath}/lojas">
	                        <span id="titulo">Área Loja</span>
	                    </a>
	                </li>
	                <li>
	                    <span>Loja ${sessionScope.lojaLogada.nome}</span>
	                    <ul>
	                        <li><a href="../logout">Sair</a></li>
	                    </ul>
	                </li>
	                <li>
	                    <a href="listarPropostasLoja">Propostas</a>
	                </li>
	                <li>
	                    <a href="../lojas/cadastro">Cadastrar Veículo</a>
	                </li>
	            </ul>
	        </div>
	        <div align="center">
				<h1 class="label">Lista de Propostas</h1>
			</div>
	        <div align="center">
	        <section>
	            <table>
	                <thead>
						<tr>
							<th>Email</th>
	                        <th>Data</th>
	                        <th>Veiculo</th>
	                        <th>Valor</th>
	                        <th>Parcelas</th>
							<th>Proposta</th>
	                        <th>Status</th>
	                        <th>Opções</th>
						</tr>
					</thead>
	
					<tbody>
						<c:forEach var="proposta" items="${requestScope.listaPropostas}">
							<tr>
								<td>${proposta.cliente.email}</td>
	                            <td>${proposta.data}</td>
	                            <td>${proposta.veiculo.modelo}</td>
	                            <td>R$${proposta.veiculo.valor}</td>
	                            <td>${proposta.parcelamento}</td>
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
	                            <c:if test="${proposta.estado == 'ABERTO' }">
	                                <td>
	                                    <a id="aceitar" href="aceitarProposta?id=${proposta.id}&id_cliente=${proposta.cliente.id}&msg=">Aceitar</a>
	                                    &nbsp; 
	                                    <a id="negar" href="negarProposta?id=${proposta.id}&id_cliente=${proposta.cliente.id}&msg=">Recusar</a>
	                                </td>
	                            </c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
	        </section>
	        </div>
	        <script src="../js/cor.js"></script>
	    </body>
   
</html>