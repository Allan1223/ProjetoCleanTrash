package ads.fafica.controlador;

public class UsuarioNaoEncontradoException extends Exception{		
	
		public UsuarioNaoEncontradoException() {
			super("Usuario  n�o encontrado");
		}
		
		public UsuarioNaoEncontradoException(String valor) {
			super("Usuario " + valor + " n�o encontrado");
		}

}
