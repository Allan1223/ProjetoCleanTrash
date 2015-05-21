package ads.fafica.controlador;

import java.sql.SQLException;
import java.util.List;

import ads.fafica.modelo.Usuario;
import ads.fafica.repositorio.RepositorioUsuario;

public class ControladorUsuario {

	private IRepositorioUsuario repositorioUsuario;

	//contrutor da classe
	public ControladorUsuario() throws Exception{
		// instancia o objeto RepositorioPessoaFisicaArray  		
		this.repositorioUsuario = new RepositorioUsuario(); 

	}

	public void inserirUsuario (Usuario usuario) throws RepositorioException, SQLException {		
		if(!repositorioUsuario.existe(usuario.getEmailUsuario()));			
		repositorioUsuario.inserir(usuario);			
	}	
	public void excluirUsuario(int codigoUsuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException {		
		repositorioUsuario.remover(codigoUsuario);		
	}	
	public List<Usuario> procurarUsuario(int codigoUsuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException {		
		return repositorioUsuario.procurarUsuario(codigoUsuario);		
	}	
	public Usuario procurarUsuarioId(int codigoUsuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException {		
		return repositorioUsuario.procurarUsuarioId(codigoUsuario);		
	}	
	public void atualizarUsuario(Usuario usuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException {		
		repositorioUsuario.atualizarUsuario(usuario);		
	}
	public List<Usuario> procurarUsuarioEmail(String email) throws UsuarioNaoEncontradoException, RepositorioException, SQLException {
		return repositorioUsuario.procurarUsuarioEmail(email);			
	}	
	public List<Usuario> procurarUsuario(String nome) throws UsuarioNaoEncontradoException, RepositorioException, SQLException {
		return repositorioUsuario.procurarUsuario(nome);			
	}	
	public Usuario acessoAoSistema(String email, String senha) throws UsuarioNaoEncontradoException, RepositorioException, SQLException {
		return repositorioUsuario.acessoAoSistema(email, senha);			
	}	
	public boolean existe(String email) throws RepositorioException, SQLException{
		return repositorioUsuario.existe(email);			
	}	
	public List<Usuario> listarUsuarios(){
		return repositorioUsuario.listarUsuarios();		
	}	
	public void atualizarSenha(Usuario usuario) throws RepositorioException, SQLException, UsuarioNaoEncontradoException{
		repositorioUsuario.atualizarSenha(usuario);
	}

}
