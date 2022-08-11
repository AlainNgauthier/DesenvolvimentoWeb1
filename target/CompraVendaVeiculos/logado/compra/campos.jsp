<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table border="1" style="width: 800px; border: 1px solid black">
	<tr>
		<th>id</th>
		<!-- <th>Data</th> -->
		<th>Valor</th>			
		<th>Modelo</th>		
		<th>Loja</th>
	</tr>
	<c:forEach var="veiculo" items="${veiculos}">
		<tr>
			<td style="text-align: center">
				<input type="radio" id="${veiculo.value.id}" name="veiculo" value="${veiculo.value.id}" required>
			</td>
			<%-- <td>${veiculo.value.data}</td>	 --%>	
			<td>${veiculo.value.valor}</td>
			<td>${veiculo.value.modelo}</td>
			<td>${veiculo.value.loja.nome}</td>
		</tr>
	</c:forEach>
</table>
<br/>
<br/>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="Salvar" />
	</td>
</tr>