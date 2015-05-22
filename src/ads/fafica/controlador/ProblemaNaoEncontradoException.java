package ads.fafica.controlador;

public class ProblemaNaoEncontradoException extends Exception {

	public ProblemaNaoEncontradoException(int codigoReporte) {
		super("Problema " + codigoReporte + " n�o encontrado");
	}

	public ProblemaNaoEncontradoException(String statusReporte) {
		super("Problema " + statusReporte + " n�o encontrado");
	}

}
