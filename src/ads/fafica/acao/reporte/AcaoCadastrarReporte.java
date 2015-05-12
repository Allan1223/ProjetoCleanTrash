package ads.fafica.acao.reporte;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.fafica.controlador.ControladorReporte;
import ads.fafica.controlador.ControladorUsuario;

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
		
		int codigoReporte = 1;
		String codigoUsuario   = request.getParameter("usuario");
		// todos os request.getParameter aqui
		
		
		//criar a instancia de Reporte
		
		
		
		//inserir Reporte no bd
		
		
		
		//dispachar para tela de listar Reporte

	}

}
