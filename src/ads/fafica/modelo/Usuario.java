package ads.fafica.modelo;

public class Usuario {

	private int codigoUsuario;
	private String nomeUsuario;
	private String emailUsuario;
	private String senha;
	private int perfilUsuario;

	public Usuario(int codigoUsuario, String nomeUsuario, String emailUSuario,
			String senha, int perfilUsuario) {
		this.setCodigoUsuario(codigoUsuario);
		this.setNomeUsuario(nomeUsuario);
		this.setEmailUsuario(emailUSuario);
		this.setSenha(senha);
		this.setPerfilUsuario(perfilUsuario);

	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUSuario) {
		this.emailUsuario = emailUSuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(int perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

}
