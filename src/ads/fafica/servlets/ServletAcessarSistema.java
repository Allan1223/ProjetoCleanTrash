package ads.fafica.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.fafica.controlador.ControladorUsuario;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.controlador.UsuarioNaoEncontradoException;
import ads.fafica.modelo.Usuario;

/**
 * Servlet implementation class ServletAcessarSistema
 */
@WebServlet("/acessarSistema")
public class ServletAcessarSistema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	ControladorUsuario controladorUsuario;
	
    public ServletAcessarSistema() {
    	try {
			this.controladorUsuario = new ControladorUsuario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		try {
			// Procura pelo usuário no banco de dados
			Usuario usuario = controladorUsuario.acessoAoSistema(email, senha);
			// se não encontrar da uma menssagem de erro e volta a tela de Login
			
		
					
			if (usuario.getNomeUsuario() == null){
								
				System.out.println("aqui");
				request.setAttribute("mensagem",
						       "Usuario não encontrado!");
				
				request.setAttribute("validacaoUsuario",false);
				
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}	
			//se encontrar, recupera o perfil e chama a página correspondente
			else{
				
				if (usuario.getPerfilUsuario() == 1){
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/homeOperador.jsp");
					dispatcher.forward(request, response);
				}
				else{
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/homeComum.jsp");
					dispatcher.forward(request, response);
				}
				
			}
		} catch (UsuarioNaoEncontradoException e) {
			request.setAttribute("mensagem",
				       "Usuario não encontrado!");
		
				request.setAttribute("validacaoUsuario",false);
				
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
		
			//e.printStackTrace();
		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
