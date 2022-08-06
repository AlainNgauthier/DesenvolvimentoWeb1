<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
		<head>
			<title>Espaço CLIENTE</title>
		</head>
		<body>
			<h2>Espaço CLIENTE ${sessionScope.usuarioLogado.nome}!!</h2>
			<%
				String contextPath = request.getContextPath().replace("/", "");
			%>
			<a href="/<%=contextPath%>/index.jsp">HOME</a><br/>
			<a href="/<%=contextPath%>/logout/logout">Sair</a>
		</body>
</html>