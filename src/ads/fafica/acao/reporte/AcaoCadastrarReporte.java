package ads.fafica.acao.reporte;

import java.io.IOException;
import java.sql.SQLException;

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

		int codigoReporte = Integer.parseInt(request.getParameter("codigoReporte"));
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



		Reporte reporte = new Reporte(codigoReporte, codigoUsuario,opcao,descricao,status,data, hora, latitude, longitude, cidade, bairro, rua );

		try {			
			//		boolean existe = controladorReporte.existe(reporte.getCodigoReporte());	

			//		if(!existe){				
			controladorReporte.inserirReporte(reporte);

			request.setAttribute("mensagem",
					"Reporte adicionado com sucesso!");

			RequestDispatcher dispatcher = request.getRequestDispatcher("controladorReporte?acao=listar");
			dispatcher.forward(request, response);
			/*	
			    // testa se o cadastro veio da página inicial
			    if(perfil.equals("ComumInicial")){

			    	request.getSession().invalidate();
			        HttpSession session = request.getSession(true);
			        session.setAttribute("usuario",usuario);

			    	RequestDispatcher dispatcher = request
							.getRequestDispatcher("/homeComum.jsp");
					dispatcher.forward(request, response);

				}

				else{
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("controladorReporte?acao=listar");
					dispatcher.forward(request, response);					
				}
			}

			else {

				request.setAttribute("mensagem",
						"Reporte já existe!");
				// retorna um erro
				request.setAttribute("validacaoUsuario","existe");
				// testa se o cadastro veio da página inicial para redirecionar a página
				if(perfil.equals("ComumInicial")){															
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);					
				}
				else{
					// controladorUsuario?acao=listar
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/cadastroUsuario.jsp");
					dispatcher.forward(request, response);
				}
			}
			 */	

		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
