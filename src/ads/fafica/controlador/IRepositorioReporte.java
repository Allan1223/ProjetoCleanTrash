package ads.fafica.controlador;

import ads.fafica.modelo.Reporte;

public interface IRepositorioReporte {

	public void inserir(Reporte problema) throws RepositorioException; 

	public void remover(int codigoProblema) throws ProblemaNaoEncontradoException;

	public Reporte procurar(int codigoProblema) throws ProblemaNaoEncontradoException;

	public void atualizar(Reporte problema) throws ProblemaNaoEncontradoException;

	
}
