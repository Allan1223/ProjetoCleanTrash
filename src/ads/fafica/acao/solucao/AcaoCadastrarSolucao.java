package ads.fafica.acao.solucao;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ads.fafica.controlador.ControladorReporte;
import ads.fafica.controlador.ControladorSolucao;
import ads.fafica.controlador.ControladorUsuario;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.modelo.Solucao;
import ads.fafica.modelo.Usuario;
import ads.fafica.modelo.Perfil;

public class AcaoCadastrarSolucao implements AcaoSolucao {

	ControladorSolucao controladorSolucao;	
	ControladorReporte controladorReporte;

	public AcaoCadastrarSolucao(){		
		try {
			this.controladorSolucao = new ControladorSolucao();
			this.controladorReporte = new ControladorReporte();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
	}


	public static java.sql.Time getCurrentTime(){
		java.util.Date date = new java.util.Date(); 
		return new java.sql.Time(date.getTime());
	}
	@Override
	public void executarSolucao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {


		int codigoSolucao    = 1;
		int codigoUsuario    = Integer.parseInt(request.getParameter("codigoUsuario"));
		int codigoProblema   = Integer.parseInt(request.getParameter("codigoProblema"));
		String descricaoSolucao = request.getParameter("descricaoSolucao");

		Date dtFechamentoSolucao = new java.sql.Date(new java.util.Date().getTime());    
		SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-mm-dd");		
		//System.out.print("Data " + formatarDate.format(dtFechamentoSolucao) + "\n")

		java.sql.Time hrFechamentoSolucao = getCurrentTime();

		Solucao solucao = new Solucao(codigoSolucao, codigoUsuario, codigoProblema,
				descricaoSolucao, hrFechamentoSolucao, (java.sql.Date) dtFechamentoSolucao);

		try {							
			controladorSolucao.inserirSolucao(solucao);

			controladorReporte.atualizarStatus(codigoProblema);

			request.setAttribute("mensagem", "Reporte encerrado!");



			RequestDispatcher dispatcher = request.getRequestDispatcher("controladorSolucao?acao=listar");
			dispatcher.forward(request, response);	

		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
