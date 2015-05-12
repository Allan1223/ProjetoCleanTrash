package ads.fafica.repositorio;

import ads.fafica.controlador.IRepositorioReporte;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.modelo.Reporte;


public class RepositorioReporte implements IRepositorioReporte{
	
	private Reporte repositorioProblema;
	
	
	public void inserir(Reporte problema) throws RepositorioException{
			
		
	}
	
	public void remover(int codigoProblema) /*throws UsurioNaoEncontradoException */{ //Deixar espaço entre a chave  e o parentes.
		
		
	}

	public Reporte procurar(int codigoProblema) /*throws PessoaFisicaNaoEncontradaException*/{ //Deixar espaço entre a chave  e o parentes.
		return repositorioProblema;
	}

	
	public void atualizar(Reporte problema) /*throws PessoaFisicaNaoEncontradaException*/{ //Deixar espaço entre a chave  e o parentes.
	
	}

	
}
