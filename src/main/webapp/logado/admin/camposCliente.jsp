<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table class="table table-striped">
	<c:if test="${cliente != null}">
		<input type="hidden" name="id" value="${cliente.id}" />
	</c:if>
	<tr>
		<td><label for="nome">Nome</label></td>
		<td><input type="text" id="nome" name="nome" size="30"
			required value="${cliente.nome}" /></td>
	</tr>
	<tr>
		<td><label for="email">Email</label></td>
		<td><input type="text" id="email" name="email" size="30" required
			value="${cliente.email}" /></td>
	</tr>
	<tr>
		<td><label for="senha">Senha</label></td>
		<td><input type="text" id="senha" name="senha" size="30" required
			value="${cliente.senha}" /></td>
	<tr>
		<td><label for="CPF">CPF</label></td>
		<td><input type="text" id="CPF" name="CPF" size="30"
			required value="${cliente.CPF}" /></td>
	</tr>
	<tr>
		<td><label for="nascimento">Nascimento</label></td>
		<td><input type="text" id="nascimento" name="nascimento" size="30" required
			value="${cliente.nascimento}" /></td>
	</tr>
	<tr>
		<td><label for="telefone">Phone</label></td>
		<td><input type="text" id="telefone" name="telefone" size="30" required
			value="${cliente.telefone}" /></td>
	</tr>
	<tr>
		<td><label for="sexo">Sexo</label></td>
		<td><input type="text" id="sexo" name="sexo" size="30" required
			value="${cliente.sexo}" /></td>
	</tr>
	<tr>
		<td><label for="papel">Papel</label></td>
		<td>
			<select name="papel">
				<option value="ADMIN" ${cliente.papel == "ADMIN" ? 'selected="selected"' : ''}>ADMIN</option>
				<option value="USER" ${cliente.papel == "USER" ? 'selected="selected"' : ''}>USER</option>
			</select>			
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salvar"/></td>
	</tr>
</table>