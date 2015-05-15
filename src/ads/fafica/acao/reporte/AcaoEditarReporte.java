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
import ads.fafica.controlador.UsuarioNaoEncontradoException;
import ads.fafica.modelo.Reporte;
import ads.fafica.modelo.Usuario;

public class AcaoEditarReporte implements AcaoReporte {

	ControladorReporte controladorReporte;
	
	public AcaoEditarReporte(){
		
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
		
		int  codigoReporte = Integer.parseInt(request.getParameter("codigoReporte"));
		int codigoUsuario   = Integer.parseInt(request.getParameter("codigoUsuario"));
		String status = "";
		String data = "";
		String hora = "";
		String latitude  ="";
		String longitude = "";
		String opcao  = request.getParameter("opcao");
		String rua  = request.getParameter("rua");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String descricao = request.getParameter("descricao");
				
		
		Reporte reporte = new Reporte(codigoReporte, codigoUsuario,opcao,descricao,status,data, hora, latitude, longitude, cidade, bairro, rua );

		
		try {
			controladorReporte.alterarReporte(reporte);
			
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("controladorReporte?acao=listar");
			dispatcher.forward(request, response);
			
		} catch (ProblemaNaoEncontradoException e) {
			
			e.printStackTrace();
		}
		
		catch (RepositorioException e) {
			
			e.printStackTrace();
		}
		
		

	}

}
