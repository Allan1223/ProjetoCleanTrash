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

public class AcaoExcluirReporte implements AcaoReporte {


	ControladorReporte controladorReporte;

	public AcaoExcluirReporte(){

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

		int id = Integer.parseInt(request.getParameter("id"));


		try {
			//excluir usu�rio
			controladorReporte.excluirReporte(id);

		} catch (ProblemaNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("mensagem", "Reporte exclu�do com sucesso!");


		RequestDispatcher dispatcher = request.getRequestDispatcher("controladorReporte?acao=listar");
		dispatcher.forward(request, response);




	}

}
