package ads.fafica.modelo;

public class Perfil{

	private String nomePerfil;
	private int codigoPerfil;
	
	public Perfil (String nomePerfil, int codigoPerfil) {
		this.setNomePerfil(nomePerfil);
		this.setCodigoPerfil(codigoPerfil);
	}

	public String getNomePerfil() {
		return nomePerfil;
	}

	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}
	public int getCodigoPerfil() {
		return codigoPerfil;
	}
	
	public void setCodigoPerfil(int codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}	
}
