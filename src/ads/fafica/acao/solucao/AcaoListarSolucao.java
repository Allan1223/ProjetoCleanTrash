package ads.fafica.acao.solucao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.fafica.controlador.ControladorSolucao;
import ads.fafica.controlador.ControladorUsuario;
import ads.fafica.modelo.Solucao;
import ads.fafica.modelo.Usuario;

public class AcaoListarSolucao implements AcaoSolucao {

	ControladorSolucao controladorSolucao;
	@Override
	public void executarSolucao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		
		try {
			controladorSolucao = new ControladorSolucao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		List<Solucao> solucao = controladorSolucao.listarSolucao(solucao);
					
		request.setAttribute("solucao", solucao);
				
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/manUsuario.jsp");
		dispatcher.forward(request, response);


	}

}
