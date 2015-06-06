<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="ads.fafica.modelo.Usuario"%>
<%@ page import="ads.fafica.modelo.Reporte"%>

<%@ page language="java"%>
<%
//Sessão do usuário 
if(session.getAttribute("usuario") == null) {
	// se o usuário não estiver logado será direcionado para a tela de Login
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
<title>Clean Trash</title>

<link rel="icon" href="imagens/logo.png" type="image/png" />
<link rel="shortcut icon" href="imagens/logo.png" type="image/png" /> 

<!-- <link rel="stylesheet" type="text/css" href="css/reportar.css" />
<link rel="stylesheet" type="text/css" href="css/component.css" /> 
<link rel="stylesheet" type="text/css" href="css/cssForm.css" />-->

<link href="http://fonts.googleapis.com/css?family=Open+Sans:600" type="text/css" rel="stylesheet" />

<link href="css/estilo.css" type="text/css" rel="stylesheet" />

<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/mapa.js"></script>
<script type="text/javascript" src="js/jquery-ui.custom.min.js"></script>

<script language="javascript" type="text/javascript">       
        function atualizar()
        {
            
        	document.getElementById("btnEndereco").click();
        	
            
        }
    </script>
    
</head>
<body onload="atualizar()">
	<div id="cabecalho">
		<h1>Fechar Reporte</h1>
	</div>

	<div class="container">

		<!-- Conteudo da pÃ¡gina -->
		<!-- <div id="reportar"> -->

			<form id="contactform" action="controladorSolucao?acao=cadastrar"
				method="post">

				<input type="hidden" name="codigoUsuario"
					value=<%=usuario.getCodigoUsuario()%>> <input type="hidden"
					name="codigoReporte" value=<%=reporte.getCodigoReporte()%>>


			<div id="apresentacao" >
	             
	           		 <h4> Informações sobre Reporte </h4>	
	           		 <br/>
						<div class="field">
							<label for="name">Problema:</label> <input type="text"
								class="input" name="rua" id="rua" required="required"
								value="<%=reporte.getTipoReporte()%>" disabled />
		
						</div>
		
						
						<div class="field">
							<label for="name">Descri&ccedil&atildeo:</label>
							<textarea name="descricaoSolucao" name="descricaoSolucao"
								maxlength="255" cols="30" rows="5" size="255" disabled><%=reporte.getDescricaoReporte()%></textarea>
							<br>
		
		
						</div>
						<div class="field">
							<label for="name">Solu&ccedil&atildeo:</label>
							<textarea name="descricaoSolucao" name="descricaoSolucao"
								maxlength="255" cols="30" rows="5" size="255" required="required"></textarea>
							<br>
		
		
						</div>
			<div/>
				<div class="campos">
                        <label for="txtEndereco">Endereço:</label>
                        <input type="text" id="txtEndereco" name="txtEndereco" value="<%=reporte.getEndereco() %>" required="required" />
                        <input type="button" id="btnEndereco" name="btnEndereco" value="Mostrar no mapa" />
                    </div>
                    

<!-- value="Faculdade de Filosofia, Ciencias e Letras de Caruaru - Avenida Azevedo Coutinho, s/n - Petrópolis, Petrópolis, Caruaru - PE, 55030-340" -->
                    <div id="mapa"></div>
                    
                   
               
               
		 <!--  </div>  -->
		 
		 		
				<input type="submit" name="enviar" class="button" value="Fechar" /> 


			</form>
		</div>
		
	<br>
	<div id="home">
		<h2>
			<a href="controladorReporte?acao=listarReporteOperador">Reportes</a>
		</h2>
	</div>

</body>
</html>