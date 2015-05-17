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

import ads.fafica.acao.reporte.AcaoCadastrarReporte;
import ads.fafica.acao.reporte.AcaoEditarReporte;
import ads.fafica.acao.reporte.AcaoExcluirReporte;
import ads.fafica.acao.reporte.AcaoFormularioEditarReporte;
import ads.fafica.acao.reporte.AcaoListarReporte;
import ads.fafica.acao.reporte.AcaoListarReporteOperador;
import ads.fafica.acao.reporte.AcaoPesquisarReporte;
import ads.fafica.acao.reporte.AcaoReporte;

/**
 * Servlet implementation class ServletControladorReporte
 */
@WebServlet("/controladorReporte")
public class ServletControladorReporte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, AcaoReporte> acoes = new HashMap<String, AcaoReporte>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletControladorReporte() {

		acoes.put("cadastrar", new AcaoCadastrarReporte()); 
		acoes.put("listar", new AcaoListarReporte());
		acoes.put("formularioEditarReporte", new AcaoFormularioEditarReporte());
		acoes.put("editar", new AcaoEditarReporte());
		acoes.put("excluir", new AcaoExcluirReporte());
		acoes.put("pesquisar", new AcaoPesquisarReporte());
		acoes.put("listarReporteOperador", new AcaoListarReporteOperador());
		acoes.put("solucionarReporte", new AcaoSolucionarReporte());
		
		
		
		
		

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// recupera o valor do parâmetro 'acao' da requisição
		String acao = request.getParameter("acao");

		// pega a classe de 'Acao' baseado no parâmetro da requisição
		AcaoReporte operacao      = acoes.get(acao);

		if (operacao == null) {
			// se operacao == null é porque não existe classe 'Acao' com 
			// a String informada, então vamos usar a acao 'listar' 
			operacao = acoes.get("listar");
		}

		// chama o método executar da classe de 'Acao' passado request e response
		try {

			operacao.executarReporte(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
