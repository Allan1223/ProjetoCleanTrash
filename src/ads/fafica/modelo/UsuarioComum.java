package ads.fafica.modelo;

public class UsuarioComum extends Usuario{

	public UsuarioComum(int codigoUsuario, String nomeUsuario, String emailUsuario, String senha, Perfil perfilUsuario) {		
		super(codigoUsuario, nomeUsuario, emailUsuario, senha, perfilUsuario);	
				
		new Perfil("Operador do Comum",2);

	}
}
