package ads.fafica.controlador;

public class SolucaoNaoEncontradaException extends Exception{
	
	public SolucaoNaoEncontradaException(String valor) {
		super("Solucao " + valor + " não encontrada");
	}

}
