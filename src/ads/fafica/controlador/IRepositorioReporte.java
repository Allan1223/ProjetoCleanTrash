package ads.fafica.controlador;

import java.sql.SQLException;
import java.util.List;

import ads.fafica.modelo.Reporte;
import ads.fafica.modelo.Usuario;

public interface IRepositorioReporte {

	public void inserir(Reporte reporte) throws RepositorioException; 

	public void remover(int codigoReporte) throws ProblemaNaoEncontradoException, RepositorioException;

	public List<Reporte> procurarReporte(int codigoReporte) throws ProblemaNaoEncontradoException;

	public void atualizar(Reporte reporte) throws ProblemaNaoEncontradoException;

	public void atualizarStatus(int codigoProblema) throws RepositorioException,SQLException;

	
}
