package ads.fafica.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ads.fafica.controlador.IRepositorioReporte;
import ads.fafica.controlador.ProblemaNaoEncontradoException;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.controlador.UsuarioNaoEncontradoException;
import ads.fafica.modelo.Reporte;


public class RepositorioReporte implements IRepositorioReporte{
	
	private Reporte repositorioProblema;
	
	private Connection conn = null;
	
	public RepositorioReporte() throws Exception{
		this.conn = ConnectionManager.reservaStatement("mysql"); 	
		
	}
	
	public void inserir(Reporte problema) throws RepositorioException{
		
		 		
		
	}
	
	public void remover(int codigoProblema) /*throws UsurioNaoEncontradoException */{ //Deixar espaço entre a chave  e o parentes.
		
		
	}

	public Reporte procurar(int codigoProblema) /*throws PessoaFisicaNaoEncontradaException*/{ //Deixar espaço entre a chave  e o parentes.
		return repositorioProblema;
	}

	
	public void atualizar(Reporte problema) /*throws PessoaFisicaNaoEncontradaException*/{ //Deixar espaço entre a chave  e o parentes.
	
	}

	@Override
	public List<Reporte> procurarReporte(int codigoReporte)
			throws ProblemaNaoEncontradoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizarStatus(int codigoProblema)
			throws RepositorioException, SQLException {
		
		
		PreparedStatement stmt=null;
	    try {
           
                try {
                	String sql = "UPDATE Reporte SET statusReporte = ?"
                			+ " where codigoReporte = ?  ";
                	  
                	
                	stmt = this.conn.prepareStatement(sql);
                	               	
                	
                	stmt.setInt(1, 1);
                	stmt.setInt(2,codigoProblema);
                	     	
                	                	
                	Integer resultado = stmt.executeUpdate();
                    
                }
                catch (SQLException e) {
    			    throw new RepositorioException(e);
    		    }
            
        } finally {
        	stmt.close();
		}
		
	}

	
}
