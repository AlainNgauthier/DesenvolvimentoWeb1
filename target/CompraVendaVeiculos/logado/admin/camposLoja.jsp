<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table class="table table-striped">
	<caption>
		<c:choose>
			<c:when test="${loja != null}">
            	<h6>Atualizar</h6><br/>
            </c:when>
			<c:otherwise>
            	<h6>Cadastrar</h6><br/>
            </c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${loja != null}">
		<input type="hidden" name="id" value="${loja.id}" />
	</c:if>
	<tr>
		<td><label for="nome">Nome</label></td>
		<td><input type="text" id="nome" name="nome" size="30"
			required value="${loja.nome}" /></td>
	</tr>
	<tr>
		<td><label for="email">Email</label></td>
		<td><input type="text" id="email" name="email" size="30" required
			value="${loja.email}" /></td>
	</tr>
	<tr>
		<td><label for="senha">Senha</label></td>
		<td><input type="text" id="senha" name="senha" size="30" required
			value="${loja.senha}" /></td>
	</tr>
	<tr>
		<td><label for="CNPJ">CNPJ</label></td>
		<td><input type="text" id="CNPJ" name="CNPJ" size="30" required
			value="${loja.CNPJ}" /></td>
	</tr>
	<tr>
		<td><label for="descricao">Descrição</label></td>
		<td><input type="text" id="descricao" name="descricao" required
			size="50" value="${loja.descricao}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salvar" /></td>
	</tr>
</table>