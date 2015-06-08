package ads.fafica.modelo;

public class PessoaJuridica extends Pessoa {

	private String cnpj;
	
		
	public PessoaJuridica(int codigoPessoa, String nome, String endereco, String cnpj){
		this.nome = nome;
		this.codigoPessoa = codigoPessoa;
		this.endereco = endereco;
		this.cnpj      = cnpj;
		
		
	}
}
