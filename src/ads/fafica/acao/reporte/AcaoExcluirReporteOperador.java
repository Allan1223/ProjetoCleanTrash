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

public class AcaoExcluirReporteOperador implements AcaoReporte {

	ControladorReporte controladorReporte;

	public AcaoExcluirReporteOperador() {

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

		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			// excluir reporte
			controladorReporte.excluirReporte(id);

		} catch (ProblemaNaoEncontradoException e) {
			e.printStackTrace();
		} catch (RepositorioException e) {
			e.printStackTrace();
		}

		request.setAttribute("mensagem", "Reporte excluído com sucesso!");

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("controladorReporte?acao=listarReporteOperador");
		dispatcher.forward(request, response);

	}

}
