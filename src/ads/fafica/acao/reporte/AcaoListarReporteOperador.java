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

public class AcaoListarReporteOperador implements AcaoReporte {

	ControladorReporte controladorReporte;

	public AcaoListarReporteOperador() {

		try {
			controladorReporte = new ControladorReporte();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void executarReporte(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		try {

			List<Reporte> reporte = controladorReporte.listarReporteOperador();

			request.setAttribute("reporte", reporte);			

			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/reportesOperador.jsp");
			dispatcher.forward(request, response);

		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProblemaNaoEncontradoException e) {

			request.setAttribute("reporte", null);			

			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/reportesOperador.jsp");
			dispatcher.forward(request, response);
		}



	}

}
