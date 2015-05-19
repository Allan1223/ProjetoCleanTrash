package ads.fafica.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ads.fafica.controlador.ControladorUsuario;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.controlador.UsuarioNaoEncontradoException;
import ads.fafica.modelo.Usuario;

@WebServlet("/acessarSistema")
public class ServletAcessarSistema extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ControladorUsuario controladorUsuario;

	public ServletAcessarSistema() {
		try {
			this.controladorUsuario = new ControladorUsuario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		try {
			// Procura pelo usuário no banco de dados
			Usuario usuario = controladorUsuario.acessoAoSistema(email, senha);

			request.getSession().invalidate();
			HttpSession session = request.getSession(true);
			session.setAttribute("usuario", usuario);


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

			/*}*/
		} catch (UsuarioNaoEncontradoException e) {
			// se não encontrar da uma menssagem de erro e volta a tela de Login
			request.setAttribute("mensagem",
					"Usuario não encontrado!");

			request.setAttribute("validacaoUsuario","naoExiste");

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
