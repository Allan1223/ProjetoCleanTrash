package ads.fafica.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import ads.fafica.acao.AcaoCadastrarUsuario;
import ads.fafica.acao.AcaoUsuario;
import ads.fafica.controlador.ControladorUsuario;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.modelo.Usuario;

/**
 * Servlet implementation class servletPrimeiroCadastroUsuario
 */
@WebServlet("/controladorUsuario")
public class ServletControladorUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private Map<String, AcaoUsuario> acoes = new HashMap<String, AcaoUsuario>();
	
	 
       
    /**
     * @throws Exception 
     * @see HttpServlet#HttpServlet()
     */

	private Connection conn = null;
	
    public ServletControladorUsuario(){
        
    	acoes.put("cadastrar", new AcaoCadastrarUsuario()); 
        /*acoes.put("listar", new AcaoListarMedico());*/
        /*acoes.put("formularioAdicionarMedico", new AcaoFormularioAdicionarMedico());
        acoes.put("editar", new AcaoEditarMedico());
        acoes.put("excluir", new AcaoExcluirMedico());
        acoes.put("salvarEdicao", new AcaoSalvarEdicaoMedico());*/
    	
    	
    	
    	try {
    		 
    		System.out.println("ainda sim!");
    		
    		Class.forName("com.mysql.jdbc.Driver"); 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cleantrash", "root", "admin");
			
			System.out.println("conectou!");
			//conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_projeto_mvc", "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
        
        
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
		
		// recupera o valor do par�metro 'acao' da requisi��o
				String acao = request.getParameter("acao");
				String tipo = request.getParameter("tipo");
				// pega a classe de 'Acao' baseado no par�metro da requisi��o
				AcaoUsuario operacao      = acoes.get(acao);
				
				
				if (operacao == null) {
					// se operacao == null � porque n�o existe classe 'Acao' com 
					// a String informada, ent�o vamos usar a acao 'listar' 
					operacao = acoes.get("listar");
				}
				// chama o m�todo executar da classe de 'Acao' passado request e response
				try {
					
					if (tipo.equals("comum"))
						operacao.executarUsuarioComum(request, response);
					else 
						operacao.executarUsuario(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		/* PrintWriter out = response.getWriter();
		 
		 

	        // escreve o texto
	        out.println("<html>");
	        out.println("<body>");
	        out.println("Primeira servlet: " + nome + "-" + email + "-" + senha);
	        out.println("</body>");
	        out.println("</html>");
		 
		 response.setContentType("text/html");
		    String pagina="http//www.google.com";
		    response.sendRedirect(pagina);
		
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
			e.getMessage();
			
		}*/
		
		
		
		
		
	}

}
