package ads.fafica.modelo;

public  class Usuario{

	private int codigoUsuario;
	private String nomeUsuario;
	private String emailUSuario;
	private String senha;
	/*private Perfil perfilUsuario;*/
	private int perfilUsuario;
	
	public Usuario(int codigoUsuario, String nomeUsuario, String emailUSuario, String senha, int perfilUsuario) {
		this.setCodigoUsuario(codigoUsuario);
		this.setNomeUsuario(nomeUsuario);
		this.setEmailUSuario(nomeUsuario);
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

	public String getEmailUSuario() {
		return emailUSuario;
	}

	public void setEmailUSuario(String emailUSuario) {
		this.emailUSuario = emailUSuario;
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
	

	/*public Perfil getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(Perfil perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}*/

	
}
