package ads.fafica.acao.solucao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ads.fafica.controlador.ControladorSolucao;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.controlador.SolucaoNaoEncontradaException;
import ads.fafica.modelo.Solucao;

public class AcaoPesquisarSolucao implements AcaoSolucao {

	ControladorSolucao controladorSolucao;
	int codigoSolucao = 0;

	public AcaoPesquisarSolucao() {

		try {
			this.controladorSolucao = new ControladorSolucao();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Override
	public void executarSolucao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException, RepositorioException {

		String pesquisa = request.getParameter("pesquisa");

		if (pesquisa != "") {

			codigoSolucao = Integer.parseInt(request.getParameter("pesquisa"));

			try {

				List<Solucao> solucao = controladorSolucao
						.procurarSolucao(codigoSolucao);

				request.setAttribute("solucao", solucao);

				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/listarSolucao.jsp");
				dispatcher.forward(request, response);

			} catch (RepositorioException e) {
				e.printStackTrace();
			} catch (SolucaoNaoEncontradaException e) {

				request.setAttribute("solucoes", null);

				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/listarSolucao.jsp");
				dispatcher.forward(request, response);
				e.printStackTrace();
			}
		} else {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/controladorSolucao?acao=listar");
			dispatcher.forward(request, response);
		}
	}
}
