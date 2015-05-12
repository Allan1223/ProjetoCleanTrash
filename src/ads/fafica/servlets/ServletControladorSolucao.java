package ads.fafica.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.fafica.acao.solucao.AcaoCadastrarSolucao;
import ads.fafica.acao.solucao.AcaoListarSolucao;
import ads.fafica.acao.solucao.AcaoSolucao;
import ads.fafica.acao.usuario.AcaoCadastrarUsuario;
import ads.fafica.acao.usuario.AcaoListarUsuario;
import ads.fafica.acao.usuario.AcaoUsuario;

/**
 * Servlet implementation class ServletControladorSolucao
 */
@WebServlet("/controladorSolucao")
public class ServletControladorSolucao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private Map<String, AcaoSolucao> acoes = new HashMap<String, AcaoSolucao>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletControladorSolucao() {
     
    	acoes.put("cadastrar", new AcaoCadastrarSolucao()); 
        acoes.put("listar", new AcaoListarSolucao());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Esse Servlet sempre cria um usuário com o perfil 2(usuário comum)
		
				// recupera o valor do parâmetro 'acao' da requisição
						String acao = request.getParameter("acao");
						
						// pega a classe de 'Acao' baseado no parâmetro da requisição
						AcaoSolucao operacao      = acoes.get(acao);
												
						
						if (operacao == null) {
							// se operacao == null é porque não existe classe 'Acao' com 
							// a String informada, então vamos usar a acao 'listar' 
							operacao = acoes.get("listar");
						}
						// chama o método executar da classe de 'Acao' passado request e response
						try {
																	
								operacao.executarSolucao(request, response);
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	}

}
