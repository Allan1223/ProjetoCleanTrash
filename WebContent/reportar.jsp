<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="ads.fafica.modelo.Usuario"%>

<%@ page language="java"%>
<%
	// Sessão do usuário 
	if (session.getAttribute("usuario") == null) {
		// se o usuário não estiver logado será direcionado para a tela de Login
		response.sendRedirect("/cleantrash/index.jsp");
	}

	Usuario usuario = (Usuario) session.getAttribute("usuario");
	//Envia a sessao
	session.setAttribute("usuario", usuario);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>REFSOFT</title>
<!-- <link rel="stylesheet" type="text/css" href="css/reportar.css" />
<link rel="stylesheet" type="text/css" href="css/component.css" /> 
<link rel="stylesheet" type="text/css" href="css/cssForm.css" />-->

<link href="http://fonts.googleapis.com/css?family=Open+Sans:600" type="text/css" rel="stylesheet" />
<link href="css/estilo.css" type="text/css" rel="stylesheet" />

<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/mapa.js"></script>
<script type="text/javascript" src="js/jquery-ui.custom.min.js"></script>

</head>
<body>


	<div id="cabecalho">
		<h1>Reportar Problemas</h1>
	</div>

	 <div class="container"> 

		<!-- Conteudo da pagina -->
		 <div id="reportar"> 
		 <!-- controladorReporte -->
 
			<form id="contactformMapa" action="servletMap" method="post">

				<input type="hidden" name="acao" value="cadastrar"> 
				<input type="hidden" name="codigoUsuario" value=<%=usuario.getCodigoUsuario()%>>
				<input type="hidden" id="txtLatitude" name="txtLatitude" />
	            <input type="hidden" id="txtLongitude" name="txtLongitude" /> 
								
				
				<br/>
				
				<!-- Mapa -->
				
				<div id="apresentacao">
	             
	           
	                <div class="field">
						<label for="opcao">Tipo:</label> <select name="tipo">
							<option>Selecione</option>
							<option value="Eletrico">Eletrico</option>
							<option value="Saneamento">Saneamento</option>
							<option value="Limpeza">Limpeza</option>
							<option value="Mobilidade">Mobilidade</option>
						</select>
					</div>
					
					<div class="field">
						<label for="name">Descri&ccedil&atildeo:</label>
						<textarea name="descricao" name="descricao" maxlength="255" cols="30" rows="14" size="255" placeholder="Informe o problema"></textarea>
						<br>
						
	
					</div>
	
	
	        	</div>
	        	
        	 
				
			 <input type="reset" value="Limpar" class="button" />
				<input type="submit" name="enviar" class="button" value="Enviar" /> 
		 
		  	
		 </div>  				 
		 <div id="localizar">
		 
		

                                
                    <div class="campos">
                        <label for="txtEndereco">Endereço:</label>
                        <input type="text" id="txtEndereco" name="txtEndereco" value="Faculdade de Filosofia, Ciencias e Letras de Caruaru - Avenida Azevedo Coutinho, s/n - Petrópolis, Petrópolis, Caruaru - PE, 55030-340"/>
                        <input type="button" id="btnEndereco" name="btnEndereco" value="Mostrar no mapa" />
                    </div>
                    

                    <div id="mapa"></div>
               
               
		 </div>
		 
		 </form> 	
		 	
				
	 </div>
	 

	 
	 <div id="home">
	 
	 	<h2> <a href="homeComum.jsp">Voltar</a>   </h2>
	 	
	 </div> 
	 
	 
		
	
	<br>
	

</body>
</html>