package ads.fafica.controlador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TesteConexao {

	public static void main(String[] args) throws Exception{

		Connection connection = null;

		String conexao = "jdbc:mysql://localhost:3306/CleanTrash";
		String usuario = "root";
		String senha = "root";

		try {

			String driverName = "com.mysql.jdbc.Driver";                        

			Class.forName(driverName);

			connection = DriverManager.getConnection(conexao, usuario, senha);

			System.out.println("conetou");

			//statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch(SQLException e) {
			connection.close();
			//statement.close();
			throw new Exception("SQLException => ConnectionManager: " + e.getMessage());
		}


		/*		ControladorUsuario controladorUsuario = new ControladorUsuario();

		Connection conn = null;



	    try {
			conn = ConnectionManager.reservaStatement("mysql");

			System.out.println("conectou!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	    Usuario usuario = new Usuario(1,"Abenildo Sousa","abenildo@teste.com","111111",2);

		try {

			controladorUsuario.inserirUsuario(usuario);	

			System.out.println("agora");


		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


		}




		 */    
	}



}
