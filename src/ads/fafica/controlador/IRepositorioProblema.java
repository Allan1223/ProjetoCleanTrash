package ads.fafica.controlador;

import ads.fafica.modelo.Problema;

public interface IRepositorioProblema {

	public void inserir(Problema problema) throws RepositorioException; 

	public void remover(int codigoProblema) throws ProblemaNaoEncontradoException;

	public Problema procurar(int codigoProblema) throws ProblemaNaoEncontradoException;

	public void atualizar(Problema problema) throws ProblemaNaoEncontradoException;

	
}
