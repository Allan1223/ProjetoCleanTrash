<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page  import="java.util.List" %>
<%@ page  import="ads.fafica.modelo.Usuario" %>
<%@ page  import="ads.fafica.modelo.Solucao" %>

<%@ page language="java" %>
<%
// Sessão do usuário 
/*if(session.getAttribute("usuario") == null) {
	// se o usuário não estiver logado será direcionado para a tela de Login
	response.sendRedirect("/cleantrash/index.jsp");
} 

Usuario usuario = (Usuario) session.getAttribute("usuario");
//Envia a sessao
session.setAttribute("usuario",usuario);
*/
// Recebe a instancia do reporte a ser solucionada
Solucao solucao = (Solucao) request.getAttribute("solucao");

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
		<link rel="stylesheet" type="text/css" href="css/status.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		<!--<script src="js/modernizr.custom.js"></script> -->
	</head>
	<body>
		<div id="cabecalho"><h1> Reportes </h1></div>
			<div class="container">
			
			
			
				<!-- Conteudo da pÃ¡gina -->
				<div id="status">
				
					
				<form id="contactform" action="#" method="get">
						
			
					<div class="field">
								
								<label for="name">Pesquisar</label>
								<input type="text" class="input" name="pesquisa" id="pesquisa" placeholder="Digite sua pesquisa" size="100" />
								
								<button>Pesquisar</button>
								
								
								
					</div>
					
					
					
						
				<form>
				
					<!--<img align="right" src="images/editar.gif" alt="editar reporte" title="editar reporte"></a>-->
				<!-- tabela dinâmica -->
				<table border="0" align="center">
						<tr>
						<td>
							<table border="0" align="center" cellpadding="5" cellspacing="0">
																		
															
								
								<tr bgColor="#ddd">
									<th><b>Codigo Usuario</b></th>
									<th><b>Nome</b></th>
									<th><b>Email</b></th>
									<th><b>Perfil</b></th>
									<th><b>Acoes</b></th>
								</tr>
								
								<c:if test="${empty usuarios}">
								<tr>
									<td align="center">
										<p>Nenhum Usuario Cadastrado.</p>
									</td>
								</tr>
								</c:if>
													
								<c:forEach items="${usuarios}" var="usuario" varStatus="i">
									<c:choose>							
										
										<c:when test="${i.count % 2 == 0}">  
							                <tr bgColor="#eee"> <%-- Use styles... fica melhor... --%>  
							            </c:when>  
							            <c:otherwise>  
							                <tr bgColor="#fff">  
							            </c:otherwise> 
															
									</c:choose>	
																						 
										<td>${usuario.codigoUsuario}</td>
										<td>${usuario.nomeUsuario}</td>
										<td>${usuario.emailUsuario}</td>
										<td>${usuario.perfilUsuario}</td>
										
									
										<td><a href="controladorUsuario?acao=formularioEditarUsuario&id=${usuario.codigoUsuario}"><strong><span style="color:green;">Editar</span></strong>	</a>
										<a href="controladorUsuario?acao=excluir&id=${usuario.codigoUsuario}">   <strong><span style="color:red;">Excluir</span></strong></a>
										 </td>
							 
									
								</c:forEach>
			    
								
							</table>
						</td>
						</tr>
					</table>	

				
				</div>
							
			</div>
		<div id="home"><h2><a href="homeOperador.html">Home</a></h2></div>
		
	</body>
	
</html>