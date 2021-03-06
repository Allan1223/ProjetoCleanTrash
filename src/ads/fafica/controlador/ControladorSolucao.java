package ads.fafica.controlador;

import java.sql.SQLException;
import java.util.List;

import ads.fafica.modelo.Solucao;
import ads.fafica.repositorio.RepositorioSolucao;

public class ControladorSolucao {	

	private IRepositorioSolucao repositorioSolucao;

	//contrutor da classe
	public ControladorSolucao() throws Exception{
		// instancia o objeto RepositorioPessoaFisicaArray
		this.repositorioSolucao = new RepositorioSolucao(); 
	}	
	public void inserirSolucao (Solucao solucao) throws RepositorioException, SQLException {			
		repositorioSolucao.inserirSolucao(solucao);			
	}	
	public void excluirSolucao(int codigoSolucao) throws SolucaoNaoEncontradaException {		
		repositorioSolucao.remover(codigoSolucao);		
	}
	public List<Solucao> procurarSolucao(int codigoSolucao) throws SolucaoNaoEncontradaException, RepositorioException, SQLException {		
		return repositorioSolucao.procurarSolucao(codigoSolucao);		
	}
	
	public List<Solucao> listarSolucao() throws RepositorioException, SQLException {
		return repositorioSolucao.listarSolucao(); 
	}

}
