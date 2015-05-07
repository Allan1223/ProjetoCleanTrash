<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<link rel="stylesheet" type="text/css" href="css/status.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		<!--<script src="js/modernizr.custom.js"></script> -->
	</head>
	<body>
		<div id="cabecalho"><h1> Manuten&ccedil&atildeo Usu&aacute;rio </h1></div>
			<div class="container">
			
			
			
				<!-- Conteudo da pÃ¡gina -->
				<div id="status">
				
					
				<form id="contactform" action="#" method="get">
						
			
					<div class="field" style="float: right; margin: 0 33px;">
								
								<label for="name">Pesquisar</label>
								<input type="text" class="input" name="pesquisa" id="pesquisa" placeholder="Digite sua pesquisa" size="100" />
								
								<button>Pesquisar</button>
								
								
								
					</div>				
						
				<form>
				
				<a style=" margin: 0px 0 0 20px;" href="cadastroUsuario.jsp"> <img src="images/novo.png" alt="Novo Usuario" title="Novo Usuario"></a>
				
					<!--<img align="right" src="images/editar.gif" alt="editar reporte" title="editar reporte"></a>-->

					<!-- tabela dinâmica -->
				<table border="1" align="center">
						<tr>
						<td>
							<table border="0" align="center" cellpadding="5" cellspacing="0">
																		
								<!-- <tr>
									<td align="center">
										<a href="controladorMedico?acao=formularioAdicionarMedico">Adicionar Medicos</a>
									</td>
								</tr> -->
				
								<tr>
									<th><b>Codigo Usuario</b></th>
									<th><b>Nome</b></th>
									<th><b>Email</b></th>
									<th><b>Perfil</b></th>
									<th><b>Acoes</b></th>
								</tr>
								
								<%
									List<Usuario> usuario = (List<Usuario>) request.getAttribute("usuarios");
									
								if(usuario == null){
								%>	
									<tr>
									<td align="center">
										<p>Nenhum Usuario Cadastrado.</p>
									</td>
									</tr>
								<%}
								else{
									for(Usuario usuar: usuario){
																									
								%>
									<tr>
										<td><%=usuar.getCodigoUsuario()%></td>
										<td><%=usuar.getNomeUsuario()%>  </td>
										<td><%=usuar.getEmailUSuario()%> </td>
										<td><%=usuar.getPerfilUsuario()%></td>
										
										<td><a href="controladorUsuario?acao=editar&id=<%=usuar.getCodigoUsuario()%>">
										<img src="images/editar.png" width='40px' height="40px" alt="Editar Usuario" title="Editar Usuario"></a>
										</a>
										    <a href="controladorUsuario?acao=excluir&id=<%=usuar.getCodigoUsuario()%>">
										    <img src="images/excluir.png" width='40px' height="40px" alt="Excluir Usuario" title="Excluir Usuario">
										    </a> 
										</td>
								    </tr>
								<%}
									
								}%>
								
									
										
										
																		
									
									
								<!-- 	
								<c:if test="${empty usuarios}">
								<tr>
									<td align="center">
										<p>Nenhum Usuario Cadastrado.</p>
									</td>
								</tr>
								</c:if>
								
								
					
								<c:forEach items="${usuarios}" var="usuario">
								<tr>
									<td>${usuario.codigoUsuario}</td>
									<td>${usuario.nome}</td>
									<td>${usuario.email}</td>
									<td>${usuario.perfil}</td>
									
								
									<td><a href="controladorMedico?acao=editar&id=${medico.id}">Editar</a>
											<a href="controladorMedico?acao=excluir&id=${medico.id}">Excluir</a> </td>
								</tr>
								</c:forEach> -->
							</table>
						</td>
						</tr>
					</table>
					
					


				
				</div>
							
			</div>
		<div id="home"><h2><a href="homeOperador.jsp">Home</a></h2></div>
		
	</body>
	
</html>