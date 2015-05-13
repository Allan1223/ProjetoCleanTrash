package ads.fafica.controlador;

import java.sql.SQLException;

import ads.fafica.modelo.Reporte;
import ads.fafica.repositorio.RepositorioReporte;

public class ControladorReporte {
	
    private IRepositorioReporte repositorioReporte;
    
  //contrutor da classe
  	public ControladorReporte() {
  		// instancia o objeto RepositorioPessoaFisicaArray
  		this.repositorioReporte = new RepositorioReporte(); 
  	}
	
	public void inserirReporte (Reporte reporte) throws RepositorioException {						
		repositorioReporte.inserir(reporte);					
	}
	
	public void excluirReporte(int codigoReporte) throws ProblemaNaoEncontradoException, RepositorioException {		
		repositorioReporte.remover(codigoReporte);		
	}
	
	public Reporte procurarReporte(int codigoReporte) throws ProblemaNaoEncontradoException, RepositorioException {		
		return repositorioReporte.procurar(codigoReporte);		
	}
	
	
	
	public void alterarReporte(Reporte reporte) throws ProblemaNaoEncontradoException {		
		repositorioReporte.atualizar(reporte);		
	}	
	
}
