<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page  import="java.util.List" %>
<%@ page  import="ads.fafica.modelo.Usuario" %>
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
			
				<!-- Contepudo da página -->
				<!-- Conteudo da página -->
				<div id="reportar">
					
					<form id="contactform" action="#" method="get">
						
						<div class="field">
							<label for="name">Nome:*</label>
							<input type="text" class="input" name="nome" id="nome" required="required" value="Allan Silva" />
							<p class="hint">Edite seu nome.</p>
						</div>
						
						<div class="field">
							<label for="name">Email:*</label>
							<input type="email" class="input" name="senhaAtu" id="senhaAtu" required="required" value="allan@mail.com" />
							<p class="hint">Senha Atual.</p>
						</div>
						
						<div class="field">
						<label for="opcao">Perfil:</label>
						<select name="opcao">
							<option> Selecione o Perfil</option>
							<option value = "1">Comum</option>
							<option value = "2">Operador</option>
							
						</select>
						</div>						
							
							
						<div class="field">
							<label for="name">Senha Atual:*</label>
							<input type="text" class="input" name="senha" id="senha" required="required" value="123456" />
							<p class="hint">Nova Senha.</p>
						</div>
						
						<div class="field">
							<label for="name">Nova Senha:*</label>
							<input type="text" class="input" name="senha" id="senha"   />
							<p class="hint">Nova Senha.</p>
						</div>
						
						<div class="field">
							<label for="name">Confirmar Senha:*</label>
							<input type="text" class="input" name="confirmar" id="confirmar"  />
							<p class="hint">Confime a Senha.</p>
						</div>
						
						<input type="reset" value="Limpar" class="button" />
					    <input type="submit" name="btnEnviar" class="button" value = "Editar" />
				
					</form>
				</div>	
				
				
			</div>
		<div id="home"><h2><a href="ManUsuario.html">Manuten&ccedil&atildeo Usu&aacute;rio</a></h2></div>
		
	</body>
	
</html>