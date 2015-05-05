package ads.fafica.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.fafica.controlador.ControladorUsuario;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.modelo.Usuario;

public class AcaoCadastrarUsuario implements AcaoUsuario {
	
	
		ControladorUsuario controladorUsuario;
	
	public AcaoCadastrarUsuario(){
		
		try {
			this.controladorUsuario = new ControladorUsuario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Cacete Voador!");
		}
	}

	@Override
	public void executarUsuario(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("emailCad");
		String senha = request.getParameter("senhaCad");
		String perfil = request.getParameter("perfil");
			
		
		int codigoUsuario = 1;
		
		Usuario usuario = new Usuario(codigoUsuario,nome,email,senha,Integer.parseInt(perfil));
		
		try {
			
			controladorUsuario.inserirUsuario(usuario);		
			request.setAttribute("mensagem",
					"Usuario adicionada com sucesso!");
			
			
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("controladorUsuario?acao=listar");
			dispatcher.forward(request, response);
			
					    
		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
						
		}
		
	}	
		public void executarUsuarioComum(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException,
				SQLException {
			
			String nome = request.getParameter("nome");
			String email = request.getParameter("emailCad");
			String senha = request.getParameter("senhaCad");
				
			
			int codigoUsuario = 1;
			
			Usuario usuario = new Usuario(codigoUsuario,nome,email,senha,2);
			
			try {
				
				controladorUsuario.inserirUsuario(usuario);	
				request.setAttribute("mensagem",
						"Usuario adicionado com sucesso!");
				
				
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/homeComum.jsp");
				dispatcher.forward(request, response);
				
						    
			} catch (RepositorioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
							
			}
			
		

	}

	
	
}
