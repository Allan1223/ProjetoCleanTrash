package ads.fafica.repositorio;

public class RepositorioException extends Exception{
/*Allan, por que existe essa mesma classe no pacote de Controlador?*/		
	    private Exception exception;

	    public RepositorioException(Exception exception) {
	        super("Exceção encapsulada");
	        this.exception = exception;
	    }

	    public String getMessage() {
	        return exception.getMessage();
	    }

	    public void printStackTrace() {
	        exception.printStackTrace();
	    }

}


