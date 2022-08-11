<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${veiculo != null}">
				Atualizar Veículo
			</c:when>
			<c:otherwise>
				Cadastrar Veículo
			</c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${veiculo != null}">
		<input type="hidden" name="id" value="<c:out value='${veiculo.id}' />" />
	</c:if>
	<tr>
		<td><label for="cnpj">CNPJ</label></td>
		<td><input type="text" id="cnpj" name="cnpj" size="45" required value="${veiculo.cnpj}" /></td>
	</tr>
	<tr>
		<td><label for="placa">Placa</label></td>
		<td><input type="text" id="placa" name="placa" size="45" required value="${veiculo.placa}" /></td>
	</tr>
	<tr>
		<td><label for="chassi">Chassi</label></td>
		<td><input type="text" id="chassi" name="chassi" size="45" required value="${veiculo.chassi}" /></td>
	</tr>
	<tr>
		<td><label for="modelo">Modelo</label></td>
		<td><input type="text" id="modelo" name="modelo" size="45" value="${veiculo.modelo}" /></td>
	</tr>
	<tr>
		<td><label for="descricao">Descricao</label></td>
		<td><input type="text" id="descricao" name="descricao" size="45" required value="${veiculo.descricao}" /></td>
	</tr>
	<tr>
		<td><label for="ano">Ano</label></td>
		<td><input type="number" id="ano" name="ano" size="45" required value="${veiculo.ano}" /></td>
	</tr>
	<tr>
		<td><label for="kilometragem">Kilometragem</label></td>
		<td><input type="number" id="kilometragem" name="kilometragem" size="45" required value="${veiculo.kilometragem}" /></td>
	</tr>
	<tr>
		<td><label for="valor">Valor</label></td>
		<td><input type="number" id="valor" name="valor" size="45" required value="${veiculo.valor}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salvar" /></td>
	</tr>
</table>