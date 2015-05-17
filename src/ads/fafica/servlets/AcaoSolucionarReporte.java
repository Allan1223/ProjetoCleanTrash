package ads.fafica.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.fafica.acao.reporte.AcaoReporte;
import ads.fafica.controlador.ControladorReporte;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.modelo.Reporte;

public class AcaoSolucionarReporte implements AcaoReporte {
	
	ControladorReporte controladorReporte;

	public AcaoSolucionarReporte() {

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
		int codigoReporte = Integer.parseInt(request.getParameter("id"));
		
		try {
			
			Reporte reporte = controladorReporte.procurarReporteId(codigoReporte);

			request.setAttribute("reporte", reporte);			

			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/gerarSolucao.jsp");
			dispatcher.forward(request, response);

		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
