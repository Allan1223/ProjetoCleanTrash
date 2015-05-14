package ads.fafica.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ads.fafica.controlador.IRepositorioSolucao;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.modelo.Solucao;
import ads.fafica.modelo.Usuario;

public class RepositorioSolucao implements IRepositorioSolucao{
	
	private Solucao repositorioSolucao;	
	private Connection conn = null;
	
    public RepositorioSolucao() throws Exception{        	    		
         this.conn = ConnectionManager.reservaStatement("mysql");                      
    } 
	public void inserir(Solucao solucao) throws RepositorioException {
			
	}	
	public void remover(int codigoSolucao) /*throws UsurioNaoEncontradoException */{ //Deixar espaço entre a chave  e o parentes.
		
	}
	public Solucao procurar(int codigoSolucao) /*throws PessoaFisicaNaoEncontradaException*/ { //Deixar espaço entre a chave  e o parentes.
		return repositorioSolucao;
	}
	public void atualizar(Solucao solucao)/*throws PessoaFisicaNaoEncontradaException*/{ //Deixar espaço entre a chave  e o parentes.
	
	}
	@Override
	public List<Solucao> listarSolucao() throws RepositorioException, SQLException {
		List<Solucao> solucoes = new ArrayList<Solucao>();

		PreparedStatement stmt=null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM SOLUCAO";
        	stmt = (PreparedStatement) this.conn.prepareStatement(sql);
        	rs = stmt.executeQuery();
        	
			
			while (rs.next()) {
				int codigoSolucao = rs.getInt("codigoSolucao");
				int codigoUsuario = rs.getInt("codigoUsuario");
				int codigoProblema= rs.getInt("codigoProblema");				
				String descricaoSolucao = rs.getString("descricaoSolucao");
				Time hrFechamentoSolucao = rs.getTime("hrFechamentoSolucao");
				Date dtFechamentoSolucao = rs.getDate("dtFechamentoSolucao");										
				
				Solucao solucao = new Solucao(codigoSolucao, codigoUsuario, codigoProblema, descricaoSolucao, hrFechamentoSolucao, dtFechamentoSolucao);
												
				solucoes.add(solucao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return solucoes;
	}

}
