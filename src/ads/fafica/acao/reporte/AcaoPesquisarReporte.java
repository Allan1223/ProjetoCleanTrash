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
import ads.fafica.modelo.Usuario;

public class AcaoPesquisarReporte implements AcaoReporte {

	ControladorReporte controladorReporte;
	
	
	public AcaoPesquisarReporte(){

		try {
			this.controladorReporte = new ControladorReporte();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void executarReporte(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {

		String pesquisa = request.getParameter("pesquisa");
		int codigoUsuario = Integer.parseInt(request.getParameter("user"));
		
		if (pesquisa != ""){

			int codigoReporte = Integer.parseInt(pesquisa);


			try {


				List<Reporte> reporte = controladorReporte.procurarReporte(codigoReporte, codigoUsuario);

				request.setAttribute("reporte", reporte);	

				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/status.jsp");
				dispatcher.forward(request, response);


			} catch (ProblemaNaoEncontradoException e) {
				// TODO Auto-generated catch block

				request.setAttribute("reportes", null);	
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/status.jsp");
				dispatcher.forward(request, response);


				e.printStackTrace();
			} catch (RepositorioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{


			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/controladorReporte?acao=listar&usuario=" + codigoUsuario);
			dispatcher.forward(request, response);
		}


	}

}
