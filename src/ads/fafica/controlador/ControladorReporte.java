package ads.fafica.controlador;

import java.sql.SQLException;
import java.util.List;

import ads.fafica.modelo.Reporte;
import ads.fafica.modelo.Usuario;
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
	
	public List<Reporte> procurarReporte(int codigoReporte) throws ProblemaNaoEncontradoException, RepositorioException {		
		return repositorioReporte.procurarReporte(codigoReporte);		
	}
	
	
	
	public void alterarReporte(Reporte reporte) throws ProblemaNaoEncontradoException {		
		repositorioReporte.atualizar(reporte);		
	}	
	
}
