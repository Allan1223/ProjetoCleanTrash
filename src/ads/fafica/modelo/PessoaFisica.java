package ads.fafica.modelo;

public class PessoaFisica extends Pessoa {
	
	private String cpf;
			
	public PessoaFisica(int codigoPessoa, String nome, String endereco, String cpf){
		this.nome = nome;
		this.codigoPessoa = codigoPessoa;
		this.endereco = endereco;
		this.cpf      = cpf;
		
		
	}
	
	
	
}
