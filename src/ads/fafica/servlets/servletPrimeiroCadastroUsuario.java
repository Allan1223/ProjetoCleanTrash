package ads.fafica.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.fafica.controlador.ControladorUsuario;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.controlador.UsuarioNaoEncontradoException;
import ads.fafica.modelo.Usuario;

/**
 * Servlet implementation class servletPrimeiroCadastroUsuario
 */
@WebServlet("/servletPrimeiroCadastroUsuario")
public class servletPrimeiroCadastroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ControladorUsuario controladorUsuario;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletPrimeiroCadastroUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Esse Servlet sempre cria um usu�rio com o perfil 2(usu�rio comum)
		String nome = request.getParameter("nome");
		String email = request.getParameter("emailCad");
		String senha = request.getParameter("senhaCad");
		
		// na cria��o do usu�rio � preciso testar se j� existe usu�rio cadastrado,
		// se sim o c�digo do usu�rio ser� o ultimo c�digo cadastrado + 1, se n�o ser� 1

			
		int codigoUsuario = 1;
		
		Usuario usuario = new Usuario(codigoUsuario,nome,email,senha,2);
		
		try {
			controladorUsuario.inserirUsuario(usuario);
		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
