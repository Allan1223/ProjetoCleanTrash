package ads.fafica.repositorio;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;





import ads.fafica.controlador.IRepositorioUsuario;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.controlador.UsuarioNaoEncontradoException;
import ads.fafica.modelo.Usuario;

public class RepositorioUsuario implements IRepositorioUsuario{
	
	private Usuario repositorioUsuario;
	
	private Connection conn = null;
	
    public RepositorioUsuario() throws Exception{
    	    	    		
    	
    	/*try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CleanTrash", "root", "admin");
			//conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_projeto_mvc", "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
       this.conn = ConnectionManager.reservaStatement("mysql"); 
       
       
       
    }
	
	//@Override
	public void inserir(Usuario usuario) throws RepositorioException, SQLException {
	    	
		
		PreparedStatement stmt=null;
	        if (usuario != null) {
	            try {
	            	
	            	          	
	            	String sql = "INSERT INTO USUARIO (nome, email, senha, perfil )"
	            			+ " VALUES (?, ?, ?, ?)";
	            	
	            	           	
	            	stmt = (PreparedStatement) this.conn.prepareStatement(sql);
	            	
	            	//stmt.setInt(1, usuario.getCodigoUsuario());
	            	stmt.setString(1, usuario.getNomeUsuario());
	            	stmt.setString(2, usuario.getEmailUsuario());
	            	stmt.setString(3, usuario.getSenha());
	            	stmt.setInt(4, usuario.getPerfilUsuario());
	            		            	
	            	stmt.execute();
	            	
	            
	            	
	            }
	            catch (SQLException e) {
	                throw new RepositorioException(e);
			    }
	            finally {
	    			stmt.close();
	    		}
	        }    
		
	}	

	//@Override
	public void remover(int codigoUsuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException {
		
		PreparedStatement stmt=null;
        try{
        	String sql = "DELETE FROM USUARIO WHERE codigoUsuario = ?"; 
        	stmt = (PreparedStatement) this.conn.prepareStatement(sql);
        	stmt.setInt(1, codigoUsuario);
        	stmt.execute();
		} catch(SQLException e){
            throw new RepositorioException(e);
		} finally {
			stmt.close();
		}
	}

	//@Override
	public Usuario procurar(int codigoUsuario) throws UsuarioNaoEncontradoException,RepositorioException, SQLException {
   	   
		Usuario usuario = null;
   	    PreparedStatement stmt=null;
		ResultSet rs = null;
        try {
        	String sql = "SELECT * FROM USUARIO WHERE codigoUsuario = ?";
        	stmt = (PreparedStatement) this.conn.prepareStatement(sql);
        	stmt.setInt(1, codigoUsuario);
        	rs = stmt.executeQuery();
        	
        	        	
        	if (!rs.next()) throw new UsuarioNaoEncontradoException(codigoUsuario);
            usuario = new Usuario(rs.getInt("codigoUsuario"), rs.getString("nome"), rs.getString("email"),rs.getString("senha"), rs.getInt("perfil"));
            
            
        } catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {
			
			stmt.close();
			rs.close();
			
		}
        
        return usuario;
        
		
	}
	
	public Usuario procurar(String emailUsuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException {
   	    Usuario usuario = null;
   	    PreparedStatement stmt=null;
		ResultSet rs = null;
        try {
        	String sql = "SELECT * FROM USUARIO WHERE email = ?";
        	stmt = (PreparedStatement) this.conn.prepareStatement(sql);
        	stmt.setString(1, emailUsuario);
        	rs = stmt.executeQuery();
        	
        	        	
        	if (!rs.next()) throw new UsuarioNaoEncontradoException();
        	usuario = new Usuario(rs.getInt("codigoUsuario"), rs.getString("nome"), rs.getString("email"),rs.getString("senha"), rs.getInt("perfil"));
        } catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {
			stmt.close();
			rs.close();
		}
        
        return usuario;
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
		public void atualizarSenha(Usuario usuario) throws UsuarioNaoEncontradoException, RepositorioException, SQLException {
				PreparedStatement stmt=null;
			    try {
		            if (usuario != null) {
		                try {
		                	String sql = "UPDATE USUARIO SET nome = ?, senha = ?"
		                			+ " where codigoUsuario = ?  ";
		                	  
		                	
		                	stmt = this.conn.prepareStatement(sql);
		                	               	
		                	
		                	stmt.setString(1, usuario.getNomeUsuario());
		                	stmt.setString(2, usuario.getSenha());
		                	stmt.setInt(3, usuario.getCodigoUsuario());
		                	
		                	                	
		                	Integer resultado = stmt.executeUpdate();
		                    if (resultado == 0) throw new UsuarioNaoEncontradoException();
		                }
		                catch (SQLException e) {
		    			    throw new RepositorioException(e);
		    		    }
		            }
		        } finally {
		        	stmt.close();
				}
		}

		
	//@Override
	public boolean existe(String emailUsuario) throws RepositorioException, SQLException {
		/*boolean resposta = false;
        if (getIndice(codigoUsuario) >= 0) resposta = true;
        else resposta = false;
        return resposta;*/
        
        
        PreparedStatement stmt=null;
		ResultSet rs = null;
        try {
        	String sql = "SELECT count(*) as quantidade FROM USUARIO WHERE email = ?";
        	stmt = (PreparedStatement) this.conn.prepareStatement(sql);
        	stmt.setString(1, emailUsuario);
        	
        	rs = stmt.executeQuery();
        	rs.next();
        	if (rs.getInt("quantidade") == 0) return false;
        	else return true;
        	
        } catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {
			stmt.close();
        	rs.close();
		}
	}
	
