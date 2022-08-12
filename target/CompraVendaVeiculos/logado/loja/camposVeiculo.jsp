<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table border="1" class="table table-striped">
	<caption>
		<c:choose>
			<c:when test="${veiculo != null}">
            	Atualizar
            </c:when>
			<c:otherwise>
            	Cadastrar
            </c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${veiculo != null}">
		<input type="hidden" name="id" value="${veiculo.id}" />
	</c:if>
	<tr>
		<td><label for="placa">Placa</label></td>
		<td><input type="text" id="placa" name="placa" size="20"
			required value="${veiculo.placa}" /></td>
	</tr>
	<tr>
		<td><label for="modelo">Modelo</label></td>
		<td><input type="text" id="modelo" name="modelo" size="20" required
			value="${veiculo.modelo}" /></td>
	</tr>
	<tr>
		<td><label for="chassi">Chassi</label></td>
		<td><input type="text" id="chassi" name="chassi" size="17" required
			value="${veiculo.chassi}" /></td>
	</tr>
	<tr>
		<td><label for="ano">Ano</label></td>
		<td><input type="number" id="ano" name="ano" required
			value="${veiculo.ano}" /></td>
	</tr>
	<tr>
		<td><label for="quilometragem">Quilometragem</label></td>
		<td><input type="number" id="quilometragem" name="quilometragem" required
			value="${veiculo.quilometragem}" /></td>
	</tr>
	<tr>
		<td><label for="descricao">Descrição</label></td>
		<td><input type="text" id="descricao" name="descricao" required
			size="30" value="${veiculo.descricao}" /></td>
	</tr>
	<tr>
		<td><label for="valor">Valor</label></td>
		<td><input type="number" id="valor" name="valor" required
			value="${veiculo.valor}" /></td>
	</tr>

	
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salvar" /></td>
	</tr>
</table>