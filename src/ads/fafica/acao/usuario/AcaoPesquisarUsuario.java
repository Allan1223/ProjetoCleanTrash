package ads.fafica.acao.usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.fafica.controlador.ControladorUsuario;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.controlador.UsuarioNaoEncontradoException;
import ads.fafica.modelo.Usuario;

public class AcaoPesquisarUsuario implements AcaoUsuario {

	ControladorUsuario controladorUsuario;
	int codigoUsuario = 0;
	
	public AcaoPesquisarUsuario(){
		
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
		
						
		String pesquisa = request.getParameter("pesquisa");
		
		if (pesquisa != ""){
		
			codigoUsuario = Integer.parseInt(request.getParameter("pesquisa"));
					
		
			try {
				
						
				List<Usuario> usuario = controladorUsuario.procurarUsuario(codigoUsuario);
				
				request.setAttribute("usuarios", usuario);	
							
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/manUsuario.jsp");
				dispatcher.forward(request, response);
				
				
			} catch (UsuarioNaoEncontradoException e) {
				// TODO Auto-generated catch block
				
				request.setAttribute("usuarios", null);
				
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/manUsuario.jsp");
				dispatcher.forward(request, response);
				
				
				e.printStackTrace();
			} catch (RepositorioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else{
			
								
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/controladorUsuario?acao=listar");
			dispatcher.forward(request, response);
		}

	}

}
