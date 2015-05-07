<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Acesso ao Sistema</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
		
		
		<script language="javascript" type="text/javascript">
		
		
			function acessoUsuario(){
				<% 
					//Boolean validacao = (Boolean)request.getAttribute("validacaoUsuario");
				
					//if(validacao != null){
					//	if(validacao){
					
				%>
					alert("Usuario Inexistente!");
					
				<%
					//	}
					//}
					
				%>	
			}
			function validar() {
				
				
				
				
				
				var senhaUser     = document.registrar.senhaCad.value;
				var rep_senhaUser = document.registrar.senhaConf.value;
				
				alert(senhaUser);		
				
				
				if (senhaUser != rep_senhaUser) {
					alert('Senhas diferentes');
					registrar.senhaConf.focus();
					return false;
				}
	
	
				
			}
		</script>

		
		
    </head>
    <body>
        <div class="container">
            
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="acessarSistema" autocomplete="on" method="Post" onload="return acessoUsuario()"> 
                                <h1>Acesso ao Sistema</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > Digite seu email </label>
                                    <input id="email" name="email" required="required" type="text" placeholder="email@mail.com"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> Digite Sua Senha </label>
                                    <input id="senha" name="senha" required="required" type="password" placeholder="eg. X8df!90EO" /> 
                                </p>
                                <!--<p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
									<label for="loginkeeping">Keep me logged in</label>
								</p>-->
                                <p class="login button"> 
                                    <input type="submit" value="Entrar" /> 
								</p>
								
									
				
                                <p class="change_link">
									Não é cadastrado ?
									<a href="#toregister" class="to_register">Cadastre-se</a>
								</p>
                            </form>
                            
                               <% 
									Boolean validacao = (Boolean)request.getAttribute("validacaoUsuario");
								
									if(validacao != null){
										if(validacao){
							
								%>
									<p>Usuario Inexistente!</p>
									
								<%
										}
									}
									
								%>
								
                        </div>

                        <div id="register" class="animate form">
                            <form nome="registrar" id="registrar" action="controladorUsuario" autocomplete="on" method="Post"> 
                                <input type="hidden" name="acao" value="cadastrar">
                                <input type="hidden" name="perfil" value="Comum">
                                
                                <h1> Cadastre-se </h1> 
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Seu Nome</label>
                                    <input id="nome" name="nome" required="required" type="text" placeholder="Usuario" />
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail" data-icon="e" > Seu email</label>
                                    <input id="emailCad" name="emailCad" required="required" type="email" placeholder="email@mail.com"/> 
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">Sua Senha </label>
                                    <input id="senhaCad" name="senhaCad" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p> 
                                <!--  Validar se a senha é igual a senhaConfirm com javascript no clique do botão Submit -->
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Confirme sua Senha </label>
                                    <input id="senhaConf" name="senhaConf" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p class="signin button"> 
									<input type="submit"  value="Cadastrar" onclick="return validar()"/> 
								</p>
                                <p class="change_link">  
									Já é cadastrado ?
									<a href="#tologin" class="to_register"> Ir pra o Login </a>
								</p>
                            </form>
                        </div>
						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>