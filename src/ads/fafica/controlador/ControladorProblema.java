package ads.fafica.controlador;

import ads.fafica.modelo.Problema;
import ads.fafica.repositorio.RepositorioProblema;

public class ControladorProblema {
	
    private IRepositorioProblema repositorioProblema;
    
  //contrutor da classe
  	public ControladorProblema() {
  		// instancia o objeto RepositorioPessoaFisicaArray
  		this.repositorioProblema = new RepositorioProblema(); 
  	}
	
	public void inserirProblema (Problema problema) throws RepositorioException {						
		repositorioProblema.inserir(problema);					
	}
	
	public void excluirProblema(int codigoProblema) throws ProblemaNaoEncontradoException {		
		repositorioProblema.remover(codigoProblema);		
	}
	
	public Problema procurarProblema(int codigoProblema) throws ProblemaNaoEncontradoException {		
		return repositorioProblema.procurar(codigoProblema);		
	}
	
	public void alterarProblema(Problema problema) throws ProblemaNaoEncontradoException {		
		repositorioProblema.atualizar(problema);		
	}	
	
}
