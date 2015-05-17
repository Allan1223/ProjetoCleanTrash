package ads.fafica.controlador;

public class ProblemaNaoEncontradoException extends Exception{

	public ProblemaNaoEncontradoException(int codigoReporte) {
		super("Problema " + codigoReporte + " não encontrado");
	}

	
}
