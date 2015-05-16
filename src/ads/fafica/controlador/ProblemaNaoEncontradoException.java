package ads.fafica.controlador;

public class ProblemaNaoEncontradoException extends Exception{

	public ProblemaNaoEncontradoException(String valor) {
		super("Problema " + valor + " não encontrado");
	}

}
