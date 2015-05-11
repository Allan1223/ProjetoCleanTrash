<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page  import="java.util.List" %>
<%@ page  import="ads.fafica.modelo.Usuario" %>

<%



if(session.getAttribute("usuario") == null) {

	response.sendRedirect("/cleantrash/index.jsp");
} 

Usuario usuario = (Usuario) session.getAttribute("usuario");
//Envia a sessao
session.setAttribute("usuario",usuario);



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
		<link rel="stylesheet" type="text/css" href="css/manutencao.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		<link rel="stylesheet" type="text/css" href="css/cssForm.css" />
		<!--<script src="js/modernizr.custom.js"></script> -->
		
		
		<script language="javascript" type="text/javascript">
		
			function validar() {
				
					
				var senhaAtual     = document.registrar.senhaAtual.value;
				var senha = document.registrar.senha.value;
				var confirmarSenha     = document.registrar.confirmar.value;
								
				if(senhaAtual = <%=usuario.getSenha()%>){
				
									
					if (senha != confirmarSenha) {
						alert('Senhas diferentes');
						document.registrar.senhaConf.focus();
						return false;
					}
				
				}
				else{
					
					alert('Senhas diferentes');
					document.registrar.confirmar.focus();
					return false;
					
					
				}
	
	
				
			}
		</script>
		
	</head>
	<body>
	
	<%//=usuario.getEmailUsuario()%>
	
		<div id="cabecalho"><h1> Alterar Senha </h1></div>
			<div class="container">
			
				<!-- Contepudo da página -->
				<!-- Conteudo da página -->
				<div id="manutencao">
					
					<form id="contactform" name="registrar" action="controladorUsuario" method="post">
					
					<input type="hidden" name="acao" value="alterarSenha">
                    <input type="hidden" name="perfil" value="Comum">
                    <input type="hidden" name="emailUsuario" value="<%=usuario.getEmailUsuario()%>">  
                    <input type="hidden" name="codigoUsuario" value="<%=usuario.getCodigoUsuario()%>">    
						
						
						<div class="field">
							<label for="name">Email:*</label>
							<input type="text" class="input" name="email" id="email" required="required" value="<%=usuario.getEmailUsuario() %>" disabled/>
							
						</div>
						
						<div class="field">
							<label for="name">Nome:*</label>
							<input type="text" class="input" name="nome" id="nome" required="required" value="<%=usuario.getNomeUsuario() %>"/>
							<p class="hint">Edite seu nome.</p>
						</div>
						
						
						<div class="field">
							<label for="name">Senha Atual:*</label>
							<input type="password" class="input" name="senhaAtual" id="senhaAtual" required="required" />
							<p class="hint">Senha Atual.</p>
						</div>
						<div class="field">
							<label for="name">Senha:*</label>
							<input type="password" class="input" name="senha" id="senha" required="required" />
							<p class="hint">Nova Senha.</p>
						</div>
						<div class="field">
							<label for="name">Confirmar Senha:*</label>
							<input type="password" class="input" name="confirmar" id="confirmar" required="required" />
							<p class="hint">Confime a Senha.</p>
						</div>
						
						<!--  <input type="reset" value="Limpar" class="button" />-->
					    <input type="submit" name="btnEnviar" class="button" value = "Alterar" />
				
					</form>
				</div>	
				
				
			</div>
		<div id="home"><h2><a href="homeComum.jsp">Home</a></h2></div>
		
	</body>
	
</html>