package ads.fafica.acao.usuario;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.fafica.controlador.ControladorUsuario;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.controlador.UsuarioNaoEncontradoException;
import ads.fafica.modelo.Usuario;

public class AcaoEditarUsuario implements AcaoUsuario {

	ControladorUsuario controladorUsuario;

	public AcaoEditarUsuario() {

		try {
			this.controladorUsuario = new ControladorUsuario();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void executarUsuario(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {

		int codigoUsuario = Integer.parseInt(request
				.getParameter("codigoUsuario"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String perfil = request.getParameter("perfil");

		int perfilUsuario;

		if (perfil.equals("Operador")) {

			perfilUsuario = 1;

		} else {

			perfilUsuario = 2;
		}

		Usuario usuario = new Usuario(codigoUsuario, nome, email, senha,
				perfilUsuario);

		try {
			controladorUsuario.atualizarUsuario(usuario);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("controladorUsuario?acao=listar");
			dispatcher.forward(request, response);

		} catch (RepositorioException e) {
			e.printStackTrace();
		} catch (UsuarioNaoEncontradoException e) {
			e.printStackTrace();
		}

	}

}
