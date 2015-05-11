<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page  import="java.util.List" %>
<%@ page  import="ads.fafica.modelo.Usuario" %>
<% 
// Sessão do usuário 
if(session.getAttribute("usuario") == null) {
	// se o usuário não estiver logado será direcionado para a tela de Login
	response.sendRedirect("/cleantrash/index.jsp");
} 

Usuario usuario = (Usuario) session.getAttribute("usuario");

//Envia a sessao
session.setAttribute("usuario",usuario);

Usuario usuarioEditar = (Usuario) request.getAttribute("usuarioEditar");

%>
<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
		<!--<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Clean Trash</title>
		<meta name="description" content="Dynamic Grid with CSS Transitions inspired by the Google Trends Grid Visualization" />
		<meta name="keywords" content="google trends, dynamic grid, css transitions, javascript, responsive, fluid, layout" />
		<meta name="author" content="Codrops" />
		<link rel="shortcut icon" href="../favicon.ico"> -->
		<link rel="stylesheet" type="text/css" href="css/cadUsuario.css" />
		<link rel="stylesheet" type="text/css" href="css/componentCadUsuario.css" />
		<link rel="stylesheet" type="text/css" href="css/cssFormCadUsuario.css" />
		<!--<script src="js/modernizr.custom.js"></script> -->
	</head>
	<body>
		<div id="cabecalho">
		  <h1> Editar Usu&aacute;rio</h1></div>
			<div class="container">
			
				<!-- Contepudo da pÃ¡gina -->
				<!-- Conteudo da pÃ¡gina -->
				<div id="reportar">
					
					<form id="contactform" action="controladorUsuario" method="post">
						<input type="hidden" name="acao" value="editar">
						<input type="hidden" name="codigoUsuario" value="<%=usuarioEditar.getCodigoUsuario()%>">
						
						<div class="field">
							<label for="name">Email:*</label>
							<input type="email" class="input" name="email" id="email" required="required" value="<%=usuarioEditar.getEmailUsuario() %>" />
							<p class="hint">Editar email.</p>
						</div>
						
						<div class="field">
							<label for="name">Nome:*</label>
							<input type="text" class="input" name="nome" id="nome" required="required" value="<%=usuarioEditar.getNomeUsuario() %>" />
							<p class="hint">Editar nome.</p>
						</div>
						
						
						
						<div class="field">
						<label for="opcao">Perfil:</label>
						<select name="perfil">
							<option> Selecione o Perfil</option>
							<option value = "Comum">Comum</option>
							<option value = "Operador">Operador</option>
							
						</select>
						</div>						
							
							
						<div class="field">
							<label for="name">Senha Atual:*</label>
							<input type="text" class="input" name="senha" id="senha" required="required" value="<%=usuarioEditar.getSenha() %>" />
							<p class="hint">Nova Senha.</p>
						</div>
																		
						<!--  <input type="reset" value="Limpar" class="button" />-->
					    <input type="submit" name="btnEnviar" class="button" value = "Editar" />
				
					</form>
				</div>	
				
				
			</div>
		<div id="home"><h2><a href="controladorUsuario?acao=listar">Manuten&ccedil&atildeo Usu&aacute;rio</a></h2></div>
		
	</body>
	
</html>