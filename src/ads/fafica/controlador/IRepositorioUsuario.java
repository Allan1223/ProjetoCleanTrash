package ads.fafica.controlador;

import java.sql.SQLException;

import ads.fafica.modelo.Usuario;

public interface IRepositorioUsuario {
	
	public void inserir(Usuario usuario) throws RepositorioException, SQLException; 

	public void remover(int codigoUsuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException;

	public Usuario procurar(int codigoUsuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException;

	public void atualizar(Usuario usuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException;

	public boolean existe(String email) throws RepositorioException, SQLException;
	
	public boolean existe(int codigoUsuario) throws RepositorioException, SQLException;
	
	public boolean acessoAoSistema(String emailUsuario, String senha) throws RepositorioException, SQLException, UsuarioNaoEncontradoException;

	public Usuario procurar(String email) throws UsuarioNaoEncontradoException, RepositorioException, SQLException;
		
			

}
