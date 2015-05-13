package ads.fafica.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Esta � uma classe auxiliar
 */
public class  ConnectionManager {

    private static Connection connection;
    private static Statement statement;

    public static Connection reservaStatement(String sistema) throws Exception {
    	
    	String conexao = "jdbc:mysql://localhost:3306/cleantrash";
    	String usuario = "root";
    	String senha = "admin";
    	    	   		
    	if (sistema == "mysql") {
    		
    		conexao = "jdbc:mysql://localhost:3306/cleantrash";
    		usuario = "root";
    		senha = "root";
    		    		
    	}
    	else if(sistema == "oracle") {
    		conexao = "jdbc:oracle:thin:@192.168.43.149:1521:XE";
    		usuario = "mauricio";
    		senha = "mauricio";    		
    	}
    	else if(sistema == "sqlserver") {
    		conexao = "jdbc:sqlserver://localhost:1433;databaseName=aula06";
    		//conexao = "jdbc:sqlserver://localhost\\localhost:1433;databaseName=aula06";
    		usuario = "poo";
    		senha = "poo";    		
    	}
    	else {
    		conexao = "";
    	}
    	
        if (connection == null) {
            try {
            	
            		
            	String driverName = "com.mysql.jdbc.Driver";                        

		    	Class.forName(driverName);
		    	
		    	
            	connection = DriverManager.getConnection(conexao, usuario, senha);
            	
            	//System.out.println("puta que pariu vei, Conectou porraaaa!");
            	           	
            	            	
	            //statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	    	} catch(SQLException e) {
	    		connection.close();
	    		//statement.close();
	    		throw new Exception("SQLException => ConnectionManager: " + e.getMessage());
	    	}
        }
        return connection;
    	//return statement;
    }
 
    /**
     * Aten��o, este m�todo fecha o Statement!
     * @throws SQLException 
     */
   public synchronized static void liberaStatement() throws SQLException {
        try {
            if (statement != null) statement.close();
	    } catch(SQLException e) {
	    	throw new SQLException("SQLException => ConnectionManager: " + e.getMessage());
	    }
	}

    public static void liberaRecursos() throws SQLException {
        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {
        	throw new SQLException("SQLException => ConnectionManager: " + e.getMessage());
        }
        try {
            //reservaStatement();
            //statement.executeUpdate("SHUTDOWN COMPACT");
            liberaStatement();
        } catch (SQLException e) {
        	throw new SQLException("SQLException => ConnectionManager: " + e.getMessage());
        }
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
        	throw new SQLException("SQLException => ConnectionManager: " + e.getMessage());
        }
        
    }

}

