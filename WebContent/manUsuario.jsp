<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%
	//@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"
%>
<%@ page import="java.util.List"%>
<%@ page import="ads.fafica.modelo.Usuario"%>

<%@ page language="java"%>
<%
	// Sessão do usuário 
if(session.getAttribute("usuario") == null) {
	// se o usuário não estiver logado será direcionado para a tela de Login
	response.sendRedirect("/cleantrash/index.jsp");
} 

Usuario usuario = (Usuario) session.getAttribute("usuario");
//Envia a sessao
session.setAttribute("usuario",usuario);


List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");

if(usuarios == null){
	
	RequestDispatcher dispatcher = 
			request.getRequestDispatcher("controladorUsuario?acao=listar");
	dispatcher.forward(request, response);
}

pageContext.setAttribute("usuario", usuarios);

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
<script type="text/javascript">
	function validarLetras(){
		var filtroPesquisa = document.getElementById("filtroPesquisa").value;
		var pesquisa = document.getElementById("pesquisa").value;
		
		if (filtroPesquisa == "codigoUsuario") {
			//var regex = /^[0-9]+$/;
			if (isNaN(pesquisa)) {
				window.alert("Para pesquisar por código, use números.");
				return false;
				
			} else {
				
				return true;
			}
		}
	}
	
	function confirmarExclusao(){
		var confirmacao = confirm("Deseja realmente excluir o usuário selecionado?");
		
		if (confirmacao){
			return true;
		}
		else{
			return false;			
		}
		
	}
	
	
</script>

</head>
<body>


	<div id="cabecalho">
		<h1>Manuten&ccedil&atildeo Usu&aacute;rio</h1>
	</div>
	<div class="container">


		<!-- Conteudo da pÃ¡gina -->
		<div id="status">


			<form id="contactform" action="controladorUsuario" method="post">
				<input type="hidden" name="acao" value="pesquisar">


				<div class="field" style="float: right; margin: 0 33px;">
					<select name="filtroPesquisa" id="filtroPesquisa">
						<option value="codigoUsuario">Codigo Usuario</option>
						<option value="emailUsuario">E-mail</option>
						<option value="nomeUsuario">Nome</option>
					</select> <label for="name">Pesquisar</label> <input type="text"
						class="input" name="pesquisa" id="pesquisa"
						placeholder="Digite sua pesquisa" size="100" />

					<button onClick="return validarLetras()">Pesquisar</button>



				</div>

			</form>

			<a style="margin: 0px 0 0 20px;" href="cadastroUsuario.jsp"> <img
				src="images/novo.png" alt="Novo Usuario" title="Novo Usuario"></a>

			<!--<img align="right" src="images/editar.gif" alt="editar reporte" title="editar reporte"></a>-->

			<pg:pager id="p" maxPageItems="8" maxIndexPages="100"
				export="offset,currentPageNumber=pageNumber" scope="request">
				<pg:param name="keywords" />
				<!-- tabela dinâmica -->

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
								<tr bgColor="#eee">
									<%-- Use styles... fica melhor... --%>
							</c:when>
							<c:otherwise>
								<tr bgColor="#fff">
							</c:otherwise>

						</c:choose>

						<pg:item>
							<td>${usuario.codigoUsuario}</td>
							<td>${usuario.nomeUsuario}</td>
							<td>${usuario.emailUsuario}</td>
							<td>${usuario.perfilUsuario == 1 ? "Operador" : "Comum"}</td>
							<td><a
								href="controladorUsuario?acao=formularioEditarUsuario&id=${usuario.codigoUsuario}"><strong><span
										style="color: green;">Editar</span></strong> </a> <a
								href="controladorUsuario?acao=excluir&id=${usuario.codigoUsuario}"
								onClick="return confirmarExclusao()"> <strong><span
										style="color: red;">Excluir</span></strong>
							</a></td>
						</pg:item>

					</c:forEach>


				</table>

				<br>
				<br>


				<div align="center">
					<pg:index>
						<pg:prev>
							<a href="<%= pageUrl %>"><strong>&lt;&lt; Anterior</strong></a>
						</pg:prev>
						<pg:pages>
							<a href="<%= pageUrl %>"><strong><%= pageNumber %></strong></a>
						</pg:pages>
						<pg:next>
							<a href="<%= pageUrl %>"><strong>Próximo &gt;&gt;</strong></a>
						</pg:next>
					</pg:index>
			</pg:pager>

		</div>


	</div>





	</div>

	<div id="home">
		<h2>
			<a href="homeOperador.jsp">Home</a>
		</h2>
	</div>

</body>

</html>