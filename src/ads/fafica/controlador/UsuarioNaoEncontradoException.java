package ads.fafica.controlador;

public class UsuarioNaoEncontradoException extends Exception{		
	
		public UsuarioNaoEncontradoException() {
			super("Usuario  não encontrado");
		}
		
		public UsuarioNaoEncontradoException(String valor) {
			super("Usuario " + valor + " não encontrado");
		}

}
