<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%@ page import="java.util.List"%>
<%@ page import="ads.fafica.modelo.Usuario"%>
<%@ page import="ads.fafica.modelo.Reporte"%>

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

List<Reporte> reportes = (List<Reporte>) request.getAttribute("reporte");

/*boolean pesquisa = (Boolean) request.getAttribute("pesquisa");

if(!pesquisa){*/
	
	if(reportes == null){
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("controladorReporte?acao=listar&usuario=" + usuario.getCodigoUsuario());
		dispatcher.forward(request, response);
	}

/*}*/
pageContext.setAttribute("reporte", reportes);


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
		function confirmarExclusao(){
		var confirmacao = confirm("Deseja realmente excluir o Reporte selecionado?");
		
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
		<h1>Status dos Reportes</h1>
	</div>
	<div class="container">



		<!-- Conteudo da pÃ¡gina -->
		<div id="status">


			<form id="contactform" action="controladorReporte" method="post">
				<input type="hidden" name="acao" value="pesquisar"> <input
					type="hidden" name="codigoUsuario"
					value="<%=usuario.getCodigoUsuario() %>">


				<div class="field" style="float: right; margin: 0 33px;">

					<label for="name">Pesquisar</label> <input type="text"
						class="input" name="pesquisa" id="pesquisa"
						placeholder="Digite sua pesquisa" size="100" />

					<button>Pesquisar</button>



				</div>




				<form>

					<a style="margin: 20px 0 0 20px;" href="reportar.jsp"> <img
						src="images/addRep.png" alt="Novo Reporte" title="Novo Reporte"></a>

					<!--<img align="right" src="images/editar.gif" alt="editar reporte" title="editar reporte"></a>-->

					<pg:pager id="p" maxPageItems="8" maxIndexPages="100"
						export="offset,currentPageNumber=pageNumber" scope="request">
						<pg:param name="keywords" />

						<table border="0" align="center" cellpadding="5" cellspacing="0">



							<tr bgColor="#ddd">
								<th><b>Código Reporte</b></th>
								<th><b>Tipo Reporte</b></th>
								<th><b>Descri&ccedil&atildeo</b></th>
								<th><b>Data Abertura</b></th>
								<th><b>Status</b></th>
								<th><b>A&ccedil&otildees</b></th>
							</tr>

							<c:if test="${empty reporte}">
								<tr>
									<td align="center">
										<p>Nenhum Reporte Cadastrado.</p>
									</td>
								</tr>
							</c:if>

							<c:forEach items="${reporte}" var="reporte" varStatus="i">


								<c:choose>

									<c:when test="${i.count % 2 == 0}">
										<tr bgColor="#eee">
											<%-- Use styles... fica melhor... --%>
									</c:when>
									<c:otherwise>
										<tr bgColor="#fff">
									</c:otherwise>


								</c:choose>


								<fmt:formatDate value="${reporte.dtAberturaReporte.time}"
									pattern="dd/MM/yyyy" var="dataFormatada" />

								<pg:item>
									<td>${reporte.codigoReporte}</td>
									<td>${reporte.tipoReporte}</td>
									<td>${reporte.descricaoReporte}</td>
									<td>${reporte.dtAberturaReporte}</td>
									<td>${reporte.statusReporte == 0 ? "Aberto" : "Fechado"}</td>

									<c:if test="${reporte.statusReporte == 0}">
										<td><a
											href="controladorReporte?acao=formularioEditarReporte&id=${reporte.codigoReporte}"><strong><span
													style="color: green;">Editar</span></strong> </a> <a
											href="controladorReporte?acao=excluir&id=${reporte.codigoReporte}&codigoUsuario=${reporte.codigoUsuario}"
											onClick="return confirmarExclusao()"> <strong><span
													style="color: red;">Excluir</span></strong></a></td>
									</c:if>
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
			<a href="homeComum.jsp">Home</a>
		</h2>
	</div>

</body>

</html>