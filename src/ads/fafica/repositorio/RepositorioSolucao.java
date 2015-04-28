package ads.fafica.repositorio;

import ads.fafica.controlador.IRepositorioSolucao;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.modelo.Solucao;

public class RepositorioSolucao implements IRepositorioSolucao{
	
	private Solucao repositorioSolucao;	
	
	public void inserir(Solucao solucao) throws RepositorioException {
			
	}
	
	public void remover(int codigoSolucao) /*throws UsurioNaoEncontradoException */{ //Deixar espaço entre a chave  e o parentes.
		
	}

	public Solucao procurar(int codigoSolucao) /*throws PessoaFisicaNaoEncontradaException*/ { //Deixar espaço entre a chave  e o parentes.
		return repositorioSolucao;
	}
	
	public void atualizar(Solucao solucao)/*throws PessoaFisicaNaoEncontradaException*/{ //Deixar espaço entre a chave  e o parentes.
	
	}

}
