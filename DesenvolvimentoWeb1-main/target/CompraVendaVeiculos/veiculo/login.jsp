<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Compra/Venda de Veículos</title>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>

        <form action="servlet1" method="post">
            Email:<input type="text" name="email"/><br/><br/>
            Senha:<input type="text" name="senha"/><br/><br/>
           <input type="submit" value="login"/>
        </form>

    	<h2>
    		<a href="/<%=contextPath%>/veiculos/adm">Adm</a> &nbsp;&nbsp;&nbsp; <a
    		    href="">Cliente</a> &nbsp;&nbsp;&nbsp; <a
                href="">Loja</a>
    	</h2>

</body>
</html>