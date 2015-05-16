<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page  import="java.util.List" %>
<%@ page  import="java.text.SimpleDateFormat" %>
<%@ page  import="ads.fafica.modelo.Usuario" %>
<%@ page  import="ads.fafica.modelo.Solucao" %>


<%@ page language="java" %>
<%

//Sess�o do usu�rio 
if(session.getAttribute("usuario") == null) {
	// se o usu�rio n�o estiver logado ser� direcionado para a tela de Login
	response.sendRedirect("/cleantrash/index.jsp");
} 

Usuario usuario = (Usuario) session.getAttribute("usuario");
//Envia a sessao
session.setAttribute("usuario",usuario);

// Recebe a instancia do reporte a ser solucionada
List<Solucao> solucoes = (List<Solucao>) request.getAttribute("solucao");
System.out.println("novo" + solucoes.get(0));
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
		<div id="cabecalho"><h1> Solu&ccedil&atildeo </h1></div>
			<div class="container">
			
			
			
				<!-- Conteudo da página -->
				<div id="status">
				
					
				<form id="contactform" action="#" method="get">
						
			
					<div class="field">
								
								<label for="name">Pesquisar</label>
								<input type="text" class="input" name="pesquisa" id="pesquisa" placeholder="Digite sua pesquisa" size="100" />
								
								<button>Pesquisar</button>
								
								
								
					</div>
					
					
					
						
				<form>
				
					<!--<img align="right" src="images/editar.gif" alt="editar reporte" title="editar reporte"></a>-->
				<!-- tabela din�mica -->
				
							<table border="0" align="center" cellpadding="5" cellspacing="0">
																		
															
								
								<tr bgColor="#ddd">
									<th><b>Codigo Solucao</b></th>
									<th><b>C�digo Reporte</b></th>
									<th><b>Descricao</b></th>
									<th><b>Data Fechamento</b></th>
									<th><b>Hora Fechamento</b></th>
								</tr>
								
								<c:if test="${empty solucao}">
								<tr>
									<td align="center">
										<p>Nenhuma Solucao Cadastrada.</p>
									</td>
								</tr>
								</c:if>
													
								<c:forEach items="${solucao}" var="solucao" varStatus="i">
								
								
								 
									<c:choose>							
										
										<c:when test="${i.count % 2 == 0}">  
							                <tr bgColor="#eee"> <%-- Use styles... fica melhor... --%>  
							            </c:when>  
							            <c:otherwise>  
							                <tr bgColor="#fff">  
							            </c:otherwise> 
															
															
									</c:choose>	
									
									
										<fmt:formatDate value="${solucao.dtFechamentoSolucao.time}" pattern="dd/MM/yyyy" var="dataFormatada" />									
									
																															 
										<td>${solucao.codigoSolucao}</td>
										<td>${solucao.codigoReporte}</td> 
										<td>${solucao.descricaoSolucao}</td>
										<td>${solucao.dtFechamentoSolucao}</td>
										<td>${solucao.hrFechamentoSolucao}</td>
													
																																			 
									
								</c:forEach>
			    
								
							</table>
						

				
				</div>
							
			</div>
		<div id="home"><h2><a href="homeOperador.jsp">Home</a></h2></div>
		
	</body>
	
</html>
