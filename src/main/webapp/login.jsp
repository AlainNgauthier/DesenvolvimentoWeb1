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
            <div class="container" role="main">
	            <div class="page-header">
	            	<h2>Fazer login</h2>
	            	<div class="container">
			            <form method="post" action="login">			            	
			            	<div class="form-group">
			            		<label for="inputEmail">Email</label>
				                <input type="text" name="login" value="${param.login}" class="form-control" id="inputEmail" />
			            	</div>			            		
			            	<div class="form-group">
			            	<label for="inputPassword">Senha</label>
					        	<input type="password" name="senha" class="form-control" id="inputPassword"/>
			            		</div>			            				            				            		            				            				            	
				            <button type="submit" class="btn btn-primary" name="bOK">Login</button>			            		  
			            </form>            
	            	</div>
	            </div>
	            <div class="row">
		             <c:if test="${mensagens.existeErros}">
		                <div class="row">
		                    <ul>
		                        <c:forEach var="erro" items="${mensagens.erros}">
		                            <li> ${erro} </li>
		                        </c:forEach>
		                    </ul>
		                </div>
		            </c:if>
	            </div>
            </div>
        </body>
</html>
