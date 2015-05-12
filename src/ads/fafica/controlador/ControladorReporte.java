package ads.fafica.controlador;

import ads.fafica.modelo.Reporte;
import ads.fafica.repositorio.RepositorioReporte;

public class ControladorReporte {
	
    private IRepositorioReporte repositorioProblema;
    
  //contrutor da classe
  	public ControladorReporte() {
  		// instancia o objeto RepositorioPessoaFisicaArray
  		this.repositorioProblema = new RepositorioReporte(); 
  	}
	
	public void inserirProblema (Reporte problema) throws RepositorioException {						
		repositorioProblema.inserir(problema);					
	}
	
	public void excluirProblema(int codigoProblema) throws ProblemaNaoEncontradoException {		
		repositorioProblema.remover(codigoProblema);		
	}
	
	public Reporte procurarProblema(int codigoProblema) throws ProblemaNaoEncontradoException {		
		return repositorioProblema.procurar(codigoProblema);		
	}
	
	public void alterarProblema(Reporte problema) throws ProblemaNaoEncontradoException {		
		repositorioProblema.atualizar(problema);		
	}	
	
}
