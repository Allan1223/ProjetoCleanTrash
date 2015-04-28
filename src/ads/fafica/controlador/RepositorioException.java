package ads.fafica.controlador;

public class RepositorioException extends Exception{
/*Allan, por que existe essa mesma classe no pacote de Repositorio?*/
		
	    private Exception repositorioException;

	    public RepositorioException(Exception repositorioException) {
	        super("Exce��o encapsulada");
	        this.repositorioException = repositorioException;
	    }

	    public String getMessage() {
	        return repositorioException.getMessage();
	    }

	    public void printStackTrace() {
	    	repositorioException.printStackTrace();
	    }

}


