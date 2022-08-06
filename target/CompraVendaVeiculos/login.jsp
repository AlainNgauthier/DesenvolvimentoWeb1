<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html> 
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Login</title>
            
            <%-- <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css"/> --%>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
			<!-- Optional theme -->
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">	
			<!-- Latest compiled and minified JavaScript -->
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        
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
            <div class="page-header">
            	<h2>Fazer login</h2>
	            <form method="post" action="log.jsp" class="form-login">	            	
	            	<div>
	            		<div class="row">
		                	Email: <input type="text" name="login" value="${param.login}"/>
	            		</div>
	            		<div class="row">
			                Senha: <input type="password" name="senha" />
	            		</div>
	            	</div>
	            	<div class="row">
		                <button type="submit" class="btn btn-primary" name="bOK">Login</button>
	                <!-- <input type="submit" name="bOK" value="Login"> -->
	            	</div>	  
	            </form>            
            </div>
        </body>
</html>
