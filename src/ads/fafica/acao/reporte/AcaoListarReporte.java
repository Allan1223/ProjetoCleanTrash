package ads.fafica.acao.reporte;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.fafica.controlador.ControladorReporte;
import ads.fafica.modelo.Reporte;

public class AcaoListarReporte implements AcaoReporte {
	
	ControladorReporte controladorReporte;
	
	public AcaoListarReporte(){
		
		try{
			this.controladorReporte = new ControladorReporte();
			
		}catch(Exception e){
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
		String data= "";
		String hora="";
		String latitude  ="";
		String longitude = "";
		String opcao  = request.getParameter("opcao");
		String rua  = request.getParameter("rua");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String descricao = request.getParameter("descricao");
		
		Reporte reporte = new Reporte(codigoReporte, codigoUsuario, status, data, hora, latitude, longitude, opcao, rua, bairro, cidade, descricao);
		
		//Corrigir aqui abaixo! seria interessante funcionar com o parametro reporte, mas quando usa fica
		//mostrando erros de incompatibilidade na classe controlador e interface reporte
		try {
			controladorReporte.procurarReporte(codigoReporte);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("controladorReporte?acao=listar");
		dispatcher.forward(request, response);

	}

}
