package ads.fafica.acao.usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.fafica.controlador.ControladorUsuario;
import ads.fafica.modelo.Usuario;

public class AcaoListarUsuario implements AcaoUsuario  {

	ControladorUsuario controladorUsuario;
	@Override
	public void executarUsuario(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			controladorUsuario = new ControladorUsuario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		List<Usuario> usuario = controladorUsuario.listarUsuarios();

		request.setAttribute("usuarios", usuario);


		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/manUsuario.jsp");
		dispatcher.forward(request, response);


	}

}
