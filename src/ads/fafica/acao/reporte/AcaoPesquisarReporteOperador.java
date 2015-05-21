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
import ads.fafica.controlador.UsuarioNaoEncontradoException;
import ads.fafica.modelo.Reporte;

public class AcaoPesquisarReporteOperador implements AcaoReporte {

	ControladorReporte controladorReporte;	
	int codigoReporte;
	int statusReporte;
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
				
		if (pesquisa != ""){

			int codigoReporte = Integer.parseInt(pesquisa);


			try {


				List<Reporte> reporte = controladorReporte.procurarReporteOperador(codigoReporte);

				request.setAttribute("reporte", reporte);	

				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/reportesOperador.jsp");
				dispatcher.forward(request, response);


			} catch (ProblemaNaoEncontradoException e) {
				// TODO Auto-generated catch block

				request.setAttribute("reportes", null);	
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/reportesOperador.jsp");
				dispatcher.forward(request, response);


				e.printStackTrace();
			} catch (RepositorioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else{


			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/controladorReporte?acao=listarReporteOperador");
			dispatcher.forward(request, response);
		}

	}

}
