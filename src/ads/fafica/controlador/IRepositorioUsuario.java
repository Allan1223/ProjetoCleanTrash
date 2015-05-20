package ads.fafica.controlador;

import java.sql.SQLException;
import java.util.List;

import ads.fafica.modelo.Usuario;

public interface IRepositorioUsuario {

	public void inserir(Usuario usuario) throws RepositorioException, SQLException; 

	public void remover(int codigoUsuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException;

	public List<Usuario> procurarUsuario(int codigoUsuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException;

	public void atualizarUsuario(Usuario usuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException;

	public boolean existe(String email) throws RepositorioException, SQLException;

	public boolean existe(int codigoUsuario) throws RepositorioException, SQLException;

	public Usuario acessoAoSistema(String emailUsuario, String senha) throws RepositorioException, SQLException, UsuarioNaoEncontradoException;

	public Usuario procurar(String email) throws UsuarioNaoEncontradoException, RepositorioException, SQLException;

	public List<Usuario> listarUsuarios();

	public void atualizarSenha(Usuario usuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException;

	public Usuario procurarUsuarioId(int codigoUsuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException;

	public List<Usuario> procurarUsuarioEmail(String email) throws UsuarioNaoEncontradoException, RepositorioException, SQLException;
	
	public List<Usuario> procurarUsuarioNome(String nome) throws UsuarioNaoEncontradoException, RepositorioException, SQLException;
 


}
