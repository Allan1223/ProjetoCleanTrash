package ads.fafica.controlador;

import java.sql.SQLException;
import java.util.List;
import ads.fafica.modelo.Reporte;

public interface IRepositorioReporte {

	public void inserir(Reporte reporte) throws RepositorioException, SQLException; 

	public void remover(int codigoReporte) throws ProblemaNaoEncontradoException, RepositorioException, SQLException;

	public List<Reporte> procurarReporte(int codigoReporte,int codigoUsuario) throws ProblemaNaoEncontradoException, UsuarioNaoEncontradoException, RepositorioException, SQLException;

	public void atualizar(Reporte reporte) throws ProblemaNaoEncontradoException, RepositorioException,SQLException;

	public void atualizarStatus(int codigoProblema) throws RepositorioException,SQLException;

	public List<Reporte> listarReportes(int codigoUsuario) throws RepositorioException,SQLException;

	public Reporte procurarReporteId(int codigoReporte) throws RepositorioException, SQLException;

	public List<Reporte> listarReportesOperador()throws RepositorioException, SQLException, ProblemaNaoEncontradoException;



}
