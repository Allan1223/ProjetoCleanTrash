package ads.fafica.acao.usuario;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ads.fafica.controlador.ControladorUsuario;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.modelo.Usuario;

public class AcaoCadastrarUsuario implements AcaoUsuario {	

	ControladorUsuario controladorUsuario;

	public AcaoCadastrarUsuario(){

		try {
			this.controladorUsuario = new ControladorUsuario();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
	}

	@Override
	public void executarUsuario(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {

		int perfilUsuario, codigoUsuario = 1;

		String nome   = request.getParameter("nome");
		String email  = request.getParameter("emailCad");
		String senha  = request.getParameter("senhaCad");
		String perfil = request.getParameter("perfil");


		if (perfil.equals("Operador"))
			perfilUsuario = 1;
		else
			perfilUsuario = 2;

		Usuario usuario = new Usuario(codigoUsuario,nome,email,senha,perfilUsuario);

		try {			
			boolean existe = controladorUsuario.existe(usuario.getEmailUsuario());	

			if(!existe){				
				controladorUsuario.inserirUsuario(usuario);

				request.setAttribute("mensagem",
						"Usuario adicionado com sucesso!");

				// testa se o cadastro veio da página inicial
				if(perfil.equals("ComumInicial")){

					request.getSession().invalidate();
					HttpSession session = request.getSession(true);
					session.setAttribute("usuario",usuario);

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/homeComum.jsp");
					dispatcher.forward(request, response);

				}

				else{
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("controladorUsuario?acao=listar");
					dispatcher.forward(request, response);					
				}
			}

			else {

				request.setAttribute("mensagem",
						"Usuario já existe!");
				// retorna um erro
				request.setAttribute("validacaoUsuario","existe");
				// testa se o cadastro veio da página inicial para redirecionar a página
				if(perfil.equals("ComumInicial")){															
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);					
				}
				else{
					// controladorUsuario?acao=listar
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/cadastroUsuario.jsp");
					dispatcher.forward(request, response);
				}
			}				

		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}	
	}	
}
