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

public class AcaoAlterarSenhaUsuario implements AcaoUsuario {

	ControladorUsuario controladorUsuario;

	public AcaoAlterarSenhaUsuario(){
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

		int  codigoUsuario = Integer.parseInt(request.getParameter("codigoUsuario"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("emailUsuario");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario(codigoUsuario,nome,email,senha,2);

		try {

			controladorUsuario.atualizarSenha(usuario);

			request.setAttribute("mensagem",
					"Usuario Alterado com Sucesso!");

			/*request.getSession().invalidate();
		        HttpSession session = request.getSession(true);
		        session.setAttribute("usuario",usuario);*/	        

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/homeComum.jsp");
			dispatcher.forward(request, response);


		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
