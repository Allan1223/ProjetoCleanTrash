package ads.fafica.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import ads.fafica.controlador.IRepositorioUsuario;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.controlador.UsuarioNaoEncontradoException;
import ads.fafica.modelo.Usuario;

public class RepositorioUsuario implements IRepositorioUsuario{
	
	private Usuario repositorioUsuario;
	
	private java.sql.Connection conn = null;
	
    public RepositorioUsuario() throws Exception {
    	    	    		
       this.conn = ConnectionManager.reservaStatement("mysql");   	
    }
	
	//@Override
	public void inserir(Usuario usuario) throws RepositorioException {
	    	
		/*
		PreparedStatement stmt=null;
	        if (usuario != null) {
	            try {
	            	
	            	          	
	            	String sql = "INSERT INTO USUARIO (nome, apelido, email, idade, altura, nivel, senha, tipo, sexo )"
	            			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            	
	            	           	
	            	stmt = this.conn.prepareStatement(sql);
	            	
	            	stmt.setString(1, usuario.getNome());
	            	stmt.setString(2, usuario.getApelido());
	            	stmt.setString(3, usuario.getEmail());
	            	stmt.setInt(4, usuario.getIdade());
	            	stmt.setFloat(5, usuario.getAltura());
	            	stmt.setInt(6, usuario.getNivel());
	            	stmt.setString(7, usuario.getSenha());
	            	stmt.setInt(8, usuario.getTipo());
	            	stmt.setInt(9, usuario.getSexo());
	            	stmt.execute();
	            	
	            
	            	
	            }
	            catch (SQLException e) {
	                throw new RepositorioException(e);
			    }
	            finally {
	    			stmt.close();
	    		}
	        }    
		*/
	}	

	//@Override
	public void remover(int codigoUsuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException {
		
		/*PreparedStatement stmt=null;
        try{
        	String sql = "DELETE FROM USUARIO WHERE cod_usuario = ?"; 
        	stmt = (PreparedStatement) this.conn.prepareStatement(sql);
        	stmt.setInt(1, cod_usuario);
        	stmt.execute();
		} catch(SQLException e){
            throw new RepositorioException(e);
		} finally {
			stmt.close();
		}*/
	}

	//@Override
	public Usuario procurar(int codigoUsuario) throws UsuarioNaoEncontradoException,RepositorioException, SQLException {
   	   
		/*Usuario usuario = null;
   	    PreparedStatement stmt=null;
		ResultSet rs = null;
        try {
        	String sql = "SELECT * FROM USUARIO WHERE idUsuario = ?";
        	stmt = (PreparedStatement) this.conn.prepareStatement(sql);
        	stmt.setInt(1, cod_usuario);
        	rs = stmt.executeQuery();
        	
        	        	
        	if (!rs.next()) throw new UsuarioNaoEncontradoException(cod_usuario);
            usuario = new Usuario(rs.getInt("idUsuario"), rs.getString("nome"), rs.getString("apelido"),rs.getInt("tipo"), rs.getString("email"), rs.getString("senha"), rs.getInt("sexo"), rs.getInt("altura"),rs.getInt("idade"), rs.getInt("nivel"));
        } catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {
			stmt.close();
			rs.close();
		}*/
        
		return repositorioUsuario;
	}
	
	public Usuario procurar(String emailUsuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException {
   	   /* Usuario usuario = null;
   	    PreparedStatement stmt=null;
		ResultSet rs = null;
        try {
        	String sql = "SELECT * FROM USUARIO WHERE email = ?";
        	stmt = this.conn.prepareStatement(sql);
        	stmt.setString(1, email);
        	rs = stmt.executeQuery();
        	
        	        	
        	if (!rs.next()) throw new UsuarioNaoEncontradoException();
            usuario = new Usuario(rs.getInt("idUsuario"), rs.getString("nome"), rs.getString("apelido"),rs.getInt("tipo"), rs.getString("email"), rs.getString("senha"), rs.getInt("sexo"),rs.getInt("idade"), rs.getInt("altura"), rs.getInt("nivel"));
        } catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {
			stmt.close();
			rs.close();
		}*/
        
		return repositorioUsuario;
	}

	//@Override
	public void atualizar(Usuario usuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException {
			/*PreparedStatement stmt=null;
		    try {
	            if (usuario != null) {
	                try {
	                	String sql = "UPDATE USUARIO SET nome = ?, apelido = ?, email = ?, idade = ?, altura = ?, nivel = ?, sexo = ?, tipo = ?"
	                			+ " where idUsuario = ?  ";
	                	  
	                	
	                	stmt = this.conn.prepareStatement(sql);
	                	               	
	                	
	                	stmt.setString(1, usuario.getNome());
	                	stmt.setString(2, usuario.getApelido());
	                	stmt.setString(3, usuario.getEmail());
	                	stmt.setInt(4, usuario.getIdade());
	                	stmt.setFloat(5, usuario.getAltura());
	                	stmt.setInt(6, usuario.getNivel());
	                	stmt.setInt(7, usuario.getSexo());
	                	stmt.setInt(8, usuario.getTipo());
	                	stmt.setInt(9, usuario.getIdUsuario());
	                	                	
	                	Integer resultado = stmt.executeUpdate();
	                    if (resultado == 0) throw new UsuarioNaoEncontradoException(usuario.getIdUsuario());
	                }
	                catch (SQLException e) {
	    			    throw new RepositorioException(e);
	    		    }
	            }
	        } finally {
	        	stmt.close();
			}*/
	}

	//@Override
	public boolean existe(int codigoUsuario) {
		boolean resposta = false;
        /*if (getIndice(cod_usuario) >= 0) resposta = true;
        else resposta = false;*/
        return resposta;
        
        /*
        PreparedStatement stmt=null;
		ResultSet rs = null;
        try {
        	String sql = "SELECT count(*) as quantidade FROM USUARIO WHERE email = ?";
        	stmt = this.conn.prepareStatement(sql);
        	stmt.setString(1, email);
        	
        	rs = stmt.executeQuery();
        	rs.next();
        	if (rs.getInt("quantidade") == 0) return false;
        	else return true;
        	
        } catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {
			stmt.close();
        	rs.close();
		}*/
	}
	
	private int getIndice(String cpf) {
        int resposta = -1;
        /*boolean achou = false;
        for (int i = 0; !achou && (i < indice); i = i + 1) {
            if (pessoaFisica[i].getCpf().equals(cpf)) {
                resposta = i;
                achou = true;
            }
        }*/
        return resposta;
    }



	public boolean acessoAoSistema(String emailUsuario, String senha) throws RepositorioException, SQLException, UsuarioNaoEncontradoException {
		/*Usuario usuario = null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
	    try {
	    	String sql = "SELECT count(*) as quantidade FROM USUARIO WHERE email = ? and senha = ?";
	    	stmt = (PreparedStatement) this.conn.prepareStatement(sql);
	    	stmt.setString(1, email);
	    	stmt.setString(2, senha);
	    	
	    	rs = stmt.executeQuery();
	    	rs.next();
	    	if (rs.getInt("quantidade") == 0) return false;
	    	else return true;
	    	
	    } catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {
			stmt.close();
	    	rs.close();
		}*/
	    
	    return true;
		
		
	}
}