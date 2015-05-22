package ads.fafica.acao.reporte;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.fafica.controlador.ControladorReporte;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.modelo.Reporte;

public class AcaoListarReporte implements AcaoReporte {

	ControladorReporte controladorReporte;

	public AcaoListarReporte() {

		try {
			controladorReporte = new ControladorReporte();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void executarReporte(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int codigoUsuario = Integer.parseInt(request.getParameter("codigoUsuario"));

		try {

			List<Reporte> reporte = controladorReporte
					.listarReporte(codigoUsuario);

			request.setAttribute("reporte", reporte);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/status.jsp");
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
