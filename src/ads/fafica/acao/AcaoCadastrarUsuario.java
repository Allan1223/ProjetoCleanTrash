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
			
		}
	}

	@Override
	public void executarUsuario(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		
		int perfilUsuario, codigoUsuario = 1;
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("emailCad");
		String senha = request.getParameter("senhaCad");
		String perfil = request.getParameter("perfil");
		
						
		if(perfil.equals("Operador"))
			perfilUsuario = 1;
		else 
			perfilUsuario = 2;
			
		
		
		Usuario usuario = new Usuario(codigoUsuario,nome,email,senha,perfilUsuario);
		
		try {
			
			boolean existe = controladorUsuario.existe(usuario.getEmailUSuario());	
			
			if(!existe){
			controladorUsuario.inserirUsuario(usuario);		
			request.setAttribute("mensagem",
					"Usuario adicionado com sucesso!");
			
			// controladorUsuario?acao=listar
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/manUsuario.jsp");
			dispatcher.forward(request, response);
			}
			else {
				
				request.setAttribute("mensagem",
						"Usuario j� existe!");
				
				// controladorUsuario?acao=listar
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/cadastroUsuario.jsp");
				dispatcher.forward(request, response);
			}
				
					    
		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
						
		}
		
	}	
	/*	public void executarUsuarioComum(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException,
				SQLException {
			
			String nome = request.getParameter("nome");
			String email = request.getParameter("emailCad");
			String senha = request.getParameter("senhaCad");
				
			
			int codigoUsuario = 1;
			
			Usuario usuario = new Usuario(codigoUsuario,nome,email,senha,2);
			
			try {
				
				boolean existe = controladorUsuario.existe(usuario.getEmailUSuario());	
				
				if(!existe){
					controladorUsuario.inserirUsuario(usuario);	
					
					request.setAttribute("mensagem",
							"Usuario adicionado com sucesso!");
					
					
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/homeComum.jsp");
					dispatcher.forward(request, response);
				}
				else {
					
					request.setAttribute("mensagem",
							"Usuario j� existe!");
					
					// controladorUsuario?acao=listar
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
				}
						    
			} catch (RepositorioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
							
			}
			
		

		}
	
	}*/
	
}