	public boolean existe(int codigoUsuario) throws RepositorioException, SQLException {
		/*boolean resposta = false;
        if (getIndice(codigoUsuario) >= 0) resposta = true;
        else resposta = false;
        return resposta;*/
        
        
        PreparedStatement stmt=null;
		ResultSet rs = null;
        try {
        	String sql = "SELECT count(*) as quantidade FROM USUARIO WHERE codigoUsuario = ?";
        	stmt = (PreparedStatement) this.conn.prepareStatement(sql);
        	stmt.setInt(1, codigoUsuario);
        	
        	rs = stmt.executeQuery();
        	rs.next();
        	if (rs.getInt("quantidade") == 0) return false;
        	else return true;
        	
        } catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {
			stmt.close();
        	rs.close();
		}
	}
	
	/*private int getIndice(int codigoUsuario) {
        int resposta = -1;
        /*boolean achou = false;
        for (int i = 0; !achou && (i < indice); i = i + 1) {
            if (pessoaFisica[i].getCpf().equals(cpf)) {
                resposta = i;
                achou = true;
            }
        }*/
      
   



	public Usuario acessoAoSistema(String emailUsuario, String senha) throws RepositorioException, SQLException, UsuarioNaoEncontradoException {
		
		Usuario usuario = null;
   	    PreparedStatement stmt=null;
		ResultSet rs = null;
        try {
        	
        	
        	String sql = "SELECT * FROM USUARIO WHERE email = ? and senha = ?";
        	stmt = (PreparedStatement) this.conn.prepareStatement(sql);
        	stmt.setString(1, emailUsuario);
	    	stmt.setString(2, senha);
        	rs = stmt.executeQuery();
        	        	        	
        	if (!rs.next()) throw new UsuarioNaoEncontradoException();
            usuario = new Usuario(rs.getInt("codigoUsuario"), rs.getString("nome"), rs.getString("email"),rs.getString("senha"), rs.getInt("perfil"));
                       
            
        } catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {
			stmt.close();
			rs.close();
		}
        
        return usuario;
		/*Usuario usuario = null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
	    try {
	    	String sql = "SELECT count(*) as quantidade FROM USUARIO WHERE email = ? and senha = ?";
	    	stmt = (PreparedStatement) this.conn.prepareStatement(sql);
	    	stmt.setString(1, emailUsuario);
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
	    
	    
		
		
	}
	
	@Override
	public List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		PreparedStatement stmt=null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM USUARIO";
        	stmt = (PreparedStatement) this.conn.prepareStatement(sql);
        	rs = stmt.executeQuery();
        	
			
			while (rs.next()) {
				int codigoUsuario = rs.getInt("codigoUsuario");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				int perfil = rs.getInt("perfil");
								
				
				Usuario usuario = new Usuario(codigoUsuario,nome,email,senha,perfil);
								
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	
	
	
}