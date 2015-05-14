package ads.fafica.acao.solucao;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ads.fafica.controlador.ControladorSolucao;
import ads.fafica.controlador.ControladorUsuario;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.modelo.Solucao;
import ads.fafica.modelo.Usuario;
import ads.fafica.modelo.Perfil;

public class AcaoCadastrarSolucao implements AcaoSolucao {
	
	ControladorSolucao controladorSolucao;	
	
	public AcaoCadastrarSolucao(){		
		try {
			this.controladorSolucao = new ControladorSolucao();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
	}

	@Override
	public void executarSolucao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		
		int perfilUsuario, codigoUsuario = 1;
		
		String descricaoSolucao   = request.getParameter("descricaoSolucao");		
		
		if (descricaoSolucao.trim().isEmpty()){
			System.out.println("Solução não pode ser em branco");
		}
						
		if (perfil.equals("Operador"))
			perfilUsuario = 1;
		else
			perfilUsuario = 2;
			
		Solucao solucao = new Solucao(codigoSolucao, codigoUsuario, codigoProblema,	descricaoSolucao, hrFechamentoSolucao, dtFechamentoSolucao);
		
		try {			
			boolean existe = controladorSolucao.existe(solucao.getDescricaoSolucao()());	
			
			if(!existe){				
				controladorSolucao.inserirSolucao(solucao);
											
				request.setAttribute("mensagem",
						"Reporte encerrado!");
			
			    // testa se o cadastro veio da página inicial
			    if(perfil.equals("ComumInicial")){
			    	
			    	request.getSession().invalidate();
			        HttpSession session = request.getSession(true);
			        session.setAttribute("usuario", usuario);
			    	
			    	RequestDispatcher dispatcher = request
							.getRequestDispatcher("/listarSolucao.jsp");
					dispatcher.forward(request, response);
					
				}
			    
				else{
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("controladorSolucao?acao=listar");
					dispatcher.forward(request, response);					
				}
			}
			
			/*else {
				
				request.setAttribute("mensagem",
						"Usuario já existe!");
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
			}	*/		
					    
			} catch (RepositorioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
						
		}
}
}
