<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="ads.fafica.modelo.Usuario"%>
<%@ page import="ads.fafica.modelo.Reporte"%>
<% 
// Sessão do usuário 
if(session.getAttribute("usuario") == null) {
	// se o usuário não estiver logado será direcionado para a tela de Login
	response.sendRedirect("/cleantrash/index.jsp");
} 

Usuario usuario = (Usuario) session.getAttribute("usuario");

//Envia a sessao
session.setAttribute("usuario",usuario);

Reporte reporteEditar = (Reporte) request.getAttribute("reporteEditar");

%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Clean Trash</title>

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
		<h1>Editar Reporte</h1>
	</div>

	<div class="container">

		<!-- Conteudo da pÃ¡gina -->
		<!-- <div id="reportar"> -->

			<form id="contactform" action="controladorReporte" method="post">
				<input type="hidden" name="acao" value="editar"> <input
					type="hidden" name="codigoReporte"
					value="<%=reporteEditar.getCodigoReporte()%>"> <input
					type="hidden" name="codigoUsuario"
					value="<%=usuario.getCodigoUsuario()%>">
					<input type="hidden" id="txtLatitude" name="txtLatitude" />
	                <input type="hidden" id="txtLongitude" name="txtLongitude" /> 


				<br/>
				
				 <div id="apresentacao" >
	             
	           		 <h4> Informações sobre Reporte </h4>	
	           		 <br/>
						<div class="field">
							<label for="opcao">Tipo:</label> <select name="tipo">
								<option>Selecione</option>
								<option value="Eletrico"
									<% if(reporteEditar.getTipoReporte().equals("Eletrico")){  %>
									selected <%} %>>Eletrico</option>
								<option value="Saneamento"
									<% if(reporteEditar.getTipoReporte().equals("Saneamento")){  %>
									selected <%} %>>Saneamento</option>
								<option value="Limpeza"
									<% if(reporteEditar.getTipoReporte().equals("Limpeza")){  %>
									selected <%} %>>Limpeza</option>
								<option value="Mobilidade"
									<% if(reporteEditar.getTipoReporte().equals("Mobilidade")){  %>
									selected <%} %>>Mobilidade</option>
							</select>
						</div>
		
						
		
		
						<div class="field">
							<label for="name">Descri&ccedil&atildeo:</label>
							<textarea name="descricao" name="descricao" maxlength="255"
								cols="30" rows="5" size="255"><%=reporteEditar.getDescricaoReporte()%>
								</textarea>
							<br>
							<p class="hint">Digite a Descri&ccedil&atildeo do problema.</p>
		
						</div>

				</div> 
				
				<div class="campos">
                        <label for="txtEndereco">Endereço:</label>
                        <input type="text" id="txtEndereco" name="txtEndereco" value="<%=reporteEditar.getEndereco() %>" required="required" />
                        <input type="button" id="btnEndereco" name="btnEndereco" value="Mostrar no mapa" />
                    </div>
                    

<!-- value="Faculdade de Filosofia, Ciencias e Letras de Caruaru - Avenida Azevedo Coutinho, s/n - Petrópolis, Petrópolis, Caruaru - PE, 55030-340" -->
                    <div id="mapa"></div>
                    
                   
               
               
		 <!--  </div>  -->
		 
		 		<input type="reset" value="Limpar" class="button" />
				<input type="submit" name="enviar" class="button" value="Editar" /> 


			</form>
		</div>
		
	<!-- </div> -->
	<br>

	<div id="home">
		<h2>
			<a
				href="controladorReporte?acao=listar&codigoUsuario=<%=usuario.getCodigoUsuario() %>">Voltar</a>
		</h2>
	</div>

</body>
</html>