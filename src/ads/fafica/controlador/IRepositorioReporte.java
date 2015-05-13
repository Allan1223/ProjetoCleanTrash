package ads.fafica.controlador;

import ads.fafica.modelo.Reporte;

public interface IRepositorioReporte {

	public void inserir(Reporte reporte) throws RepositorioException; 

	public void remover(int codigoReporte) throws ProblemaNaoEncontradoException, RepositorioException;

	public Reporte procurar(int codigoReporte) throws ProblemaNaoEncontradoException;

	public void atualizar(Reporte reporte) throws ProblemaNaoEncontradoException;

	
}
