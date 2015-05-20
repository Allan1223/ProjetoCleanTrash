<%  
    session.invalidate();  
          
%> 
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
		
			function validar() {
				
				
				var senhaUser     = window.document.getElementById("senhaCad").value;
				var rep_senhaUser = window.document.getElementById("senhaConf").value;
				
									
				if (senhaUser.length < 6){
					window.alert('Senhas Incorreta: digite a senha com mais de 6 caracteres!');
					registrar.senhaUser.focus();
					return false;			
					
				}
				if (senhaUser != rep_senhaUser) {
					window.alert('Senhas diferentes: Confirme a senha corretamente!');
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
                            
                            <form  action="acessarSistema" autocomplete="on" method="Post" > 
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
								
								 <% 
                            
		                            
											String validacao = (String)request.getAttribute("validacaoUsuario");
														
																				
											if(validacao != null){
												if(validacao.equals("naoExiste")){
													
													%>
													<h4 style="color:red;">
												 		<% out.println("Usu&aacuterio ou Senha inv&aacutelidos!"); %>
													</h4>
												<%											
													
													
												}
											}
											
									%>
									
									
										
								
                                <p class="login button"> 
                                    <input type="submit" value="Entrar" /> 
								</p>
								
									
				
                                <p class="change_link">
									N&atildeo cadastrado ?
									<a href="#toregister" class="to_register">Cadastre-se</a>
								</p>
                            </form>
                            
                           
                              
								
                        </div>
                        
                        
                        <div id="register" class="animate form">
                            <form nome="registrar" id="registrar" action="controladorUsuario" autocomplete="on" method="Post"> 
                                <input type="hidden" name="acao" value="cadastrar">
                                <input type="hidden" name="perfil" value="ComumInicial">                                
                                
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
                                
                                <% 
                            
		                            
			                                String validacaoExiste = (String)request.getAttribute("validacaoUsuario");
											
											if(validacaoExiste != null){
												if(validacaoExiste.equals("existe")){
													
													%>
													<h4 style="color:red;">
												 		<% out.println("Usu&aacuterio j&aacute Existe!"); %>
													</h4>
													
													
												<%											
												}
											}
											
									%>
									
                                <p class="signin button"> 
									<input type="submit"  value="Cadastrar" onclick="return validar()"/> 
								</p>
                                <p class="change_link">  
									J&aacute cadastrado ?
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