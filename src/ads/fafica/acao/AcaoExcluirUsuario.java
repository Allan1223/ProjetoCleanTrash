package ads.fafica.acao;

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

	ControladorUsuario controlador;
	
	@Override
	public void executarUsuario(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		// TODO Auto-generated method stub
		
		 try {
				controlador = new ControladorUsuario();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		try {
			//excluir usuário
			controlador.excluirUsuario(id);
			
			System.out.println("excluir");
		} catch (UsuarioNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("mensagem", "Usuario excluído com sucesso!");
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("controladorUsuario?acao=listar");
		dispatcher.forward(request, response);
		
		

	}

}
