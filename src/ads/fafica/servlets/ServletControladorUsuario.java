package ads.fafica.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ads.fafica.acao.usuario.AcaoAlterarSenhaUsuario;
import ads.fafica.acao.usuario.AcaoCadastrarUsuario;
import ads.fafica.acao.usuario.AcaoEditarUsuario;
import ads.fafica.acao.usuario.AcaoExcluirUsuario;
import ads.fafica.acao.usuario.AcaoFormularioEditarUsuario;
import ads.fafica.acao.usuario.AcaoListarUsuario;
import ads.fafica.acao.usuario.AcaoPesquisarUsuario;
import ads.fafica.acao.usuario.AcaoUsuario;

@WebServlet("/controladorUsuario")
public class ServletControladorUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, AcaoUsuario> acoes = new HashMap<String, AcaoUsuario>();

	private Connection conn = null;

	public ServletControladorUsuario() {

		acoes.put("cadastrar", new AcaoCadastrarUsuario());
		acoes.put("listar", new AcaoListarUsuario());
		acoes.put("formularioEditarUsuario", new AcaoFormularioEditarUsuario());
		acoes.put("editar", new AcaoEditarUsuario());
		acoes.put("alterarSenha", new AcaoAlterarSenhaUsuario());
		acoes.put("excluir", new AcaoExcluirUsuario());
		acoes.put("pesquisar", new AcaoPesquisarUsuario());
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Esse Servlet sempre cria um usu�rio com o perfil 2(usu�rio comum)

		// recupera o valor do par�metro 'acao' da requisi��o
		String acao = request.getParameter("acao");

		// pega a classe de 'Acao' baseado no par�metro da requisi��o
		AcaoUsuario operacao = acoes.get(acao);

		if (operacao == null) {
			// se operacao == null � porque n�o existe classe 'Acao' com
			// a String informada, ent�o vamos usar a acao 'listar'
			operacao = acoes.get("listar");
		}
		// chama o m�todo executar da classe de 'Acao' passando request e
		// response
		try {
			operacao.executarUsuario(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
