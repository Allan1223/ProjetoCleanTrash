package ads.fafica.acao.reporte;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.fafica.controlador.ControladorReporte;
import ads.fafica.controlador.ProblemaNaoEncontradoException;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.modelo.Reporte;

public class AcaoFormularioEditarReporte implements AcaoReporte {

	ControladorReporte controladorReporte;

	public AcaoFormularioEditarReporte() {

		try {
			this.controladorReporte = new ControladorReporte();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void executarReporte(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {

		int codigoReporte = Integer.parseInt(request.getParameter("id"));

		try {
			Reporte reporte = controladorReporte
					.procurarReporteId(codigoReporte);

			request.setAttribute("reporteEditar", reporte);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/editarReporte.jsp");
			dispatcher.forward(request, response);

		} catch (RepositorioException e) {
			e.printStackTrace();
		}
		 catch (ProblemaNaoEncontradoException e) {
				e.printStackTrace();
			}

	}

}
