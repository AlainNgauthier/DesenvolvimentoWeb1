<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table border="1" style="width: 400px; border: 1px solid black">
	<tr>
		<th>id</th>
		<th>Data</th>
		<th>Valor</th>			
		<th>Modelo</th>		
		<th>Loja</th>
	</tr>
	<c:forEach var="veiculo" items="${veiculos}">
		<tr>
			<td style="width: 10%; text-align: center"><input type="radio"
				id="${veiculo.key}" name="veiculo" value="${veiculo.key}" required></td>			
			<td>${veiculo.value.valor}</td>
			<td>${veiculo.value.modelo}</td>
			<td>${veiculo.value.agencia.nome}</td>
		</tr>
	</c:forEach>
</table>
<br/>
<br/>
<tr>
	<td colspan="2" align="center"><input type="submit" value="Salvar" /></td>
</tr>