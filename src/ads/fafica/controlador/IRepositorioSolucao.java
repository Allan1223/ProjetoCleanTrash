package ads.fafica.controlador;

import java.sql.SQLException;
import java.util.List;

import ads.fafica.modelo.Solucao;

public interface IRepositorioSolucao {	

	public void inserirSolucao(Solucao solucao) throws RepositorioException, SQLException; 

	public void remover(int codigoSolucao) throws SolucaoNaoEncontradaException;

	public Solucao procurar(int codigoSolucao) throws SolucaoNaoEncontradaException;

	public void atualizar(Solucao solucao) throws SolucaoNaoEncontradaException;

	public List<Solucao> listarSolucao() throws RepositorioException, SQLException;

}
