package ads.fafica.controlador;

import java.sql.Connection;
import java.sql.SQLException;

import ads.fafica.modelo.Usuario;
import ads.fafica.repositorio.ConnectionManager;

public class TesteConexao {
	
	public static void main(String[] args) throws Exception{


		ControladorUsuario controladorUsuario = new ControladorUsuario();
		
		 Connection conn = null;
		
	    
	    	    	    		
	    try {
			conn = ConnectionManager.reservaStatement("mysql");
			
			System.out.println("conectou!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	    Usuario usuario = new Usuario(1,"Allan Silva","allan@teste.com","123456",2);
		
		try {
			
			
			controladorUsuario.inserirUsuario(usuario);	
			
			System.out.println("agora");
			
		    
		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
			
		}
	       
	       
	       
	    
	    
	}
	
	

}
