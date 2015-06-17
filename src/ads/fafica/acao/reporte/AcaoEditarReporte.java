package ads.fafica.acao.reporte;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

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

	public AcaoEditarReporte() {

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

		java.util.Date date = new java.util.Date();

		int codigoReporte = Integer.parseInt(request
				.getParameter("codigoReporte"));
		int codigoUsuario = Integer.parseInt(request
				.getParameter("codigoUsuario"));
		int status = 0;

		// Data e Hora não serão editados
		Date dtAberturaReporte = new java.sql.Date(
				new java.util.Date().getTime());
		;
		Time hrAberturaReporte = new java.sql.Time(date.getTime());
		// valores de longitude e latitude virão do googleMaps
		String latitude = request.getParameter("txtLatitude");
		String longitude = request.getParameter("txtLongitude");
		// **********************
		String tipoReporte = request.getParameter("tipo");
		String endereco = request.getParameter("txtEndereco");
		/*String rua = request.getParameter("rua");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");*/
		String descricaoReporte = request.getParameter("descricao");

		Reporte reporte = new Reporte(codigoReporte, codigoUsuario,
				tipoReporte, descricaoReporte, status, dtAberturaReporte,
				hrAberturaReporte, latitude, longitude, endereco);


		try {
			controladorReporte.alterarReporte(reporte);

			request.setAttribute("mensagem", "alterar");
			
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("controladorReporte?acao=listar&codigoUsuario="
						+ codigoUsuario);
			dispatcher.forward(request, response);

		} catch (ProblemaNaoEncontradoException e) {
			e.printStackTrace();		}

		catch (RepositorioException e) {
			e.printStackTrace();		}

	}

}
