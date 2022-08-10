<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${loja != null}">
				Atualizar Loja
			</c:when>
			<c:otherwise>
				Cadastrar Loja
			</c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${loja != null}">
		<input type="hidden" name="id" value="<c:out value='${loja.id}' />" />
	</c:if>
	<tr>
		<td><label for="nome">Nome</label></td>
		<td><input type="text" id="nome" name="nome" size="45" required value="${loja.nome}" /></td>
	</tr>
	<tr>
		<td><label for="email">Email</label></td>
		<td><input type="text" id="email" name="email" size="45" required value="${loja.email}" /></td>
	</tr>
	<tr>
		<td><label for="senha">Senha</label></td>
		<td><input type="password" id="senha" name="senha" size="45" required value="${loja.senha}" /></td>
	</tr>
	<tr>
		<td><label for="cnpj">CNPJ</label></td>
		<td><input type="text" id="cnpj" name="cnpj" size="45" required value="${loja.cnpj}" /></td>
	</tr>
	<tr>
		<td><label for="categoria">Categoria</label></td>
		<td><input type="text" id="categoria" name="categoria" size="45" required value="${loja.categoria}" /></td>
	</tr>
	<tr>
		<td><label for="descricao">Descrição</label></td>
		<td><input type="text" id="descricao" name="descricao" size="45" required value="${loja.descricao}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salvar"/></td>
	</tr>
</table>