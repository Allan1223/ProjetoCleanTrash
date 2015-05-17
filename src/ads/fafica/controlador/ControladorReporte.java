package ads.fafica.controlador;

import java.sql.SQLException;
import java.util.List;

import ads.fafica.modelo.Reporte;
import ads.fafica.modelo.Usuario;
import ads.fafica.repositorio.RepositorioReporte;

public class ControladorReporte {

	private IRepositorioReporte repositorioReporte;

	//contrutor da classe
	public ControladorReporte() throws Exception {
		// instancia o objeto RepositorioReporte
		this.repositorioReporte = new RepositorioReporte(); 
	}

	public void inserirReporte (Reporte reporte) throws RepositorioException, SQLException {						
		repositorioReporte.inserir(reporte);					
	}

	public void excluirReporte(int codigoReporte) throws ProblemaNaoEncontradoException, RepositorioException, SQLException {		
		repositorioReporte.remover(codigoReporte);		
	}

	public List<Reporte> procurarReporte(int codigoReporte, int codigoUsuario) throws ProblemaNaoEncontradoException, RepositorioException, UsuarioNaoEncontradoException, SQLException {		
		return repositorioReporte.procurarReporte(codigoReporte, codigoUsuario);		
	}

	public Reporte procurarReporteId(int codigoReporte) throws  RepositorioException, SQLException {		
		return repositorioReporte.procurarReporteId(codigoReporte);		
	}	

	public void alterarReporte(Reporte reporte) throws ProblemaNaoEncontradoException, RepositorioException, SQLException {		
		repositorioReporte.atualizar(reporte);		
	}

	public void atualizarStatus(int codigoProblema) throws RepositorioException, SQLException {
		repositorioReporte.atualizarStatus(codigoProblema);

	}

	public List<Reporte> listarReporte(int codigoUsuario) throws RepositorioException, SQLException{
		return repositorioReporte.listarReportes(codigoUsuario);		
	}

	public List<Reporte> listarReporteOperador() throws RepositorioException, SQLException, ProblemaNaoEncontradoException {
		return repositorioReporte.listarReportesOperador();	
	}

}
