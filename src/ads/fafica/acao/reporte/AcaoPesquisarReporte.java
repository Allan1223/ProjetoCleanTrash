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

public class AcaoPesquisarReporte implements AcaoReporte {

	ControladorReporte controladorReporte;

	public AcaoPesquisarReporte() {

		try {
			this.controladorReporte = new ControladorReporte();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void executarReporte(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {

		String pesquisa = request.getParameter("pesquisa");
		int codigoUsuario = Integer.parseInt(request.getParameter("codigoUsuario"));

		if (pesquisa != "") {

			int codigoReporte = Integer.parseInt(pesquisa);

			try {

				List<Reporte> reporte = controladorReporte.procurarReporte(
						codigoReporte, codigoUsuario);

				request.setAttribute("reporte", reporte);
				/*request.setAttribute("pesquisa", true);*/

				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/status.jsp");
				dispatcher.forward(request, response);

			} catch (ProblemaNaoEncontradoException e) {

				
				request.setAttribute("reporte", null);
				/*request.setAttribute("pesquisa", true);*/
				
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/status.jsp");
				dispatcher.forward(request, response);

				e.printStackTrace();
			} catch (RepositorioException e) {
				e.printStackTrace();
			}
		} else {

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/controladorReporte?acao=listar&usuario="
							+ codigoUsuario);
			dispatcher.forward(request, response);
		}
	}
}
