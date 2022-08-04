<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${cliente != null}">
                            Edição
                        </c:when>
			<c:otherwise>
                            Cadastro
                        </c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${cliente != null}">
		<input type="hidden" name="id" value="${cliente.id}" />
	</c:if>
	<tr>
		<td><label for="email">Email</label></td>
		<td><input type="text" id="email" name="email" size="45"
			required value="${cliente.email}" /></td>
	</tr>
	<tr>
		<td><label for="senha">Senha</label></td>
		<td><input type="text" id="senha" name="senha" size="45" required
			value="${cliente.senha}" /></td>
	</tr>
	<tr>
    	<td><label for="nome">Nome</label></td>
    	<td><input type="text" id="nome" name="nome" size="45" required
    		value="${cliente.nome}" /></td>
    </tr>
	<tr>
    	<td><label for="nascimento">Data Nascimento</label></td>
    	<td><input type="text" id="nascimento" name="nascimento" size="45" required
    		value="${cliente.nascimento}" /></td>
    </tr>
	<tr>
    	<td><label for="sexo">Sexo</label></td>
    	<td><input type="text" id="sexo" name="sexo" size="45" required
    		value="${cliente.sexo}" /></td>
    </tr>
	<tr>
    	<td><label for="cpf">CPF</label></td>
    	<td><input type="text" id="cpf" name="cpf" size="45" required
    		value="${cliente.cpf}" /></td>
    </tr>
	<tr>
    	<td><label for="telefone">Telefone</label></td>
    	<td><input type="text" id="telefone" name="telefone" size="45" required
    		value="${cliente.telefone}" /></td>
    </tr>

	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>