<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page  import="java.util.List" %>
<%@ page  import="ads.fafica.modelo.Usuario" %>
<%@ page  import="ads.fafica.modelo.Reporte" %>

<%@ page language="java" %>
<%
// Sess„o do usu·rio 
if(session.getAttribute("usuario") == null) {
	// se o usu·rio n„o estiver logado ser· direcionado para a tela de Login
	response.sendRedirect("/cleantrash/index.jsp");
} 

Usuario usuario = (Usuario) session.getAttribute("usuario");
//Envia a sessao
session.setAttribute("usuario",usuario);

// Recebe a instancia do reporte a ser solucionada
Reporte reporte = (Reporte) request.getAttribute("reporte");

%>


<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>REFSOFT</title>
		<link rel="stylesheet" type="text/css" href="css/reportar.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		<link rel="stylesheet" type="text/css" href="css/cssFormSolucao.css" />
		
	</head>
	<body>
		<div id="cabecalho"><h1> Fechar Reporte </h1></div>		
		
			<div class="container">
			
				<!-- Conteudo da p√°gina -->
				<div id="reportar">
					
					<form id="contactform" action="controladorSolucao?acao=cadastrar" method="post">
					
						<!--<input type="hidden" name="codigoUsuario" value=<%//=usuario.getCodigoUsuario()%>>-->
						<!-- <input type="hidden" name="codigoProblema" value=<%//=problema.getCodigoProblema()%>> -->					
						<input type="hidden" name="codigoUsuario" value="5" />
						<input type="hidden" name="codigoProblema" value="1" />
						
											
						<div class="field">
							<label for="name">Problema:</label>
							<input type="text" class="input" name="rua" id="rua" required="required" value="Eletrico" disabled />
							
						</div>					
							
						<div class="field">
							<label for="name">Rua:</label>
							<input type="text" class="input" name="rua" id="rua" required="required" value="Valdira Martins" disabled />
							
						</div>
						
						<div class="field">
							<label for="name">Bairro:</label>
							<input type="text" class="input" name="bairro" id="bairro" required="required" value="COHAB I" disabled />
							
						</div>
						
						<div class="field">
							<label for="name">Cidade:</label>
							<input type="text" class="input" name="cidade" id="cidade" required="required" value="Caruaru" disabled />
							
						</div>
								
						<div class="field">	
							<label for="name">Descri&ccedil&atildeo:</label>
							<textarea name="descricaoSolucao" name = "descricaoSolucao" maxlength = "255" cols = "30" rows = "5" size = "255" disabled>Falta de Iluminacao em alguns pontos da rua</textarea><br>
							
							
						</div>	
						<div class="field">	
							<label for="name">Solu&ccedil&atildeo:</label>
							<textarea name="descricaoSolucao" name = "descricaoSolucao" maxlength = "255" cols = "30" rows = "5" size = "255" required="required" ></textarea><br>
							
							
						</div>	
					
					<input type="reset" value="Limpar" class="button" />
					<input type="submit" name="Fechar" class="button" value = "Fechar" />
					
						
					</form>
				</div>
				<div id="localizar">
					<span>Endere√ßo</span>
					<!--<p><img src="classic-google-maps-2.png" alt="Google Maps"></p>-->
					
					<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d7896.367229218682!2d-35.97097330052696!3d-8.284517284520124!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x7a98b96e8d7fd6d%3A0xa30a5c7c9e363ef5!2sCaruaru+-+PE!5e0!3m2!1spt-BR!2sbr!4v1427718327757" width="490" height="290" frameborder="0" style="border:0"></iframe>
				</div>
			</div><br>
		<div id="home"><h2><a href="problemas.html">Reportes</a></h2></div>
		
	</body>	
</html>