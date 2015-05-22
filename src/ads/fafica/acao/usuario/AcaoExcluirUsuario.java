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

public class AcaoExcluirUsuario implements AcaoUsuario {

	ControladorUsuario controladorUsuario;

	public AcaoExcluirUsuario() {

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
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			// excluir usuário
			controladorUsuario.excluirUsuario(id);

		} catch (UsuarioNaoEncontradoException e) {
			e.printStackTrace();
		} catch (RepositorioException e) {
			e.printStackTrace();
		}

		request.setAttribute("mensagem", "Usuario excluído com sucesso!");

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("controladorUsuario?acao=listar");
		dispatcher.forward(request, response);

	}

}
