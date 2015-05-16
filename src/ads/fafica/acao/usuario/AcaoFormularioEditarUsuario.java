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
import ads.fafica.controlador.UsuarioNaoEncontradoException;
import ads.fafica.modelo.Usuario;

public class AcaoFormularioEditarUsuario implements AcaoUsuario {

	ControladorUsuario controladorUsuario;

	public AcaoFormularioEditarUsuario() {

		try {
			this.controladorUsuario = new ControladorUsuario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}


	}

	@Override
	public void executarUsuario(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		// TODO Auto-generated method stub

		int codigoUsuario = Integer.parseInt(request.getParameter("id"));

		try {
			Usuario usuario = controladorUsuario.procurarUsuarioId(codigoUsuario);

			request.setAttribute("usuarioEditar",usuario);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/editarUsuario.jsp");
			dispatcher.forward(request, response);

		} catch (UsuarioNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
