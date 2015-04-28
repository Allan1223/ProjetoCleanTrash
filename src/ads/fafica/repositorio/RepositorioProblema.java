package ads.fafica.repositorio;

import ads.fafica.controlador.IRepositorioProblema;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.modelo.Problema;


public class RepositorioProblema implements IRepositorioProblema{
	
	private Problema repositorioProblema;
	
	
	public void inserir(Problema problema) throws RepositorioException{
			
		
	}
	


	public void remover(int codigoProblema) /*throws UsurioNaoEncontradoException */{ //Deixar espaço entre a chave  e o parentes.
		
		
	}

	public Problema procurar(int codigoProblema) /*throws PessoaFisicaNaoEncontradaException*/{ //Deixar espaço entre a chave  e o parentes.
		return repositorioProblema;
	}

	
	public void atualizar(Problema problema) /*throws PessoaFisicaNaoEncontradaException*/{ //Deixar espaço entre a chave  e o parentes.
	
	}

	
}
