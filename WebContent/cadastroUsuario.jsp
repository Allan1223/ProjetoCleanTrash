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
		<link rel="stylesheet" type="text/css" href="css/cadUsuario.css" />
		<link rel="stylesheet" type="text/css" href="css/componentCadUsuario.css" />
		<link rel="stylesheet" type="text/css" href="css/cssFormCadUsuario.css" />
		<!--<script src="js/modernizr.custom.js"></script> -->
	</head>
	<body>
		<div id="cabecalho">
		  <h1> Cadastrar Usu&aacute;rio</h1></div>
			<div class="container">
			<script type="text/javascript">
			
                function validaForm(){
                    
                	// os campos nome e email já tem validações com o HTML5
                    //var nome = document.getElementById("nome").value;
                    //var email = document.getElementById("emailCad").value;
                    var perfil = document.getElementById("perfil").value;
                	var senha = document.getElementById("senhaCad").value;
    				var conSenha = document.getElementById("confirmar").value;

					if(perfil == ""){
						  alert ("Selecione um Perfil!");
						  return false;
						}
					//chamando a função
					if(!validarLetras(nome)){
							alert("Este campo só recebe letras!");
							 return false;
						}
					if(senha.length() >= 6){
						
						alert("Senha inválida: digite 6 ou mais caracteres!");
						   return false;
					}
				   
			  	   if(senha != confSenha){
					   alert("Senha inválida: preencha novamennte!");
					   return false;
				    } else {
							alert("Cadastro realizado com sucesso:");
							return true;
					    }
           }
			// se o conteudo não for letras retorne false
           function validarLetras(campo){
				var regex = /^[a-zA-Z]+$/;
				if(regex.test(campo)){
						return true;
					}
						return false;
               }             
			</script>
			
				<!-- Contepudo da pÃ¡gina -->
				<!-- Conteudo da pÃ¡gina -->
				<div id="reportar">
					
					
					<form id="contactform"  action="controladorUsuario" autocomplete="on" method="Post" onsubmit="validaForm();"> 
                        <input type="hidden" name="acao" value="cadastrar">
                        <input type="hidden" name="tipo" value="cadastrar">
						
						<div class="field">
							<label for="name">Nome:*</label>
							<input type="text" class="input" name="nome" id="nome" required="required" />
							<p class="hint">Edite seu nome.</p>
						</div>
						
						<div class="field">
							<label for="name">Email:*</label>
							<input type="email" class="input" name="emailCad" id="emailCad" required="required" />
							<p class="hint">Senha Atual.</p>
						</div>
						
						<div class="field">
						<label for="opcao">Perfil:</label>
						<select name="perfil">
							<option> Selecione o Perfil</option>
							<option value = "Comum">Comum</option>
							<option value = "Operador">Operador</option>
							
						</select>
						</div>											
							
						<div class="field">
							<label for="name">Senha:*</label>
							<input type="password" class="input" name="senhaCad" id="senhaCad" required="required" />
							<p class="hint">Nova Senha.</p>
						</div>
						<div class="field">
							<label for="name">Confirmar Senha:*</label>
							<input type="password" class="input" name="confirmar" id="confirmar" required="required" />
							<p class="hint">Confime a Senha.</p>
						</div>
						
						<input type="reset" value="Limpar" class="button" />
					    <input type="submit" name="btnEnviar" class="button" value = "Cadastrar" />
				
					</form>
				</div>	
				
				
			</div>
		<div id="home"><h2><a href="controladorUsuario?acao=listar">Manuten&ccedil&atildeo Usu&aacute;rio</a></h2></div>
		
	</body>
	
</html>