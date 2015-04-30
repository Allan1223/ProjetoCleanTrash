package ads.fafica.controlador;

import java.sql.SQLException;

import ads.fafica.modelo.Usuario;
import ads.fafica.repositorio.RepositorioUsuario;

public class ControladorUsuario {

    private IRepositorioUsuario repositorioUsuario;
    
  //contrutor da classe
  	public ControladorUsuario() throws Exception {
  		// instancia o objeto RepositorioPessoaFisicaArray
  		this.repositorioUsuario = new RepositorioUsuario(); 
  	}
  	
	public void inserirUsuario (Usuario usuario) throws RepositorioException, SQLException {		
		if(!repositorioUsuario.existe(usuario.getEmailUSuario()));			
		repositorioUsuario.inserir(usuario);			
	}
	
	public void excluirUsuario(int codigoUsuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException {		
		if(repositorioUsuario.existe(codigoUsuario));		
		repositorioUsuario.remover(codigoUsuario);		
	}
	
	public Usuario procurarUsuario(int codigoUsuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException {		
		return repositorioUsuario.procurar(codigoUsuario);		
	}
	
	public void alterarUsuario(Usuario usuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException {		
		repositorioUsuario.atualizar(usuario);		
	}

	public Usuario procurarUsuario(String email) throws UsuarioNaoEncontradoException, RepositorioException, SQLException {
		return repositorioUsuario.procurar(email);	
		
	}
	
}
