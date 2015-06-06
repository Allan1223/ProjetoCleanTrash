<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="ads.fafica.modelo.Usuario"%>
<% 
// Sessão do usuário 
if(session.getAttribute("usuario") == null) {
	// se o usuário não estiver logado será direcionado para a tela de Login
	response.sendRedirect("/cleantrash/index.jsp");
} 

Usuario usuario = (Usuario) session.getAttribute("usuario");

//Envia a sessao
session.setAttribute("usuario",usuario);



%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--<title>&{mesagem}</title>-->
<title>Clean Trash</title>

<style type="text/css">
#mensagem {
	border: 1px solid #aaa;
	width: 300px;
	heght: 200px;
	margin: 150px auto;
	padding: 10px 20px;
	background-color: #eee;
}

buttom {
	align: center;
}
</style>

</head>
<body>

	<div id="mensagem">

		${mensagem} <br /> <br /> <a href="${pagina}"><button>OK</button></a>



	</div>

</body>
</html>