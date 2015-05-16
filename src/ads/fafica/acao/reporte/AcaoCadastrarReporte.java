package ads.fafica.acao.reporte;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.security.util.Length;
import ads.fafica.controlador.ControladorReporte;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.modelo.Reporte;
import ads.fafica.modelo.Usuario;

public class AcaoCadastrarReporte implements AcaoReporte {

	ControladorReporte controladorReporte;

	public AcaoCadastrarReporte(){

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
		// TODO Auto-generated method stub
		
		java.util.Date date = new java.util.Date(); 
		 

		int codigoReporte = 1;
		int codigoUsuario   = Integer.parseInt(request.getParameter("codigoUsuario"));
		int status = 0;
		Date dtAberturaReporte= new java.sql.Date(new java.util.Date().getTime()); ;
		Time hrAberturaReporte = new java.sql.Time(date.getTime());
		// valores de longitude e latitude virão do googleMaps
		String latitude  = "";
		String longitude = "";
		//**********************
		String tipoReporte  = request.getParameter("tipo");
		String rua  = request.getParameter("rua");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String descricaoReporte = request.getParameter("descricao");



		Reporte reporte = new Reporte(codigoReporte, codigoUsuario,tipoReporte,descricaoReporte,status,dtAberturaReporte, hrAberturaReporte, latitude, longitude, cidade, bairro, rua );

		try {			
							
			controladorReporte.inserirReporte(reporte);

			request.setAttribute("mensagem",
					"Reporte adicionado com sucesso!");

			RequestDispatcher dispatcher = request.getRequestDispatcher("controladorReporte?acao=listar");
			dispatcher.forward(request, response);
			
		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
