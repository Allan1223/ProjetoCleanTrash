package ads.fafica.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.fafica.acao.AcaoUsuario;
import ads.fafica.controlador.ControladorUsuario;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.modelo.Usuario;

public class AcaoCadastrarUsuario implements AcaoUsuario {
	
	private ControladorUsuario controladorUsuario;
	
	public AcaoCadastrarUsuario(){
		
		try {
			controladorUsuario = new ControladorUsuario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void executarUsuario(HttpServletRequest request,
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
					"Usuario adicionada com sucesso!");
			
			
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("servletPrimeiroCadastroUsuario?acao=homeComum");
			dispatcher.forward(request, response);
			
					    
		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
			
		}
		
		
		

	}
	
	
}
