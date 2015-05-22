package ads.fafica.controlador;

public class ProblemaNaoEncontradoException extends Exception {

	public ProblemaNaoEncontradoException(int codigoReporte) {
		super("Problema " + codigoReporte + " não encontrado");
	}

	public ProblemaNaoEncontradoException(String statusReporte) {
		super("Problema " + statusReporte + " não encontrado");
	}

}
