<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <fmt:bundle basename="message">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>LOGIN</title>
            <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css"/>
        </head>
        <body>
            <c:if test="${mensagens.existeErros}">
                <div id="erro">
                    <ul>
                        <c:forEach var="erro" items="${mensagens.erros}">
                            <li> ${erro} </li>
                            </c:forEach>
                    </ul>
                </div>
            </c:if>
            <form method="post" action="log.jsp">
                
                Email: <input type="text" name="login" value="${param.login}"/>
                
                <br/><br/>
                
                Senha: <input type="password" name="senha" />
                
                <br/><br/>
                
                <input type="submit" name="bOK" value="Login">
            </form>
        </body>
    </fmt:bundle>
</html>
