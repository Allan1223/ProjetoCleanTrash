package ads.fafica.controlador;

import java.util.List;

import ads.fafica.modelo.Solucao;

public interface IRepositorioSolucao {	

	public void inserir(Solucao solucao) throws RepositorioException ; 

	public void remover(int codigoSolucao) throws SolucaoNaoEncontradaException;

	public Solucao procurar(int codigoSolucao) throws SolucaoNaoEncontradaException;

	public void atualizar(Solucao solucao) throws SolucaoNaoEncontradaException;
	
	public void listar(Solucao solucao) throws SolucaoNaoEncontradaException;

	public void listar(List<Solucao> solucao);

}
