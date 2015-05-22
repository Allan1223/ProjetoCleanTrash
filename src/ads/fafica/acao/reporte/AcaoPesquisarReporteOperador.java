package ads.fafica.acao.reporte;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ads.fafica.controlador.ControladorReporte;
import ads.fafica.controlador.ProblemaNaoEncontradoException;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.modelo.Reporte;

public class AcaoPesquisarReporteOperador implements AcaoReporte {

	ControladorReporte controladorReporte;
	int codigoReporte;
	String statusReporte;
	String tipoReporte;
	String descricaoReporte;

	public AcaoPesquisarReporteOperador() {
		try {
			this.controladorReporte = new ControladorReporte();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void executarReporte(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {

		String pesquisa = request.getParameter("pesquisa");
		String filtroPesquisa = request.getParameter("filtroPesquisa");

		// Pesquisa por código
		if (pesquisa != "") {

			if (filtroPesquisa.equals("codigoReporte")) {
				codigoReporte = Integer.parseInt(request
						.getParameter("pesquisa"));

				try {
					List<Reporte> reporte = controladorReporte
							.procurarReporteOperadorPorCodigo(codigoReporte);

					request.setAttribute("reporte", reporte);

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/reportesOperador.jsp");
					dispatcher.forward(request, response);

				} catch (ProblemaNaoEncontradoException e) {

					request.setAttribute("reportes", null);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/reportesOperador.jsp");
					dispatcher.forward(request, response);

					e.printStackTrace();
				} catch (RepositorioException e) {

					e.printStackTrace();
				}
			}
		} // Pesquisa por código
			// Pesquisa por status
		else if (filtroPesquisa.equals("statusReporte")) {
			statusReporte = request.getParameter("pesquisa");

			try {
				List<Reporte> reporte = controladorReporte
						.procurarReporteOperadorPorStatus(statusReporte);

				request.setAttribute("reporte", reporte);

				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/reportesOperador.jsp");
				dispatcher.forward(request, response);

			} catch (ProblemaNaoEncontradoException e) {

				request.setAttribute("reportes", null);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/reportesOperador.jsp");
				dispatcher.forward(request, response);

				e.printStackTrace();
			} catch (RepositorioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // Pesquisa por status

		// Pesquisa por tipo
		else if (filtroPesquisa.equals("tipoReporte")) {
			tipoReporte = request.getParameter("pesquisa");

			try {
				List<Reporte> reporte = controladorReporte
						.procurarReporteOperadorPorTipo(tipoReporte);

				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/reportesOperador.jsp");
				dispatcher.forward(request, response);

			} catch (ProblemaNaoEncontradoException e) {

				request.setAttribute("reportes", null);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/reportesOperador.jsp");
				dispatcher.forward(request, response);

				e.printStackTrace();
			} catch (RepositorioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Pesquisa por tipo
		}

		// Pesquisa por descricao
		else if (filtroPesquisa.equals("descricaoReporte")) {
			descricaoReporte = request.getParameter("pesquisa");

			try {
				List<Reporte> reporte = controladorReporte
						.procurarReporteOperadorPorDescricao(descricaoReporte);

				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/reportesOperador.jsp");
				dispatcher.forward(request, response);
			} catch (ProblemaNaoEncontradoException e) {

				request.setAttribute("reportes", null);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/reportesOperador.jsp");
				dispatcher.forward(request, response);
				e.printStackTrace();

			} catch (RepositorioException e) {
				e.printStackTrace();
			} // Pesquisa por descricao
		}

		else {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/controladorReporte?acao=listarReporteOperador");
			dispatcher.forward(request, response);
		}
	}
}
